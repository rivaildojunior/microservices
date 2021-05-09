package br.com.folha.calculoservice.producer;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.folha.calculoservice.entidade.Pagamento;

@Component
public class PagamentoProducer {

	@Value("${topico}")
	private String topico;

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;


	public void sendPagamento(final @RequestBody Pagamento pagamento) {
		final String mensageKey = UUID.randomUUID().toString();
		String json = converter(pagamento);
		kafkaTemplate.send(topico, mensageKey, json);
	}

	private String converter(final Pagamento pagamento) {
		ObjectMapper obj = new ObjectMapper();
		try {
			return obj.writeValueAsString(pagamento);
		} catch (JsonProcessingException e) {
			return "";
		}
	}
}
