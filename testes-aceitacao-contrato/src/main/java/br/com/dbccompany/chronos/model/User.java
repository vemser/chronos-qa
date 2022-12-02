package br.com.dbccompany.chronos.model;

import lombok.Data;

@Data
public class User {
    private String email;
    private String nome;
    private Cargo[] cargos;

    public User() {
    }
    public User(String email, String nome, Cargo[] cargos) {
        this.email = email;
        this.nome = nome;
        this.cargos = cargos;
    }
}
