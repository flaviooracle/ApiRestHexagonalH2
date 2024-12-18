package com.example.bancoH2.core.ports.usecases.pessoa;

import com.example.bancoH2.adapters.in.web.dto.pessoa.PessoaDtoRequest;
import com.example.bancoH2.core.models.pessoa.Pessoa;
import com.example.bancoH2.core.ports.UseCase;
import com.example.bancoH2.core.ports.out.IAlterarPessoaUseCase;
import com.example.bancoH2.core.ports.out.PessoaPort;
import org.springframework.stereotype.Component;

@Component
@UseCase
public class AlterarPessoaUseCase implements IAlterarPessoaUseCase {

    private final PessoaPort pessoaPort;

    public AlterarPessoaUseCase(PessoaPort pessoaPort) {
        this.pessoaPort = pessoaPort;
    }

    @Override
    public Pessoa atualizarPessoa(Long idPessoa, PessoaDtoRequest pessoaDtoRequest) {
        return pessoaPort.AtualizarPessoa(idPessoa, pessoaDtoRequest);
    }
}
