package br.com.folha.calculoservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.folha.calculoservice.entidade.Funcionario;

@Component
@FeignClient(name = "funcionario-service", path = "/funcionarios")
public interface FuncionarioFeignClient {
	
	@GetMapping(value = "/{id}")
	ResponseEntity<Funcionario> findById(@PathVariable Long id);
	
}
