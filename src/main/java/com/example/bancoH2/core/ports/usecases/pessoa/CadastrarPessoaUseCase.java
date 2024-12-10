package com.example.bancoH2.core.ports.usecases.pessoa;

import com.example.bancoH2.core.models.pessoa.Pessoa;
import com.example.bancoH2.core.ports.UseCase;
import com.example.bancoH2.core.ports.out.PessoaPort;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@UseCase
@Component
public class CadastrarPessoaUseCase{

    private final PessoaPort pessoaPort;

    public CadastrarPessoaUseCase(PessoaPort pessoaPort) {
        this.pessoaPort = pessoaPort;
    }

    public Pessoa CadastrarPessoa(Pessoa pessoaModel){
        pessoaModel.setCreateAt(LocalDateTime.now());
        return pessoaPort.CadastrarPessoa(pessoaModel);
    }
}
