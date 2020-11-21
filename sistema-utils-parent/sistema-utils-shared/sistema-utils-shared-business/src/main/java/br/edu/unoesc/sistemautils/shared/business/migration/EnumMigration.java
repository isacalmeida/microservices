package br.edu.unoesc.sistemautils.shared.business.migration;

import java.beans.Introspector;
import java.text.MessageFormat;
import java.util.Objects;
import java.util.Optional;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import br.edu.unoesc.sistemautils.arquitetura.business.common.IIdentityService;
import br.edu.unoesc.sistemautils.arquitetura.common.model.IIdentityEntity;
import br.edu.unoesc.sistemautils.arquitetura.common.model.enums.IEnumEntidade;
import br.edu.unoesc.sistemautils.arquitetura.common.model.enums.IRevisao;
import br.edu.unoesc.sistemautils.shared.business.service.RevisionEnumControlService;
import br.edu.unoesc.sistemautils.shared.common.model.RevisionEnumControl;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class EnumMigration {

	private RevisionEnumControlService revisionEnumControlService;

	private ApplicationContext applicationContext;

	public EnumMigration(RevisionEnumControlService revisionEnumControlService, ApplicationContext applicationContext) {
		this.revisionEnumControlService = revisionEnumControlService;
		this.applicationContext = applicationContext;
	}

	public <E extends IIdentityEntity<Long>, ENUM extends Enum<ENUM> & IEnumEntidade<E> & IRevisao> void doMigration(Class<ENUM> enumClass) {
		Enum<?>[] valoresEnum = (Enum[]) enumClass.getEnumConstants();
		RevisionEnumControl revisionEnumControl = revisionEnumControlService.findByDescricaoEnum(enumClass.getSimpleName());
		if(Objects.isNull(revisionEnumControl)) {
			revisionEnumControl = new RevisionEnumControl();

			revisionEnumControl.setRevisao(-1L);
			revisionEnumControl.setDescricaoEnum(enumClass.getSimpleName());
			revisionEnumControl.setEnumHash(String.valueOf(enumClass.hashCode()));
			
			revisionEnumControl = revisionEnumControlService.create(revisionEnumControl);
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
			String serviceClass = Introspector.decapitalize(entidade.getClass().getSimpleName().concat("ServiceImpl"));
			
			try {
				IIdentityService<E, Long> service = (IIdentityService<E,Long>) applicationContext.getBean(serviceClass);
				Optional<?> find = service.getOne(entidade.getId());
				if(find.isEmpty()) {
					entidade = service.create((E) entidade);
				}
				else {
					entidade = service.update((E) entidade);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		revisionEnumControl.setRevisao(revisaoEnum);
		revisionEnumControl.setEnumHash(String.valueOf(enumClass.hashCode()));
		this.revisionEnumControlService.update(revisionEnumControl);
	}
}
