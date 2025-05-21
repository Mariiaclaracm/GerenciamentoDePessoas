package com.universidade.gerenciamento_pessoas.service;

import com.universidade.gerenciamento_pessoas.DTO.PessoaDTO;
import com.universidade.gerenciamento_pessoas.model.Pessoa;
import com.universidade.gerenciamento_pessoas.repository.PessoaRepository;
import com.universidade.gerenciamento_pessoas.exception.PessoaNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;
import java.util.List;

@Service
public class PessoaService {

    private static final Logger logger = LoggerFactory.getLogger(PessoaService.class);

    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa criarPessoa(PessoaDTO pessoaDTO) {
        logger.info("Criando nova pessoa: {}", pessoaDTO.getNome());
        Pessoa pessoa = new Pessoa();
        BeanUtils.copyProperties(pessoaDTO, pessoa);
        return pessoaRepository.save(pessoa);
    }

    public Optional<Pessoa> buscarPorId(Long id) {
        logger.info("Buscando pessoa por ID: {}", id);
        return pessoaRepository.findById(id);
    }

    public Pessoa atualizarPessoa(Long id, PessoaDTO pessoaDTO) {
        logger.info("Atualizando pessoa com ID: {}", id);
        Pessoa pessoa = pessoaRepository.findById(id)
                .orElseThrow(() -> new PessoaNotFoundException("Pessoa não encontrada com ID: " + id));
        BeanUtils.copyProperties(pessoaDTO, pessoa);
        return pessoaRepository.save(pessoa);
    }

    public void deletarPessoa(Long id) {
        logger.info("Deletando pessoa com ID: {}", id);
        Pessoa pessoa = pessoaRepository.findById(id)
                .orElseThrow(() -> new PessoaNotFoundException("Pessoa não encontrada com ID: " + id));
        pessoaRepository.delete(pessoa);
    }

    public List<Pessoa> buscarPorNomeEIdade(String nome, int idade) {
        logger.info("Buscando pessoas com nome: {} e idade > {}", nome, idade);
        return pessoaRepository.findByNomeStartingWithAndIdadeGreaterThan(nome, idade);
    }
}
