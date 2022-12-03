package br.com.dbccompany.chronos.model;

public class ProcessoBuilder {
    private String nome;
    private AreaEnvolvida[] areasEnvolvidas;
    private Responsavel[] responsaveis;
    private String duracaoProcesso;
    private Integer diasUteis;
    private Integer ordemExecucao;

    public ProcessoBuilder nome(String nome) {
        this.nome = nome;
        return this;
    }

    public ProcessoBuilder areasEnvolvidas(AreaEnvolvida[] areasEnvolvidas) {
        this.areasEnvolvidas = areasEnvolvidas;
        return this;
    }

    public ProcessoBuilder responsaveis(Responsavel[] responsaveis) {
        this.responsaveis = responsaveis;
        return this;
    }
    public ProcessoBuilder duracaoProcesso(String duracaoProcesso) {
        this.duracaoProcesso = duracaoProcesso;
        return this;
    }
    public ProcessoBuilder diasUteis(Integer diasUteis) {
        this.diasUteis = diasUteis;
        return this;
    }
    public ProcessoBuilder ordemExecucao(Integer ordemExecucao) {
        this.ordemExecucao = ordemExecucao;
        return this;
    }
    public Processo build() {
        return new Processo(nome, areasEnvolvidas, responsaveis, duracaoProcesso, diasUteis, ordemExecucao);
    }
}
