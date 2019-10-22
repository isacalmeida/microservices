package br.edu.unoesc.acessoservice.application.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import brave.sampler.Sampler;

@EnableDiscoveryClient
@EntityScan(AcessoServiceApplication.BASE_PACKAGE)
@ComponentScan(AcessoServiceApplication.BASE_PACKAGE)
@EnableJpaRepositories(AcessoServiceApplication.BASE_PACKAGE)
@SpringBootApplication(scanBasePackages = AcessoServiceApplication.BASE_PACKAGE)
public class AcessoServiceApplication {

	public static final String BASE_PACKAGE = "br.edu.unoesc";
	
	public static void main(String[] args) {
		SpringApplication.run(AcessoServiceApplication.class, args);
	}
	
	@Bean
    public Sampler defaultSampler(){
        return Sampler.ALWAYS_SAMPLE;
    }
}
