package com.example.bancoH2.adapters.out.jpa.entities.pessoa.adapter;

import com.example.bancoH2.adapters.out.jpa.entities.pessoa.entity.PessoaEntity;
import com.example.bancoH2.adapters.out.jpa.entities.pessoa.mapper.PessoaMapper;
import com.example.bancoH2.adapters.out.jpa.entities.pessoa.repository.PessoaRepository;
import com.example.bancoH2.core.models.pessoa.Pessoa;
import com.example.bancoH2.core.ports.out.PessoaPort;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PessoaImpl implements PessoaPort {

    private final PessoaMapper pessoaMapper;
    private final PessoaRepository pessoaRepository;

    public PessoaImpl(PessoaMapper pessoaMapper, PessoaRepository pessoaRepository) {
        this.pessoaMapper = pessoaMapper;
        this.pessoaRepository = pessoaRepository;
    }

    @Override
    public Pessoa CadastrarPessoa(Pessoa pessoaModel) {

        PessoaEntity entity = pessoaMapper.toPessoaEntity(pessoaModel);
        return pessoaMapper.toPessoaFromEntity(pessoaRepository.save(entity));

    }

    @Override
    public List<Pessoa> ConsultaTodasPessoas() {
        List<PessoaEntity> entitys = pessoaRepository.findAll();
        return pessoaMapper.fromListPessoaEntity(entitys);
    }
}
