package com.example.bancoH2.core.exceptions;

import com.example.bancoH2.core.models.response.ApiResponse;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ApiResponse<String>> handleEntityNotFoundException(EntityNotFoundException ex){
        ApiResponse<String> response = ApiResponse.<String>builder()
                .data(null)
                .mensagem("Not Found")
                .status(HttpStatus.NOT_FOUND)
                .codigoErroEspecifico(ex.getMessage())
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

}
