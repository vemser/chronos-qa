package br.com.dbccompany.chronos.model;

public class CargoBuilder {
    private String nome;
    private String descricao;

    public CargoBuilder() {
    }

    public CargoBuilder nome(String nome) {
        this.nome = nome;
        return this;
    }

    public CargoBuilder descricao(String descricao) {
        this.descricao = descricao;
        return this;
    }


    public Cargo build() {
        return new Cargo(nome, descricao);
    }
}
