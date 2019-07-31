package br.edu.unoesc.pessoaservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@EnableDiscoveryClient
@SpringBootApplication
public class PessoaServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PessoaServiceApplication.class, args);
    }

}
