package br.com.dbccompany.chronos.model;

import lombok.Data;

@Data
public class Etapa {
    private String nome;
    private Integer ordemExecucao;

    public Etapa(String nome, Integer ordemExecucao) {
        this.nome = nome;
        this.ordemExecucao = ordemExecucao;
    }
}
