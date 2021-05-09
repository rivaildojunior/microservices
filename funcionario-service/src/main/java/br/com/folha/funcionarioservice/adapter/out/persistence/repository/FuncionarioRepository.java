package br.com.folha.funcionarioservice.adapter.out.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.folha.funcionarioservice.adapter.out.persistence.entity.FuncionarioEntity;

public interface FuncionarioRepository extends JpaRepository<FuncionarioEntity, Integer>{

}
