package br.edu.unoesc.adminserver.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.unoesc.sistemautils.arquitetura.application.ApplicationStarter;
import br.edu.unoesc.sistemautils.arquitetura.constants.BasePackagesConstants;
import de.codecentric.boot.admin.server.config.EnableAdminServer;

@EnableAdminServer
@SpringBootApplication(scanBasePackages = BasePackagesConstants.ADMIN_SERVER)
public class AdminServerApplication {

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(AdminServerApplication.class);
		springApplication.setMainApplicationClass(ApplicationStarter.class);
		springApplication.run(args);
	}
}
