package com.example.bancoH2.adapters.in.web.controllers;

import com.example.bancoH2.adapters.in.web.ApiResponse;
import com.example.bancoH2.adapters.in.web.PessoaPath;
import com.example.bancoH2.adapters.in.web.dto.pessoa.ApiResponsePage;
import com.example.bancoH2.adapters.in.web.dto.pessoa.PaginationResponse;
import com.example.bancoH2.adapters.in.web.dto.pessoa.PessoaDtoRequest;
import com.example.bancoH2.adapters.in.web.dto.pessoa.PessoaDtoResponse;
import com.example.bancoH2.adapters.out.jpa.entities.pessoa.mapper.PessoaMapper;
import com.example.bancoH2.core.models.pessoa.Pessoa;
import com.example.bancoH2.core.ports.usecases.pessoa.AlterarPessoaUseCase;
import com.example.bancoH2.core.ports.usecases.pessoa.CadastrarPessoaUseCase;
import com.example.bancoH2.core.ports.usecases.pessoa.ConsultarPessoaUseCase;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@PessoaPath
//@Validated
public class PessoaController {


    private final CadastrarPessoaUseCase cadastrarPessoaUseCase;
    private final ConsultarPessoaUseCase consultarPessoaUseCase;
    private final AlterarPessoaUseCase alterarPessoaUseCase;
    private final PessoaMapper pessoaMapper;

    public PessoaController(CadastrarPessoaUseCase cadastrarPessoaUseCase, ConsultarPessoaUseCase consultarPessoaUseCase, AlterarPessoaUseCase alterarPessoaUseCase, PessoaMapper pessoaMapper) {
        this.cadastrarPessoaUseCase = cadastrarPessoaUseCase;
        this.consultarPessoaUseCase = consultarPessoaUseCase;
        this.alterarPessoaUseCase = alterarPessoaUseCase;
        this.pessoaMapper = pessoaMapper;
    }

    @PostMapping("")
    public ResponseEntity<Object> cadastrarPessoa(@RequestBody PessoaDtoRequest pessoaDtoRequest){
        // mapper PessoaDto -> Pessoa

        Pessoa pessoaModel = pessoaMapper.toModel(pessoaDtoRequest);
        PessoaDtoResponse response = pessoaMapper.toResponse(cadastrarPessoaUseCase.CadastrarPessoa(pessoaModel));

        return response != null ?
                ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.builder()
                                .status(HttpStatus.CREATED)
                                .message("Pessoa registrada com sucesso .")
                                .data(URI.create("/api/pessoa/"+response.getPessoaId()))
                                .build()) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ApiResponse.builder()
                        .status(HttpStatus.BAD_REQUEST)
                        .message("Não foi possivel incluir esta pessoa. Verifique. ")

                        .build());

    }

    @GetMapping
    public ResponseEntity<ApiResponsePage<Object>> listaTodasPessoas(@RequestParam(name="page", defaultValue = "1", required = false) int page,
                                                                     @RequestParam(name= "pageSize", defaultValue = "25", required = false) int pageSize){

        Page<Pessoa> response = consultarPessoaUseCase.ConsultarTodasPessoas(Pageable.ofSize(pageSize).withPage(page - 1));

        return ResponseEntity.status(HttpStatus.OK).body(ApiResponsePage.builder()
                .data(Arrays.asList(response.getContent().toArray()))
                .pageResponse(PaginationResponse.builder()
                        .page(response.getNumber())
                        .pageSize(response.getSize())
                        .totalPages(response.getTotalPages())


                        .totalElements(response.getTotalElements())
                        .build())
                .build());
    }

    @GetMapping("/{idPessoa}")
    public ResponseEntity<Object> consultarPessoa(@PathVariable(name="idPessoa") Long idPessoa){

        Pessoa response = consultarPessoaUseCase.ConsultarPessoaUseCase(idPessoa);

        return response != null ?
                ResponseEntity.status(HttpStatus.OK).body(ApiResponse.builder()
                        .status(HttpStatus.OK)
                        .message("Consulta realizazada com sucesso .")
                        .data(response)
                        .build()) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(ApiResponse.builder()
                        .status(HttpStatus.NOT_FOUND)
                        .message("Não foi encontrar a pessoa. Verifique. ")

                        .build());
    }

    @PutMapping(path="/{idPessoa}")
    public ResponseEntity<Void> atualizarPessoa(@PathVariable(name="idPessoa") Long idPessoa,
                                                @RequestBody PessoaDtoRequest pessoaDtoRequest){

        Pessoa pessoa = alterarPessoaUseCase.atualizarPessoa(idPessoa, pessoaDtoRequest);

        return pessoa == null ? ResponseEntity.status(HttpStatus.NOT_FOUND).build() :
                ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
