package br.com.dbccompany.chronos.model;

public class DiaNaoUtilBuilder {
    private String descricao;
    private String dataInicial;
    private String dataFinal;
    private String repeticaoAnual;

    public DiaNaoUtilBuilder descricao(String descricao) {
        this.descricao = descricao;
        return this;
    }
    public DiaNaoUtilBuilder dataInicial(String dataInicial) {
        this.dataInicial = dataInicial;
        return this;
    }
    public DiaNaoUtilBuilder dataFinal(String dataFinal) {
        this.dataFinal = dataFinal;
        return this;
    }
    public DiaNaoUtilBuilder repeticaoAnual(String repeticaoAnual) {
        this.repeticaoAnual = repeticaoAnual;
        return this;
    }

    public DiaNaoUtil build() {
        return new DiaNaoUtil(descricao, dataInicial, dataFinal, repeticaoAnual);
    }
}
