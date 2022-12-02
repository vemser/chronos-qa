package br.com.dbccompany.chronos.model;

import lombok.Data;

public class ResponsavelBuilder {
    private String nome;

    public ResponsavelBuilder nome(String nome){
        this.nome = nome;
        return this;
    }

    public Responsavel build(){
        return new Responsavel(nome);
    }
}
