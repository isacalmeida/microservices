package br.edu.unoesc.zipkinserver.application.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = ZipkinServerApplication.BASE_PACKAGE)
public class ZipkinServerApplication {

	public static final String BASE_PACKAGE = "br.edu.unoesc";
	
    public static void main(String[] args) {
        SpringApplication.run(ZipkinServerApplication.class, args);
    }
}
