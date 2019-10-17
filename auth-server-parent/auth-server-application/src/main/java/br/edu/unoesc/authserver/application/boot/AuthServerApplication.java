package br.edu.unoesc.authserver.application.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = AuthServerApplication.BASE_PACKAGE)
public class AuthServerApplication {

	public static final String BASE_PACKAGE = "br.edu.unoesc.authserver";
	
	public static void main(String[] args) {
		SpringApplication.run(AuthServerApplication.class, args);
	}
}
