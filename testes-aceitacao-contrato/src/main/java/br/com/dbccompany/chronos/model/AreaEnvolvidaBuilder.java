package br.com.dbccompany.chronos.model;

public class AreaEnvolvidaBuilder {
    private String nome;

    public AreaEnvolvidaBuilder nome(String nome) {
        this.nome = nome;
        return this;
    }

    public AreaEnvolvida build() {
        return new AreaEnvolvida(nome);
    }
}
