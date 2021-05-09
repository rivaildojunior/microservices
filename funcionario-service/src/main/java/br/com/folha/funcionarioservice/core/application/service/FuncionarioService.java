package br.com.folha.funcionarioservice.core.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.folha.funcionarioservice.core.application.port.in.FuncionarioServicePort;
import br.com.folha.funcionarioservice.core.application.port.out.FuncionarioPersistencePort;
import br.com.folha.funcionarioservice.core.domain.Funcionario;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class FuncionarioService implements FuncionarioServicePort {

  private final FuncionarioPersistencePort funcionarioPersistence;

  public Funcionario adicionar(Funcionario funcionario) {
    return this.funcionarioPersistence.adicionar(funcionario);
  }

  @Override
  public Funcionario atualizar(Integer id, Funcionario funcionario) {
    return this.funcionarioPersistence.atualizar(id, funcionario);
  }

  @Override
  public void excluir(Integer id) {
    this.funcionarioPersistence.excluir(id);
  }

  @Override
  public Funcionario buscarPorId(Integer id) {
    return funcionarioPersistence.buscar(id);
  }

  @Override
  public List<Funcionario> buscarTodos() {
    return funcionarioPersistence.buscarTodos();
  }
}
