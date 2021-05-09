package br.com.folha.pagamentoservice.consumer

import org.springframework.stereotype.Component
import br.com.folha.pagamentoservice.repository.PagamentoRepository
import br.com.folha.pagamentoservice.model.Pagamento
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.kafka.annotation.KafkaListener


@Component
class PagamentoConsumer(var repo: PagamentoRepository) {

	@KafkaListener(topics = ["pagamento"], groupId = "test_id")
	fun consume(message: String): Unit {
		val mapper = ObjectMapper().registerKotlinModule()
		val pagamento: Pagamento = mapper.readValue<Pagamento>(message, Pagamento::class.java)
		println(pagamento.funcionario)
		
		repo.save(pagamento)
	}
}

