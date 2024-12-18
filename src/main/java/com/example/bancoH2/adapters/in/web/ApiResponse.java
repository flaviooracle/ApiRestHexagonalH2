package com.example.bancoH2.adapters.in.web;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class ApiResponse<T> {
    private T data;
    private HttpStatus status;
    private String message;

}
