package br.com.dbccompany.chronos.model;

public class UserBuilder {
    private String email;
    private String nome;
    private String[] cargos;

    public UserBuilder email(String email) {
        this.email = email;
        return this;
    }
    public UserBuilder nome(String nome) {
        this.nome = nome;
        return this;
    }
    public UserBuilder cargos(String[] cargos) {
        this.cargos = cargos;
        return this;
    }

    public User build() {
        return new User(email, nome, cargos);
    }

}
