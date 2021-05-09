package br.com.folha.funcionarioservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig {

	@Bean
	public WebMvcConfigurer corsConfigurer() {
	    return new WebMvcConfigurer() {

	        @Override
	        public void addCorsMappings(CorsRegistry registry) {
	            registry.addMapping("/**").allowedOrigins("*").allowedMethods("*").allowedMethods("*");
	        }

	        @SuppressWarnings("deprecation")
			@Override
	        public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
	            configurer.favorPathExtension(false).favorParameter(true).parameterName("mediaType").ignoreAcceptHeader(true).useRegisteredExtensionsOnly(
	                    false).defaultContentType(MediaType.valueOf(
	                            "application/vnd.spring-boot.actuator.v2"), MediaType.APPLICATION_JSON).mediaType("json", MediaType.APPLICATION_JSON);
	        }
	    };
	}
}
