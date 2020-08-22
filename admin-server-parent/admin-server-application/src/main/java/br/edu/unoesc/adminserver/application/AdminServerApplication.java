package br.edu.unoesc.adminserver.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@Configuration
@EnableAutoConfiguration
@EnableAdminServer
@EnableDiscoveryClient
public class AdminServerApplication {

	public static final String BASE_PACKAGE = "br.edu.unoesc";

	public static void main(String[] args) {
		SpringApplication.run(AdminServerApplication.class, args);
	}
}
