package com.universidade.gerenciamento_pessoas.Controller;

import com.universidade.gerenciamento_pessoas.DTO.PessoaDTO;
import com.universidade.gerenciamento_pessoas.model.Pessoa;
import com.universidade.gerenciamento_pessoas.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.List;

@RestController
@RequestMapping("/api/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping
    public ResponseEntity<Pessoa> criarPessoa(@RequestBody PessoaDTO pessoaDTO) {
        Pessoa pessoaSalva = pessoaService.criarPessoa(pessoaDTO);
        return ResponseEntity.status(201).body(pessoaSalva);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> getPessoaPorId(@PathVariable Long id) {
        Optional<Pessoa> pessoa = pessoaService.buscarPorId(id);
        return pessoa.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pessoa> atualizarPessoa(@PathVariable Long id, @RequestBody PessoaDTO pessoaDTO) {
        Pessoa pessoaAtualizada = pessoaService.atualizarPessoa(id, pessoaDTO);
        return ResponseEntity.ok(pessoaAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPessoa(@PathVariable Long id) {
        pessoaService.deletarPessoa(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/buscar")
    public ResponseEntity<List<Pessoa>> buscarPorNomeEIdade(
            @RequestParam String nome,
            @RequestParam int idade
    ) {
        List<Pessoa> pessoas = pessoaService.buscarPorNomeEIdade(nome, idade);
        return ResponseEntity.ok(pessoas);
    }
}
