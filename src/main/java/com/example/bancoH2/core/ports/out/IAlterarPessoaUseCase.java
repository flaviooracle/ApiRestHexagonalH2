package com.example.bancoH2.core.ports.out;

import com.example.bancoH2.adapters.in.web.dto.pessoa.PessoaDtoRequest;
import com.example.bancoH2.core.models.pessoa.Pessoa;

public interface IAlterarPessoaUseCase {
    Pessoa atualizarPessoa(Long idPessoa, PessoaDtoRequest pessoaDtoRequest);
}
