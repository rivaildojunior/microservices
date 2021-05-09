package br.com.folha.calculoservice.config;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.context.annotation.Bean;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;

@Configurable
public class AppConfig {
	
	@Bean
	public Customizer<Resilience4JCircuitBreakerFactory> globalCustomConfiguration() {
		TimeLimiterConfig timeLimiterConfig = TimeLimiterConfig.custom()
				.timeoutDuration(Duration.ofSeconds(4))
				.build();
		
		CircuitBreakerConfig circuitBreakerConfig = CircuitBreakerConfig.custom()
				.failureRateThreshold(50)
				.waitDurationInOpenState(Duration.ofMillis(1000))
				.slidingWindowSize(2)
				.build();

		return factory -> factory.configureDefault(id -> new Resilience4JConfigBuilder(id)
				.timeLimiterConfig(timeLimiterConfig).circuitBreakerConfig(circuitBreakerConfig).build());
	}

}
