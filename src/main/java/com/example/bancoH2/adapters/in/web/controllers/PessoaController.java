package com.example.bancoH2.adapters.in.web.controllers;

import com.example.bancoH2.adapters.in.web.PessoaPath;
import com.example.bancoH2.adapters.in.web.dto.pessoa.PessoaDtoRequest;
import com.example.bancoH2.adapters.in.web.dto.pessoa.PessoaDtoResponse;
import com.example.bancoH2.adapters.out.jpa.entities.pessoa.mapper.PessoaMapper;
import com.example.bancoH2.core.models.pessoa.Pessoa;

import com.example.bancoH2.core.models.response.ApiResponse;
import com.example.bancoH2.core.ports.usecases.pessoa.CadastrarPessoaUseCase;
import com.example.bancoH2.core.ports.usecases.pessoa.ConsultarPessoaUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.URI;
import java.util.List;

@PessoaPath
//@Validated
public class PessoaController {


    private final CadastrarPessoaUseCase cadastrarPessoaUseCase;
    private final ConsultarPessoaUseCase consultarPessoaUseCase;
    private final PessoaMapper pessoaMapper;

    public PessoaController(CadastrarPessoaUseCase cadastrarPessoaUseCase, ConsultarPessoaUseCase consultarPessoaUseCase, PessoaMapper pessoaMapper) {
        this.cadastrarPessoaUseCase = cadastrarPessoaUseCase;
        this.consultarPessoaUseCase = consultarPessoaUseCase;
        this.pessoaMapper = pessoaMapper;
    }

    @PostMapping("")
    public ResponseEntity<PessoaDtoResponse> cadastrarPessoa(@RequestBody PessoaDtoRequest pessoaDtoRequest){
        // mapper PessoaDto -> Pessoa

        Pessoa pessoaModel = pessoaMapper.toModel(pessoaDtoRequest);
        PessoaDtoResponse response = pessoaMapper.toResponse(cadastrarPessoaUseCase.CadastrarPessoa(pessoaModel));

//        ApiResponse<Pessoa> response = ApiResponse.<Pessoa>builder()
//                .data(pessoa)
//                .mensagem("Pessoa criada")
//                .status(HttpStatus.CREATED)
//                .build();

        return response != null ?
                ResponseEntity.created(URI.create("/api/pessoa/"+response.getPessoaId())).body(response)
                :ResponseEntity.badRequest().build();
    }

    @GetMapping("")
    public ResponseEntity<List<PessoaDtoResponse>> listaTodasPessoas(){
        return ResponseEntity.ok(pessoaMapper.fromListPessoa(consultarPessoaUseCase.ConsultaTodasPessoas()));
    }

    @GetMapping
    public ResponseEntity<PessoaDtoResponse> consultarPessoa(@RequestParam Long idPessoa){

        PessoaDtoResponse response = consultarPessoaUseCase.(idPessoa)

        return ResponseEntity.ok(ApiResponse.builder().data(PessoaDtoResponse.builder()))..build();
    }
}
