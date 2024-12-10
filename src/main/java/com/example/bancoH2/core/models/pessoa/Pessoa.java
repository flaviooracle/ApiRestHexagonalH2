package com.example.bancoH2.core.models.pessoa;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@Data
public class Pessoa {

    private Long pessoaId;
    private String nome;
    private String cpf;
    private Long idade;
    private LocalDateTime createAt;

}
