package br.com.folha.calculoservice.service.cache;

import java.util.Optional;

public interface Cache<T> {
	
	void gravarEntidadeCache(T t, Long id);

	Optional<T> getEntidadeCache(Long id);
}
