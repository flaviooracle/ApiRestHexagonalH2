package com.example.bancoH2.adapters.in.web.dto.pessoa;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaginationResponse {
    private Integer page;
    private Integer pageSize;
    private Long totalElements;
    private Integer totalPages;
}
