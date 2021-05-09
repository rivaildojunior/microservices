package br.com.folha.funcionarioservice.core.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Funcionario {

  private String nome;
  private String email;
  private String senha;
  private String telefone;
  private String cpf;
  private Double valorDiario;
}
