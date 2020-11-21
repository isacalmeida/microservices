package br.edu.unoesc.transicaoservice.business.service.impl;

import org.springframework.stereotype.Component;

import br.edu.unoesc.sistemautils.shared.business.migration.AbstractEnumMigration;
import br.edu.unoesc.transicaoservice.common.model.enums.EnumCategoriaItemConfiguracao;
import br.edu.unoesc.transicaoservice.common.model.enums.EnumImpacto;
import br.edu.unoesc.transicaoservice.common.model.enums.EnumPrioridade;
import br.edu.unoesc.transicaoservice.common.model.enums.EnumStatusItemConfiguracao;
import br.edu.unoesc.transicaoservice.common.model.enums.EnumStatusMudanca;
import br.edu.unoesc.transicaoservice.common.model.enums.EnumTipoItemConfiguracao;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class TransicaoConfigurarEnumService extends AbstractEnumMigration {

	@Override
	public void startMigration() {
		log.info("Started startMigration");

		enumMigration.doMigration(EnumCategoriaItemConfiguracao.class);
		enumMigration.doMigration(EnumImpacto.class);
		enumMigration.doMigration(EnumPrioridade.class);
		enumMigration.doMigration(EnumStatusItemConfiguracao.class);
		enumMigration.doMigration(EnumStatusMudanca.class);
		enumMigration.doMigration(EnumTipoItemConfiguracao.class);
		
		log.info("Finished startMigration");
	}
}
