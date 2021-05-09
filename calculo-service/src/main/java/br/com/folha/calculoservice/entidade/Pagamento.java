package br.com.folha.calculoservice.entidade;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Pagamento {

	private String funcionario;
	private Double valor;
}
