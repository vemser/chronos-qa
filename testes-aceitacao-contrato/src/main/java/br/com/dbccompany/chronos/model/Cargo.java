package br.com.dbccompany.chronos.model;

import lombok.Data;

@Data
public class Cargo {
    private String nome;
    private String descricao;
    public Cargo(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

}
