package br.com.dbccompany.chronos.model;

import lombok.Data;

@Data
public class User {
    private String login;
    private Cargo[] cargos;

    public User() {
    }
    public User(String login, Cargo[] cargos) {
        this.login = login;
        this.cargos = cargos;
    }
}
