package br.com.dbccompany.chronos.model;

import lombok.Data;

@Data
public class Responsavel {
    String nome;

    Responsavel(String nome){
        this.nome = nome;
    }
}
