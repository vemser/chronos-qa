package br.com.dbccompany.chronos.model;

public class PerfilBuilder {
    private String nome;
    private String senhaAtual;
    private String novaSenha;
    private String confirmacaoNovaSenha;

    public PerfilBuilder() {
    }

    public PerfilBuilder nome(String nome) {
        this.nome = nome;
        return this;
    }

    public PerfilBuilder senhaAtual(String senhaAtual) {
        this.senhaAtual = senhaAtual;
        return this;
    }

    public PerfilBuilder novaSenha(String novaSenha) {
        this.novaSenha = novaSenha;
        return this;
    }

    public PerfilBuilder confirmacaoNovaSenha(String confirmacaoNovaSenha) {
        this.confirmacaoNovaSenha = confirmacaoNovaSenha;
        return this;
    }

    public Perfil build() {
        return new Perfil(nome, senhaAtual, novaSenha, confirmacaoNovaSenha);
    }
}
