package br.com.folha.calculoservice.service.cache;

import java.util.Optional;

import org.springframework.stereotype.Component;

import br.com.folha.calculoservice.entidade.Funcionario;
import br.com.folha.calculoservice.repository.FuncionarioRepository;

@Component
public class CacheRedis implements Cache<Funcionario> {

	private final FuncionarioRepository funcionarioRepository;

	public CacheRedis(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}

	@Override
	public void gravarEntidadeCache(final Funcionario funcionario, final Long funcionarioId) {
		funcionario.setId(funcionarioId);
		funcionarioRepository.save(funcionario);
	}

	@Override
	public Optional<Funcionario> getEntidadeCache(final Long funcionarioId) {
		Optional<Funcionario> funcionario = funcionarioRepository.findById(funcionarioId);
		if (funcionario.isPresent()) {
			return funcionario;
		}
		return Optional.empty();
	}

}
