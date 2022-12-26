package br.com.dbccompany.chronos.data.changeless.enums;

public enum ProcessoCritico {
    Ativo("ATIVO"),
    Inativo("INATIVO");
    private String nome;
    ProcessoCritico(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return nome;
    }
}
