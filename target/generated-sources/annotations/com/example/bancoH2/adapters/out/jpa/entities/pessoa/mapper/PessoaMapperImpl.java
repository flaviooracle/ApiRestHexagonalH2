package com.example.bancoH2.adapters.out.jpa.entities.pessoa.mapper;

import com.example.bancoH2.adapters.in.web.dto.pessoa.PessoaDtoRequest;
import com.example.bancoH2.adapters.in.web.dto.pessoa.PessoaDtoResponse;
import com.example.bancoH2.adapters.out.jpa.entities.pessoa.entity.PessoaEntity;
import com.example.bancoH2.core.models.pessoa.Pessoa;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-15T22:13:28-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class PessoaMapperImpl implements PessoaMapper {

    @Override
    public Pessoa toModel(PessoaDtoRequest request) {
        if ( request == null ) {
            return null;
        }

        Pessoa.PessoaBuilder pessoa = Pessoa.builder();

        pessoa.nome( request.getNome() );
        pessoa.cpf( request.getCpf() );
        pessoa.idade( request.getIdade() );

        return pessoa.build();
    }

    @Override
    public PessoaDtoResponse toResponse(Pessoa model) {
        if ( model == null ) {
            return null;
        }

        PessoaDtoResponse.PessoaDtoResponseBuilder pessoaDtoResponse = PessoaDtoResponse.builder();

        pessoaDtoResponse.pessoaId( model.getPessoaId() );
        pessoaDtoResponse.nome( model.getNome() );
        pessoaDtoResponse.cpf( model.getCpf() );
        pessoaDtoResponse.idade( model.getIdade() );
        pessoaDtoResponse.createAt( model.getCreateAt() );

        return pessoaDtoResponse.build();
    }

    @Override
    public List<PessoaDtoResponse> fromListPessoa(List<Pessoa> pessoas) {
        if ( pessoas == null ) {
            return null;
        }

        List<PessoaDtoResponse> list = new ArrayList<PessoaDtoResponse>( pessoas.size() );
        for ( Pessoa pessoa : pessoas ) {
            list.add( toResponse( pessoa ) );
        }

        return list;
    }

    @Override
    public Pessoa toPessoaFromEntity(PessoaEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Pessoa.PessoaBuilder pessoa = Pessoa.builder();

        pessoa.pessoaId( entity.getPessoaId() );
        pessoa.nome( entity.getNome() );
        pessoa.cpf( entity.getCpf() );
        pessoa.idade( entity.getIdade() );
        pessoa.createAt( entity.getCreateAt() );

        return pessoa.build();
    }

    @Override
    public List<Pessoa> fromListPessoaEntity(List<PessoaEntity> entitys) {
        if ( entitys == null ) {
            return null;
        }

        List<Pessoa> list = new ArrayList<Pessoa>( entitys.size() );
        for ( PessoaEntity pessoaEntity : entitys ) {
            list.add( toPessoaFromEntity( pessoaEntity ) );
        }

        return list;
    }

    @Override
    public PessoaEntity toPessoaEntity(Pessoa pessoa) {
        if ( pessoa == null ) {
            return null;
        }

        PessoaEntity.PessoaEntityBuilder pessoaEntity = PessoaEntity.builder();

        pessoaEntity.pessoaId( pessoa.getPessoaId() );
        pessoaEntity.nome( pessoa.getNome() );
        pessoaEntity.idade( pessoa.getIdade() );
        pessoaEntity.cpf( pessoa.getCpf() );
        pessoaEntity.createAt( pessoa.getCreateAt() );

        return pessoaEntity.build();
    }
}
