package br.com.folha.pagamentoservice.model

import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "pagamento")    
data class PagamentoEntity(


	val id: Long,
	val funcionario: String,
	val valor: Double
){}