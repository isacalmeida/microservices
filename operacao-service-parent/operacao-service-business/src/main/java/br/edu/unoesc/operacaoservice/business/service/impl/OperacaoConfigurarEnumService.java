package br.edu.unoesc.operacaoservice.business.service.impl;

import org.springframework.stereotype.Component;

import br.edu.unoesc.operacaoservice.common.model.enums.EnumImpacto;
import br.edu.unoesc.operacaoservice.common.model.enums.EnumPrioridade;
import br.edu.unoesc.operacaoservice.common.model.enums.EnumStatusEvento;
import br.edu.unoesc.operacaoservice.common.model.enums.EnumStatusIncidente;
import br.edu.unoesc.operacaoservice.common.model.enums.EnumStatusProblema;
import br.edu.unoesc.operacaoservice.common.model.enums.EnumStatusRequisicao;
import br.edu.unoesc.sistemautils.shared.business.migration.AbstractEnumMigration;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class OperacaoConfigurarEnumService extends AbstractEnumMigration {

	@Override
	public void startMigration() {
		log.info("Started startMigration");

		enumMigration.doMigration(EnumImpacto.class);
		enumMigration.doMigration(EnumPrioridade.class);
		enumMigration.doMigration(EnumStatusEvento.class);
		enumMigration.doMigration(EnumStatusIncidente.class);
		enumMigration.doMigration(EnumStatusProblema.class);
		enumMigration.doMigration(EnumStatusRequisicao.class);
		
		log.info("Finished startMigration");
	}
}
