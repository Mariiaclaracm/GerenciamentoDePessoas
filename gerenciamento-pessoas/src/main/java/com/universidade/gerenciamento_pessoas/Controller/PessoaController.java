package com.universidade.gerenciamento_pessoas.Controller;

import com.universidade.gerenciamento_pessoas.DTO.PessoaDTO;
import com.universidade.gerenciamento_pessoas.model.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pessoas")
public class PessoaController {

    @Autowired

    @PostMapping
    public ResponseEntity<Pessoa> criarPessoa(@RequestBody PessoaDTO pessoaDTO) {
        return ResponseEntity.status(201).body(pessoaSalva);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> getPessoaPorId(@PathVariable Long id) {
        return pessoa.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    }