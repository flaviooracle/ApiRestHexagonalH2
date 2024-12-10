package com.example.bancoH2.adapters.out.jpa.entities.pessoa.repository;

import com.example.bancoH2.adapters.out.jpa.entities.pessoa.entity.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<PessoaEntity, Long> {
    // Métodos de consulta personalizados, se necessário
}
