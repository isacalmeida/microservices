package br.edu.unoesc.pessoaservice.application.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import brave.sampler.Sampler;

@EnableDiscoveryClient
@EntityScan(PessoaServiceApplication.BASE_PACKAGE)
@ComponentScan(PessoaServiceApplication.BASE_PACKAGE)
@EnableJpaRepositories(PessoaServiceApplication.BASE_PACKAGE)
@SpringBootApplication(scanBasePackages = PessoaServiceApplication.BASE_PACKAGE)
public class PessoaServiceApplication {

	public static final String BASE_PACKAGE = "br.edu.unoesc";
	
    public static void main(String[] args) {
        SpringApplication.run(PessoaServiceApplication.class, args);
    }

    @Bean
    public Sampler defaultSampler(){
        return Sampler.ALWAYS_SAMPLE;
    }
}
