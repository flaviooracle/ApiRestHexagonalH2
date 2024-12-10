package com.example.bancoH2.core.models.response;

import lombok.*;
import org.springframework.http.HttpStatus;


@Builder
@Data
public class ApiResponse<T> {
    private T  data;
    private String mensagem;
    private HttpStatus status;
    private String codigoErroEspecifico;

    public ApiResponse(T data, String codigoErroEspecifico, HttpStatus status, String mensagem) {
        this.codigoErroEspecifico = codigoErroEspecifico;
        this.status = status;
        this.mensagem = mensagem;
    }


}
