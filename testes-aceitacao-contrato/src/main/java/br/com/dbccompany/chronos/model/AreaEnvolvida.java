package br.com.dbccompany.chronos.model;

import lombok.Data;

@Data
public class AreaEnvolvida {
    private String nome;

    public AreaEnvolvida(String nome) {
        this.nome = nome;
    }
}
