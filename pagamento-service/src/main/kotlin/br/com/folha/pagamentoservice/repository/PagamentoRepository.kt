package br.com.folha.pagamentoservice.repository

import br.com.folha.pagamentoservice.model.Pagamento
import org.springframework.data.mongodb.repository.MongoRepository

interface PagamentoRepository : MongoRepository<Pagamento, Long>