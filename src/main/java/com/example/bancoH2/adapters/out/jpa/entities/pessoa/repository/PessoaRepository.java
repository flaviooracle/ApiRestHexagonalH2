package com.example.bancoH2.adapters.out.jpa.entities.pessoa.repository;

import com.example.bancoH2.adapters.out.jpa.entities.pessoa.entity.PessoaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PessoaRepository extends JpaRepository<PessoaEntity, Long> {
    // Métodos de consulta personalizados, se necessário


    @Query("Select g from PessoaEntity g")
    Page<PessoaEntity> findAllPessoas(Pageable pageable);
}
