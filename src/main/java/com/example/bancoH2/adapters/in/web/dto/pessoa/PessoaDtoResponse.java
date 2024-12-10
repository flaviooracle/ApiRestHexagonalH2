package com.example.bancoH2.adapters.in.web.dto.pessoa;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Data
@Builder
public class PessoaDtoResponse {
    private Long pessoaId;
    private String nome;
    private String cpf;
    private Long idade;
    private LocalDateTime createAt;
}
