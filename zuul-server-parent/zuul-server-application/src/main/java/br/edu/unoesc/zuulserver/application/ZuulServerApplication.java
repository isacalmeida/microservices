package br.edu.unoesc.zuulserver.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

import br.edu.unoesc.sistemautils.arquitetura.application.ApplicationStarter;
import br.edu.unoesc.sistemautils.arquitetura.constants.BasePackagesConstants;

@EnableZuulProxy
@SpringBootApplication(scanBasePackages = BasePackagesConstants.ZUUL_SERVER)
public class ZuulServerApplication {
	
	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(ZuulServerApplication.class);
		springApplication.setMainApplicationClass(ApplicationStarter.class);
		springApplication.run(args);
	}
}
