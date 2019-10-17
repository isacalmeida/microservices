package br.edu.unoesc.acessoservice.application.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = AcessoServiceApplication.BASE_PACKAGE)
public class AcessoServiceApplication {

	public static final String BASE_PACKAGE = "br.edu.unoesc.acessoservice";
	
	public static void main(String[] args) {
		SpringApplication.run(AcessoServiceApplication.class, args);
	}
}
