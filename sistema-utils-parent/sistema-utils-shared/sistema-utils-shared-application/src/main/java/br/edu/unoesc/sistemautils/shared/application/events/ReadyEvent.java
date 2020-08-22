package br.edu.unoesc.sistemautils.shared.application.events;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public abstract class ReadyEvent implements ApplicationListener<ApplicationReadyEvent> {

	private Long runCount = 0L;

	public abstract void doAfterEvent();

	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		if(runCount.equals(1L)) {
			log.info("Started onApplicationEvent");
			
			log.info("Finished onApplicationEvent");
		}
		runCount++;
	}
}
