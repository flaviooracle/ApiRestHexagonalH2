package com.example.bancoH2.adapters.out.jpa.entities.pessoa.mapper;

import com.example.bancoH2.adapters.in.web.dto.pessoa.PessoaDtoRequest;
import com.example.bancoH2.adapters.in.web.dto.pessoa.PessoaDtoResponse;
import com.example.bancoH2.adapters.out.jpa.entities.pessoa.entity.PessoaEntity;
import com.example.bancoH2.core.models.pessoa.Pessoa;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PessoaMapper {

    PessoaMapper INSTANCE = Mappers.getMapper(PessoaMapper.class);

    // Mapeia PessoaDtoRequest para Pessoa
    Pessoa toModel(PessoaDtoRequest request);

    // Mapeia Pessoa para PessoaDtoResponse
    PessoaDtoResponse toResponse(Pessoa model);
    List<PessoaDtoResponse> fromListPessoa(List<Pessoa> pessoas);

    // Mapeia PessoaEntity para Pessoa
    Pessoa toPessoaFromEntity(PessoaEntity entity);
    List<Pessoa> fromListPessoaEntity(List<PessoaEntity> entitys);

    // Mapeia Pessoa para PessoaEntity
    PessoaEntity toPessoaEntity(Pessoa pessoa);
}
