package br.com.folha.funcionarioservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class FuncionarioServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FuncionarioServiceApplication.class, args);
	}

}
