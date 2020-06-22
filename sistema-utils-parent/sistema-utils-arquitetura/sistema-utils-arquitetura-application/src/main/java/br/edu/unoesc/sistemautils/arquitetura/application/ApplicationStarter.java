package br.edu.unoesc.sistemautils.arquitetura.application;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.hateoas.config.EnableHypermediaSupport.HypermediaType;

import br.edu.unoesc.sistemautils.arquitetura.common.IEnumEntidade;
import br.edu.unoesc.sistemautils.arquitetura.common.IIdentityEntity;
import br.edu.unoesc.sistemautils.arquitetura.common.IRevisao;
import brave.sampler.Sampler;

@Configuration
@EnableDiscoveryClient
@EnableAutoConfiguration
@EnableHypermediaSupport(type = { HypermediaType.HAL })
public abstract class ApplicationStarter {

	public abstract void enumMigration();

	private Long runCount = 0L;

	@EventListener(ApplicationStartedEvent.class)
	public void doSomethingAfterStartup() {
		if(runCount.equals(1L)) {
			return;
		}
		
		System.out.println("Iniciou enumMigration()");
		enumMigration();
		System.out.println("Finalizou enumMigration()");
		
		runCount++;
	}

	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}
}
