package br.com.dbccompany.chronos.model;

import lombok.Data;

@Data
public class DiaNaoUtil {
    private String descricao;
    private String dataInicial;
    private String dataFinal;
    private String repeticaoAnual;

    public DiaNaoUtil(String descricao, String dataInicial, String dataFinal, String repeticaoAnual) {
        this.descricao = descricao;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.repeticaoAnual = repeticaoAnual;
    }
}
