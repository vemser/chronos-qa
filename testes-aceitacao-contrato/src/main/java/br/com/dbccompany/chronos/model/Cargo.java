package br.com.dbccompany.chronos.model;

import lombok.Data;

@Data
public class Cargo {
    private String nome;
    private String descricao;
    private Integer idCargo;

    public Cargo(String nome, String descricao, Integer idCargo) {
        this.nome = nome;
        this.descricao = descricao;
        this.idCargo = idCargo;
    }

}
