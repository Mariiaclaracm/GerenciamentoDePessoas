package com.universidade.gerenciamento_pessoas.exception;

public class PessoaNotFoundException extends RuntimeException {
    public PessoaNotFoundException(String message) {
        super(message);
    }
}

