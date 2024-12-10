package com.example.bancoH2.core.ports.usecases.pessoa;

import com.example.bancoH2.adapters.in.web.dto.pessoa.PessoaDtoResponse;
import com.example.bancoH2.core.models.pessoa.Pessoa;
import com.example.bancoH2.core.ports.UseCase;
import com.example.bancoH2.core.ports.out.PessoaPort;
import org.springframework.stereotype.Component;

import java.util.List;

@UseCase
@Component
public class ConsultarPessoaUseCase {

    private final PessoaPort pessoaPort;

    public ConsultarPessoaUseCase(PessoaPort pessoaPort) {
        this.pessoaPort = pessoaPort;
    }

    public List<Pessoa> ConsultaTodasPessoas(){
        return pessoaPort.ConsultaTodasPessoas();
    }

}
