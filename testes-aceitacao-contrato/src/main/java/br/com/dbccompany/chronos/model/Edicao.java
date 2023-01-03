package br.com.dbccompany.chronos.model;

import lombok.Data;

@Data
public class Edicao {
    String nome;
    String dataInicial;

    public Edicao(String nome, String dataInicial) {
        this.nome = nome;
        this.dataInicial = dataInicial;
    }
}
