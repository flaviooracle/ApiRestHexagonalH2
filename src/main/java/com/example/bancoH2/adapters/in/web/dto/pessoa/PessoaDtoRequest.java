package com.example.bancoH2.adapters.in.web.dto.pessoa;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
//import jakarta.validation.constraints.NotNull;
//import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PessoaDtoRequest {

  //  @NotNull(message = "campo deve ser preenchido")
  //  @Size(max = 30, message = "deve ter no maximo 30 caracter")
    @JsonProperty("nome")
    private String nome;
    @JsonProperty("cpf")
    private String cpf;
    @JsonProperty("idade")
    private Long idade;


}
