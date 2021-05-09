package br.com.folha.calculoservice.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.folha.calculoservice.entidade.Pagamento;
import br.com.folha.calculoservice.service.PagamentoService;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping(value = "/pagamentos")
@Log4j2
public class PagamentoController {
	
	private PagamentoService pagamentoService;

	public PagamentoController(PagamentoService pagamentoService) {
		this.pagamentoService = pagamentoService;
	}
	
	@GetMapping(value = "/{funcionarioId}/dias/{dias}")
	public ResponseEntity<?> getPayment(@PathVariable Long funcionarioId, @PathVariable Integer dias) {
		log.info("Calculando o salario do funcionario {} ", funcionarioId);
		Optional<Pagamento> pagamento = pagamentoService.fazerCalculo(funcionarioId, dias);
		if (!pagamento.isEmpty()) {
			return ResponseEntity.ok(pagamento);
		}
		return ResponseEntity.ok("Pagamento indisponivel no momento");
	}	
	
	

}
