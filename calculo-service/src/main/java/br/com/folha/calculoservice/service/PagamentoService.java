package br.com.folha.calculoservice.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.folha.calculoservice.entidade.Pagamento;
import br.com.folha.calculoservice.producer.PagamentoProducer;
import br.com.folha.calculoservice.service.calculo.Calculo;

@Service
public class PagamentoService {

	private Calculo calculo;
	private PagamentoProducer producer;

	public PagamentoService(Calculo calculo, PagamentoProducer producer) {
		this.calculo = calculo;
		this.producer = producer;
	}

	public Optional<Pagamento> fazerCalculo(Long funcionarioId, Integer dias) {
		Optional<Pagamento> pagamentoOptional = calculo.calcular(funcionarioId, dias);
		producer.sendPagamento(pagamentoOptional.get());
		return pagamentoOptional;
	}

}
