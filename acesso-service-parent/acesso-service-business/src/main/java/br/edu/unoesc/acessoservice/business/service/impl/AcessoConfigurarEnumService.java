package br.edu.unoesc.acessoservice.business.service.impl;

import org.springframework.stereotype.Component;

import br.edu.unoesc.acessoservice.common.model.enums.EnumTipoServico;
import br.edu.unoesc.sistemautils.shared.business.migration.AbstractEnumMigration;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class AcessoConfigurarEnumService extends AbstractEnumMigration {

	@Override
	public void startMigration() {
		log.info("Started startMigration");
		
		enumMigration.doMigration(EnumTipoServico.class);
		
		log.info("Finished startMigration");
	}
}
