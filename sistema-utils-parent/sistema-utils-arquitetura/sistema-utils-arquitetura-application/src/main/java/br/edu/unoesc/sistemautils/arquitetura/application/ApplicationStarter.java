package br.edu.unoesc.sistemautils.arquitetura.application;

import java.text.MessageFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.hateoas.config.EnableHypermediaSupport.HypermediaType;

import br.edu.unoesc.sistemautils.arquitetura.business.IIdentityService;
import br.edu.unoesc.sistemautils.arquitetura.common.IEnumEntidade;
import br.edu.unoesc.sistemautils.arquitetura.common.IIdentityEntity;
import br.edu.unoesc.sistemautils.arquitetura.common.IRevisao;
import br.edu.unoesc.sistemautils.shared.business.RevisionEnumControlService;
import br.edu.unoesc.sistemautils.shared.common.RevisionEnumControl;
import brave.sampler.Sampler;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@EnableDiscoveryClient
@EnableAutoConfiguration
@EnableHypermediaSupport(type = { HypermediaType.HAL })
public abstract class ApplicationStarter {

	@Autowired
	private RevisionEnumControlService revisionService;

	private static AnnotationConfigApplicationContext applicationContext;
	
	private Long runCount = 0L;

	@EventListener(ApplicationStartedEvent.class)
	public <E extends IIdentityEntity<Long>, ENUM extends Enum<ENUM> & IEnumEntidade<E> & IRevisao> void doSomethingAfterStartup() {
		if(runCount.equals(1L)) {
			return;
		}
		
		applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.scan(getClass().getPackage().getName());
		applicationContext.refresh();
		
		log.info("Iniciou enumMigration");
		List<Class<ENUM>> enumList = getEnumList();
		for (Class<ENUM> enumClass : enumList) {
			migration(enumClass);
		}
		log.info("Finalizou enumMigration");
		
		runCount++;
	}

	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}

	public abstract <E extends IIdentityEntity<Long>, ENUM extends Enum<ENUM> & IEnumEntidade<E> & IRevisao> List<Class<ENUM>> getEnumList();

	public <E extends IIdentityEntity<Long>, ENUM extends Enum<ENUM> & IEnumEntidade<E> & IRevisao> void migration(Class<ENUM> enumClass) {
		Enum<?>[] valoresEnum = (Enum[]) enumClass.getEnumConstants();
		RevisionEnumControl revisionEnumControl = revisionService.findByDescricaoEnum(enumClass.getSimpleName());
		if(Objects.isNull(revisionEnumControl)) {
			revisionEnumControl = new RevisionEnumControl();

			revisionEnumControl.setRevisao(-1L);
			revisionEnumControl.setDataCriacao(new Date());
			revisionEnumControl.setDataAlteracao(new Date());
			revisionEnumControl.setDescricaoEnum(enumClass.getSimpleName());
			revisionEnumControl.setEnumHash(String.valueOf(enumClass.hashCode()));
			
			revisionEnumControl = revisionService.create(revisionEnumControl);
		}
		
		Long revisaoBanco = revisionEnumControl.getRevisao();
		Long revisaoEnum = ((IRevisao) valoresEnum[0]).getRevisao();
		if(Long.compare(revisaoBanco, revisaoEnum) < 0) {
			realizarAtualizacaoEnum(enumClass, valoresEnum, revisionEnumControl, revisaoBanco, revisaoEnum);
		}
		else if(Long.compare(revisaoBanco, revisaoEnum) > 0) {
			log.warn(MessageFormat.format("Classe: {0} | Revisão do Banco {1} | Revisão do Enum {2} | Classe inconsistente. Verifique.", 
					new Object [] { enumClass.getSimpleName(), revisaoBanco, revisaoEnum }));
		}
		else {
			String enumHash = revisionEnumControl.getEnumHash();
			String hashCode = String.valueOf(enumClass.hashCode());
			if(!enumHash.equalsIgnoreCase(hashCode)) {
				log.warn(MessageFormat.format("Classe: {0} | Revisão do Banco {1} | Revisão do Enum {2} | Classe alterada, HASH inconsistente. Verifique.", 
						new Object [] { enumClass.getSimpleName(), revisaoBanco, revisaoEnum }));
			}
		}
	}

	@SuppressWarnings("unchecked")
	private <E extends IIdentityEntity<Long>, ENUM extends Enum<ENUM> & IEnumEntidade<E> & IRevisao> void realizarAtualizacaoEnum(Class<ENUM> enumClass, Enum<?>[] valoresEnum, RevisionEnumControl revisionEnumControl, Long revisaoBanco, Long revisaoEnum) {
		log.info(MessageFormat.format("Classe: {0} | Revisão do Banco {1} | Revisão do Enum {2} | Atualizando...", 
				new Object [] { enumClass.getSimpleName(), revisaoBanco, revisaoEnum }));
		
		for (Enum<?> enumVal : valoresEnum) {
			E entidade = (E)((IEnumEntidade<?>) enumVal).getEntidade();
			String serviceClass = entidade.getClass().getName().concat("ServiceImpl");
			
			try {
				IIdentityService<E, Long> service = (IIdentityService<E,Long>) applicationContext.getBean(Class.forName(serviceClass));
				Optional<?> find = service.getOne(entidade.getId());
				if(find.isEmpty()) {
					entidade = service.create((E) entidade);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		revisionEnumControl.setRevisao(revisaoEnum);
		revisionEnumControl.setEnumHash(String.valueOf(enumClass.hashCode()));
		revisionService.update(revisionEnumControl);
	}
}
