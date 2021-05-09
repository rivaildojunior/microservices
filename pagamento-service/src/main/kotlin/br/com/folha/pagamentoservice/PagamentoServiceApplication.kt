package br.com.folha.pagamentoservice

import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.boot.runApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
@EnableEurekaClient
class PagamentoServiceApplication

fun main(args: Array<String>) {
	runApplication<PagamentoServiceApplication>(*args)
}
