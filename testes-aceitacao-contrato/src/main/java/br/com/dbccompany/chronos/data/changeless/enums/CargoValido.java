package br.com.dbccompany.chronos.data.changeless.enums;

public enum CargoValido {
    Administrador("ROLE_ADMIN"),
    Coordenador("ROLE_Gestor"),
    Instrutor("ROLE_INSTRUTOR"),
    Colaborador("ROLE_COLABORADOR"),
    Aluno("ROLE_ALUNO"),
    GestaoDePessoas("ROLE_GESTAO_DE_PESSOAS");

    private String nome;
    CargoValido(String nome){
        this.nome = nome;
    }
    public String getDescricao(){
        return nome;
    }
}
