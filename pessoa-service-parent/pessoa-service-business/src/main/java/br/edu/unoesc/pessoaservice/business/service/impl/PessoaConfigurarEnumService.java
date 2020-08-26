package br.edu.unoesc.pessoaservice.business.service.impl;

import org.springframework.stereotype.Component;

import br.edu.unoesc.pessoaservice.common.model.enums.EnumGeneroPessoa;
import br.edu.unoesc.pessoaservice.common.model.enums.EnumTipoContato;
import br.edu.unoesc.pessoaservice.common.model.enums.EnumTipoDocumento;
import br.edu.unoesc.pessoaservice.common.model.enums.EnumTipoEndereco;
import br.edu.unoesc.pessoaservice.common.model.enums.EnumTipoPessoa;
import br.edu.unoesc.sistemautils.shared.business.migration.AbstractEnumMigration;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class PessoaConfigurarEnumService extends AbstractEnumMigration {

	@Override
	public void startMigration() {
		log.info("Started startMigration");
		
		enumMigration.doMigration(EnumGeneroPessoa.class);
		enumMigration.doMigration(EnumTipoContato.class);
		enumMigration.doMigration(EnumTipoEndereco.class);
		enumMigration.doMigration(EnumTipoPessoa.class);
		enumMigration.doMigration(EnumTipoDocumento.class);
		
		log.info("Finished startMigration");
	}
}
