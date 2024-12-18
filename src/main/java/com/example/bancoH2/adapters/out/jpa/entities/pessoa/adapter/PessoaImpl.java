package com.example.bancoH2.adapters.out.jpa.entities.pessoa.adapter;

import com.example.bancoH2.adapters.in.web.dto.pessoa.PessoaDtoRequest;
import com.example.bancoH2.adapters.out.jpa.entities.pessoa.entity.PessoaEntity;
import com.example.bancoH2.adapters.out.jpa.entities.pessoa.mapper.PessoaMapper;
import com.example.bancoH2.adapters.out.jpa.entities.pessoa.repository.PessoaRepository;
import com.example.bancoH2.core.models.pessoa.Pessoa;
import com.example.bancoH2.core.ports.out.PessoaPort;
import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

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
    public Page<Pessoa> ConsultaTodasPessoas(PageRequest pagerequest) {

        Page<PessoaEntity> pess = pessoaRepository.findAll(pagerequest);
        //Page<PessoaEntity> entitys = pessoaRepository.findAllPessoas(pageable);
        var model = new PageImpl<>(pessoaMapper.fromListPessoaEntity(pess.toList()),
                pagerequest,
                pess.getTotalElements());

        return model;
    }

    @Override
    public Pessoa ConsultarPessoaPorID(Long idPessoa) {
        Optional<PessoaEntity> entity = pessoaRepository.findById(idPessoa);
        if(entity.isPresent()) {
            Pessoa pessoa = pessoaMapper.toPessoaFromEntity(entity.get());
            return pessoa;
        }
        return null;
    }

    @Override
    public Pessoa AtualizarPessoa(Long idPessoa, PessoaDtoRequest pessoaDtoRequest) {

        Optional<PessoaEntity> entity = pessoaRepository.findById(idPessoa);

        if(entity.isPresent()){
            if(!pessoaDtoRequest.getCpf().isEmpty()){
                entity.get().setCpf(pessoaDtoRequest.getCpf());
            }
            if(!pessoaDtoRequest.getNome().isEmpty()){
                entity.get().setNome(pessoaDtoRequest.getNome());
            }
            if(pessoaDtoRequest.getIdade() > 0){
                entity.get().setIdade(pessoaDtoRequest.getIdade());
            }

            pessoaRepository.save(entity.get());
        }

        return pessoaMapper.toPessoaFromEntity(entity.get());
    }
}