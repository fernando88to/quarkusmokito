package com.fernando;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Pessoa {
    @Id
    public Long id;
    public String nome;

    public Pessoa(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Pessoa() {
    }
}
