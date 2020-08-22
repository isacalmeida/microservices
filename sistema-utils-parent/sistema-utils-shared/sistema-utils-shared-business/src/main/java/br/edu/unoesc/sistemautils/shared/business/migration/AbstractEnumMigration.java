package br.edu.unoesc.sistemautils.shared.business.migration;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public abstract class AbstractEnumMigration {

	protected EnumMigration enumMigration;
	
	public abstract void startMigration();

	public void callMigration(EnumMigration enumMigration) {
		this.enumMigration = enumMigration;
		
		log.info("Started calltMigration");
		
		startMigration();
		
		log.info("Finished calltMigration");
	}
}
