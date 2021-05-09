package br.com.folha.funcionarioservice.adapter.in.web.dto.input;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FuncionarioInput {

  @NotBlank
  private String nome;

  @Email
  private String email;

  @NotBlank
  private String senha;

  private String telefone;

  @NotBlank
  private String cpf;
  
  private double valorDiario;
}
