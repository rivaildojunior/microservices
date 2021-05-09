package br.com.folha.apigatewayspringcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@EnableEurekaClient
@SpringBootApplication
public class ApiGatewaySpringcloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewaySpringcloudApplication.class, args);
	}
	
	@Bean
	public RouteLocator myRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(p -> p.path("/funcionarios/**").uri("lb://funcionario-service/"))
				.route(p -> p.path("/pagamentos/**").uri("lb://calculo-service/"))
				.build();
	}

}
