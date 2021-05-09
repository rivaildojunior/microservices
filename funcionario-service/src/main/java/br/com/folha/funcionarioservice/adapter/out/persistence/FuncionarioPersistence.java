package br.com.folha.funcionarioservice.adapter.out.persistence;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.folha.funcionarioservice.adapter.out.persistence.entity.FuncionarioEntity;
import br.com.folha.funcionarioservice.adapter.out.persistence.mapper.FuncionarioEntityMapper;
import br.com.folha.funcionarioservice.adapter.out.persistence.repository.FuncionarioRepository;
import br.com.folha.funcionarioservice.core.application.port.out.FuncionarioPersistencePort;
import br.com.folha.funcionarioservice.core.domain.Funcionario;
import br.com.folha.funcionarioservice.core.domain.exception.FuncionarioNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@AllArgsConstructor
@Repository
@Log4j2
public class FuncionarioPersistence implements FuncionarioPersistencePort {

  private final FuncionarioRepository funcionarioRepository;
  private final FuncionarioEntityMapper mapper;

  @Override
  public Funcionario adicionar(Funcionario funcionario) {
    log.info("Iniciando transação para salvar funcionario {} ", funcionario.getNome());

    FuncionarioEntity entity = this.mapper.toEntity(funcionario);

    entity = this.funcionarioRepository.save(entity);

    return this.mapper.toDomain(entity);
  }

  @Override
  public Funcionario atualizar(Integer id, Funcionario funcionario) {
    log.info("Iniciando transação para atualizar dados do funcionário: " + id);

    FuncionarioEntity funcionarioEntity = this.getFuncionarioEntity(id);

    this.mapper.copyProperties(funcionario, funcionarioEntity);

    funcionarioEntity = this.funcionarioRepository.save(funcionarioEntity);

    return this.mapper.toDomain(funcionarioEntity);
  }

  @Override
  public void excluir(Integer id) {
    this.funcionarioRepository.deleteById(id);
  }

  @Override
  public Funcionario buscar(Integer id) {
    log.info("Iniciando transação para buscar dados do funcionário: {} ", id);

    FuncionarioEntity funcionarioEntity = this.getFuncionarioEntity(id);

    return this.mapper.toDomain(funcionarioEntity);
  }

  @Override
  public List<Funcionario> buscarTodos() {
    log.info("Iniciando transação para buscar dados de todos funcionários");

    var funcionarios = this.funcionarioRepository.findAll();

    return this.mapper.toDomain(funcionarios);
  }

  private FuncionarioEntity getFuncionarioEntity(Integer id) {
    return this.funcionarioRepository
        .findById(id)
        .orElseThrow(() -> new FuncionarioNotFoundException(id));
  }
}
