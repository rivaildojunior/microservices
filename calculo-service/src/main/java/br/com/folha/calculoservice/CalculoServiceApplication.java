package br.com.folha.calculoservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableCaching
@EnableFeignClients
@SpringBootApplication
@EnableEurekaClient
public class CalculoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalculoServiceApplication.class, args);
	}

}
