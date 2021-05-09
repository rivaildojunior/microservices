package br.com.folha.calculoservice.service.calculo;

import java.util.Optional;

import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Component;

import br.com.folha.calculoservice.entidade.Funcionario;
import br.com.folha.calculoservice.entidade.Pagamento;
import br.com.folha.calculoservice.service.FuncionarioFeignClient;
import br.com.folha.calculoservice.service.cache.Cache;

@Component
public class CalculoImpl implements Calculo {

	private final CircuitBreakerFactory<?, ?> circuitBreakerFactory;

	private final FuncionarioFeignClient funcionarioFeignClient;

	private final Cache<Funcionario> cache;

	public CalculoImpl(CircuitBreakerFactory<?, ?> circuitBreakerFactory, 
			FuncionarioFeignClient funcionarioFeignClient,
			Cache<Funcionario> cache) {
		this.circuitBreakerFactory = circuitBreakerFactory;
		this.funcionarioFeignClient = funcionarioFeignClient;
		this.cache = cache;
	}

	public Optional<Pagamento> calcular(final Long funcionarioId, final Integer dias) {
		Optional<Funcionario> funcionario = getFuncionario(funcionarioId);
		if (funcionario.isPresent()) {
			Pagamento pagamento = new Pagamento();
			pagamento.setFuncionario(funcionario.get().getNome());
			pagamento.setValor(funcionario.get().getValorDiario() * dias);
			return Optional.of(pagamento);
		}
		return Optional.empty();
	}

	public Optional<Funcionario> getFuncionario(final Long funcionarioId) {
		CircuitBreaker circuitBreaker = circuitBreakerFactory.create("circuitbreaker");

		return circuitBreaker.run(() -> {
			Funcionario funcionario = funcionarioFeignClient.findById(funcionarioId).getBody();
			cache.gravarEntidadeCache(funcionario, funcionarioId);
			return Optional.of(funcionario);
		}, throwable -> cache.getEntidadeCache(funcionarioId));

	}
}
