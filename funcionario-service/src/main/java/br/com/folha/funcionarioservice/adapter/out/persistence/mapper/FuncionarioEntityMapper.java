package br.com.folha.funcionarioservice.adapter.out.persistence.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import br.com.folha.funcionarioservice.adapter.out.persistence.entity.FuncionarioEntity;
import br.com.folha.funcionarioservice.core.domain.Funcionario;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class FuncionarioEntityMapper {

  private final ModelMapper modelMapper;

  public Funcionario toDomain(FuncionarioEntity entity) {
    return this.modelMapper.map(entity, Funcionario.class);
  }

  public List<Funcionario> toDomain(List<FuncionarioEntity> entities) {
    return entities.stream()
        .map(this::toDomain)
        .collect(Collectors.toList());
  }

  public FuncionarioEntity toEntity(Funcionario domain) {
    return this.modelMapper.map(domain, FuncionarioEntity.class);
  }

  public void copyProperties(Funcionario domain, FuncionarioEntity entity) {
    this.modelMapper.getConfiguration().setSkipNullEnabled(true);
    this.modelMapper.map(domain, entity);
  }
}
