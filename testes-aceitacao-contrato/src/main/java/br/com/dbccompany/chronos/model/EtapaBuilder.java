package br.com.dbccompany.chronos.model;

public class EtapaBuilder {
    private String nome;
    private Integer ordemExecucao;

    public EtapaBuilder() {
    }

    public EtapaBuilder nome(String nome) {
        this.nome = nome;
        return this;
    }
    public EtapaBuilder ordemExecucao(Integer ordemExecucao) {
        this.ordemExecucao = ordemExecucao;
        return this;
    }

    public Etapa build() {
        return new Etapa(nome, ordemExecucao);
    }
}
