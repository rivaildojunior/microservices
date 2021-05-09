package br.com.folha.funcionarioservice.adapter.out.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity(name = "funcionario")
@Table(name = "tb_funcionario")
public class FuncionarioEntity {

  @EqualsAndHashCode.Include
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private Integer id;

  @Column(name = "nome_funcionario", nullable = false)
  private String nome;

  @Column(name = "email_funcionario", nullable = false)
  private String email;

  @Column(name = "senha_funcionario", nullable = false)
  private String senha;

  @Column(name = "telefone_funcionario")
  private String telefone;

  @Column(name = "cpf_funcionario", nullable = false)
  private String cpf;
  
  @Column(name = "valor_diario", nullable = false)
  private double valorDiario;
}
