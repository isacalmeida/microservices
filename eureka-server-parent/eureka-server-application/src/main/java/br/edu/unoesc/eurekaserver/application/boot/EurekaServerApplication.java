package br.edu.unoesc.eurekaserver.application.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication(scanBasePackages = EurekaServerApplication.BASE_PACKAGE)
public class EurekaServerApplication {

	public static final String BASE_PACKAGE = "br.edu.unoesc.authserver";
	
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class, args);
    }
}
