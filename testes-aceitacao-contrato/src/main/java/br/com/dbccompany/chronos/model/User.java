package br.com.dbccompany.chronos.model;

import lombok.Data;

@Data
public class User {
    private String email;
    private String nome;
    private String[] cargos;

    public User() {
    }
    public User(String email, String nome, String[] cargos) {
        this.email = email;
        this.nome = nome;
        this.cargos = cargos;
    }
}
