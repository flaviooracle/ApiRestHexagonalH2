package com.example.bancoH2.core.ports.out;

import com.example.bancoH2.core.models.pessoa.Pessoa;

import java.util.List;

public interface PessoaPort {

    Pessoa CadastrarPessoa(Pessoa pessoaModel);
    List<Pessoa> ConsultaTodasPessoas();

}
