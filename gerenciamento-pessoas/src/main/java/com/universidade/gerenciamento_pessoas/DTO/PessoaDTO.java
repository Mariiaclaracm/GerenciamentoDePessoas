package com.universidade.gerenciamento_pessoas.DTO;

import lombok.Data;

@Data
public class PessoaDTO {
    public record PessoaDto(String nome, String cpf, Integer idade) {
    }
}
