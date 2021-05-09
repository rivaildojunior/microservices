package br.com.folha.funcionarioservice.core.application.port.in;

import java.util.List;

import br.com.folha.funcionarioservice.core.domain.Funcionario;

public interface FuncionarioServicePort {

  Funcionario adicionar(Funcionario funcionario);

  Funcionario atualizar(Integer id, Funcionario funcionario);

  void excluir(Integer id);

  Funcionario buscarPorId(Integer id);

  List<Funcionario> buscarTodos();
}
