package com.universidade.gerenciamento_pessoas.repository;

import com.universidade.gerenciamento_pessoas.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}