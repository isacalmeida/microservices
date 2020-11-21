package br.edu.unoesc.acessoservice.application.events;

import br.edu.unoesc.sistemautils.shared.application.events.ReadyEvent;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ReadyEventImpl extends ReadyEvent {

	@Override
	public void doAfterEvent() {
		log.info("Started doAfterStartup");
		
		log.info("Finished doAfterStartup");
	}
}
