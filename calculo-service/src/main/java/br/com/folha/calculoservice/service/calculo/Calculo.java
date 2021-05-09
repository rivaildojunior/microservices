package br.com.folha.calculoservice.service.calculo;

import java.util.Optional;

import br.com.folha.calculoservice.entidade.Pagamento;

public interface Calculo {
	
	Optional<Pagamento> calcular(Long funcionarioId, Integer dias);

}
