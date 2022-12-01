package br.com.dbccompany.chronos.model;

import lombok.Data;

@Data
public class Edicao {
    String nome;
    String dataInicial;
    String dataFinal;

    public Edicao(String nome, String dataInicial, String dataFinal) {
        this.nome = nome;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
    }
}
