package br.com.folha.funcionarioservice.config.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.Generated;

@Generated
@Configuration
public class ModelMapperConfig {

  @Bean
  public ModelMapper modelMapper() {
    return new ModelMapper();
  }

}
