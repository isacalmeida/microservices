package br.edu.unoesc.configserver.application.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication(scanBasePackages = ConfigServerApplication.BASE_PACKAGE, proxyBeanMethods = false)
public class ConfigServerApplication {

	public static final String BASE_PACKAGE = "br.edu.unoesc.configserver";

	public static void main(String[] args) {
		SpringApplication.run(ConfigServerApplication.class, args);
	}
}
