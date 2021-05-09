package br.com.folha.funcionarioservice.adapter.in.web.dto.output;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FuncionarioOutput {

	private String nome;

	private String email;

	private String senha;

	private String telefone;

	private String cpf;

	private double valorDiario;
}
