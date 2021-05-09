package br.com.folha.funcionarioservice.core.application.port.out;

import java.util.List;

import br.com.folha.funcionarioservice.core.domain.Funcionario;

public interface FuncionarioPersistencePort {

  Funcionario adicionar(Funcionario funcionario);

  Funcionario atualizar(Integer id, Funcionario funcionario);

  void excluir(Integer id);

  Funcionario buscar(Integer id);

  List<Funcionario> buscarTodos();
}
