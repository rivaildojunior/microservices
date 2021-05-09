package br.com.folha.calculoservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.folha.calculoservice.entidade.Funcionario;

@Repository
public interface FuncionarioRepository extends CrudRepository<Funcionario, Long>{

}
