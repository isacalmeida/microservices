package br.edu.unoesc.zuulserver.application.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

import br.edu.unoesc.sistemautils.arquitetura.application.ApplicationStarter;
import br.edu.unoesc.sistemautils.arquitetura.constants.BasePackagesConstants;

@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = BasePackagesConstants.ZUUL_SERVER)
public class ZuulServerApplication extends ApplicationStarter {
	
    public static void main(String[] args) {
        SpringApplication.run(ApplicationStarter.class, args);
    }
}
