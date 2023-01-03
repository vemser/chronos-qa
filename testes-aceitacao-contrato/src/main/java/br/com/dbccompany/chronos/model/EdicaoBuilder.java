package br.com.dbccompany.chronos.model;

public class EdicaoBuilder {
    private String nome;
    private String dataInicial;

    public EdicaoBuilder() {
    }

    public EdicaoBuilder nome(String nome) {
        this.nome = nome;
        return this;
    }

    public EdicaoBuilder dataInicial(String dataInicial) {
        this.dataInicial = dataInicial;
        return this;
    }


    public Edicao build() {
        return new Edicao(nome, dataInicial);
    }

}
