package com.example.bancoH2.core.ports.usecases.pessoa;

import com.example.bancoH2.core.models.pessoa.Pessoa;
import com.example.bancoH2.core.ports.UseCase;
import com.example.bancoH2.core.ports.out.PessoaPort;
import com.example.bancoH2.core.ports.out.IConsultaPessoaUseCase;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@UseCase
@Component
public class ConsultarPessoaUseCase implements IConsultaPessoaUseCase {

    private final PessoaPort pessoaPort;

    public ConsultarPessoaUseCase(PessoaPort pessoaPort) {
        this.pessoaPort = pessoaPort;
    }


    @Override
    public Pessoa ConsultarPessoaUseCase(Long idPessoa) {
        return pessoaPort.ConsultarPessoaPorID(idPessoa);
    }

    public Page<Pessoa> ConsultarTodasPessoas(Pageable pageable){

        // poderia utilizar o PageRequest nesse momento, e era só substituir como paramentro
        // só que já trago pronto da ontroller o pageable
        PageRequest pagerequest = PageRequest.of(pageable.getPageNumber(),pageable.getPageSize());

        return pessoaPort.ConsultaTodasPessoas(pagerequest);
    }

}
