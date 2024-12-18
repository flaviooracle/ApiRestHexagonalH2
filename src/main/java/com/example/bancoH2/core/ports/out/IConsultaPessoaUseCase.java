package com.example.bancoH2.core.ports.out;

import com.example.bancoH2.core.models.pessoa.Pessoa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IConsultaPessoaUseCase {
    Pessoa ConsultarPessoaUseCase(Long idPessoa);
    Page<Pessoa> ConsultarTodasPessoas(Pageable pageable);
}
