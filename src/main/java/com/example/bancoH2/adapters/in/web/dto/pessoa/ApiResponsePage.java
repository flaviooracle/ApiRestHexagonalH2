package com.example.bancoH2.adapters.in.web.dto.pessoa;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ApiResponsePage<T> {
    private List<T> data;
    private PaginationResponse pageResponse;
}
