package br.edu.unoesc.uiservice.application.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import brave.sampler.Sampler;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
@EntityScan(UiServiceApplication.BASE_PACKAGE)
@ComponentScan(UiServiceApplication.BASE_PACKAGE)
@EnableJpaRepositories(UiServiceApplication.BASE_PACKAGE)
public class UiServiceApplication extends SpringBootServletInitializer {
	
	public static final String BASE_PACKAGE = "br.edu.unoesc.pessoaservice";

    public static void main(String[] args) {
        SpringApplication.run(UiServiceApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(UiServiceApplication.class);
    }

    @Bean
    public Sampler defaultSampler(){
        return Sampler.ALWAYS_SAMPLE;
    }
}
