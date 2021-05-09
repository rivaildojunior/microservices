package br.com.folha.pagamentoservice.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.GetMapping
import br.com.folha.pagamentoservice.consumer.PagamentoConsumer
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/clientes")
class PagamentoController() {

	init {
	}

	@GetMapping
	fun testar() = println("o123i")


}