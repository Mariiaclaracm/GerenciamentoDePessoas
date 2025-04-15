package com.universidade.gerenciamento_pessoas.model;

import lombok.Data;
import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name="pessoa")
@Data
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String cpf;
    private int idade;

    public void setIdade(Object idade) {
    }

    public void setCpf(Object cpf) {
    }

    public void setNome(Object nome) {
    }

}