package br.com.dbccompany.chronos.model;

import lombok.Data;

@Data
public class Perfil {
    String nome;
    String senhaAtual;
    String novaSenha;
    String confirmacaoNovaSenha;

    public Perfil(String nome, String senhaAtual, String novaSenha, String confirmacaoNovaSenha) {
        this.nome = nome;
        this.senhaAtual = senhaAtual;
        this.novaSenha = novaSenha;
        this.confirmacaoNovaSenha = confirmacaoNovaSenha;
    }
}
