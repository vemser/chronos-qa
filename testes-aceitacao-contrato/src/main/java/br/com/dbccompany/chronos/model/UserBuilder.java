package br.com.dbccompany.chronos.model;

public class UserBuilder {
    private String login;
    private Cargo[] cargos;

    public UserBuilder login(String login) {
        this.login = login;
        return this;
    }
    public UserBuilder cargos(Cargo[] cargos) {
        this.cargos = cargos;
        return this;
    }
    public User build() {
        return new User(login, cargos);
    }

}
