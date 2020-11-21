package br.edu.unoesc.acessoservice.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import br.edu.unoesc.acessoservice.application.events.ReadyEventImpl;
import br.edu.unoesc.sistemautils.arquitetura.application.ApplicationStarter;
import br.edu.unoesc.sistemautils.arquitetura.constants.BasePackagesConstants;

@SpringBootApplication
@EnableFeignClients(basePackages = BasePackagesConstants.SHARED)
@EntityScan(basePackages = { BasePackagesConstants.ACESSO_SERVICE, BasePackagesConstants.SHARED })
@ComponentScan(basePackages = { BasePackagesConstants.ACESSO_SERVICE, BasePackagesConstants.SHARED })
@EnableJpaRepositories(basePackages = { BasePackagesConstants.ACESSO_SERVICE, BasePackagesConstants.SHARED })
public class AcessoServiceApplication {

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(AcessoServiceApplication.class);
		springApplication.setMainApplicationClass(ApplicationStarter.class);
		springApplication.addListeners(new ReadyEventImpl());
		springApplication.run(args);
	}
}
