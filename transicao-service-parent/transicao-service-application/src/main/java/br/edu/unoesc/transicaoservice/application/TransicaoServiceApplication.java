package br.edu.unoesc.transicaoservice.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import br.edu.unoesc.transicaoservice.application.events.ReadyEventImpl;
import br.edu.unoesc.sistemautils.arquitetura.application.ApplicationStarter;
import br.edu.unoesc.sistemautils.arquitetura.constants.BasePackagesConstants;

@SpringBootApplication
@EnableFeignClients(basePackages = BasePackagesConstants.SHARED)
@EntityScan(basePackages = { BasePackagesConstants.TRANSICAO_SERVICE, BasePackagesConstants.SHARED })
@ComponentScan(basePackages = { BasePackagesConstants.TRANSICAO_SERVICE, BasePackagesConstants.SHARED })
@EnableJpaRepositories(basePackages = { BasePackagesConstants.TRANSICAO_SERVICE, BasePackagesConstants.SHARED })
public class TransicaoServiceApplication {

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(TransicaoServiceApplication.class);
		springApplication.setMainApplicationClass(ApplicationStarter.class);
		springApplication.addListeners(new ReadyEventImpl());
		springApplication.run(args);
	}
}
