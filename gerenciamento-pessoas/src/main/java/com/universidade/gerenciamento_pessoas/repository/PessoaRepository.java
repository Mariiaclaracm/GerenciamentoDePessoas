package com.universidade.gerenciamento_pessoas.repository;

import com.universidade.gerenciamento_pessoas.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    List<Pessoa> findByNomeStartingWithAndIdadeGreaterThan(String nome, int idade);
}
