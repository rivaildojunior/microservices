package br.com.folha.funcionarioservice.core.domain.exception;

public class FuncionarioNotFoundException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public FuncionarioNotFoundException(String message) {
    super(message);
  }

  public FuncionarioNotFoundException(Integer id) {
    this(String.format("Funcionário não pode ser encontrado com o código: %s", id));
  }
}
