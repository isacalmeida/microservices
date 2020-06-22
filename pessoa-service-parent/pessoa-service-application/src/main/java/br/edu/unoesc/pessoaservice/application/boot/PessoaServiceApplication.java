package br.edu.unoesc.pessoaservice.application.boot;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import br.edu.unoesc.pessoaservice.common.model.TipoContato;
import br.edu.unoesc.pessoaservice.common.model.enums.EnumTipoContato;
import br.edu.unoesc.sistemautils.arquitetura.application.ApplicationStarter;
import br.edu.unoesc.sistemautils.arquitetura.business.IIdentityService;
import br.edu.unoesc.sistemautils.arquitetura.common.IEnumEntidade;
import br.edu.unoesc.sistemautils.arquitetura.common.IIdentityEntity;
import br.edu.unoesc.sistemautils.arquitetura.common.IRevisao;
import br.edu.unoesc.sistemautils.arquitetura.constants.BasePackagesConstants;
import br.edu.unoesc.sistemautils.shared.business.RevisionEnumControlService;
import br.edu.unoesc.sistemautils.shared.common.RevisionEnumControl;
import lombok.extern.slf4j.Slf4j;

@EntityScan(BasePackagesConstants.PESSOA_SERVICE)
@ComponentScan(BasePackagesConstants.PESSOA_SERVICE)
@EnableJpaRepositories(BasePackagesConstants.PESSOA_SERVICE)
@SpringBootApplication(scanBasePackages = BasePackagesConstants.PESSOA_SERVICE)
@Slf4j
public class PessoaServiceApplication extends ApplicationStarter {

	private static AnnotationConfigApplicationContext applicationContext;

	public static void main(String[] args) {
		SpringApplication.run(PessoaServiceApplication.class, args);
		
		applicationContext = new AnnotationConfigApplicationContext();
	       
		applicationContext.scan(PessoaServiceApplication.class.getPackage().getName());
		applicationContext.refresh();
	}

	@Autowired
	private RevisionEnumControlService revisionService;

	public Map<String, Map<Long, Map<Long, String>>> getEnumList() {
		List<?> listEnum = new ArrayList<>();
		
		Map<Long,String> entidadeMap = new HashMap<>();
		
		List<EnumTipoContato> tipoContatoList = EnumTipoContato.getList();
		for (EnumTipoContato enumTipoContato : tipoContatoList) {
			TipoContato tipoContato = enumTipoContato.getEntidade();
			entidadeMap.put(tipoContato.getIdTipoContato(), tipoContato.getDescricao());
		}
		
		Map<Long, Map<Long, String>> revisaoMap = new HashMap<>();
		EnumTipoContato first = tipoContatoList.iterator().next();
		revisaoMap.put(first.getRevisao(), entidadeMap);
		
		Map<String, Map<Long, Map<Long, String>>> enumMap = new HashMap<>();
		enumMap.put(first.getClass().getName(), revisaoMap);
		
		return enumMap;
	}

	@Override
	public void enumMigration() {
		
		
		
		
	}


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
