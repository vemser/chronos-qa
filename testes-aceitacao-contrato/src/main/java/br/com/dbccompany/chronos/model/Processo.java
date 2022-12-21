package br.com.dbccompany.chronos.model;

import lombok.Data;

@Data
public class Processo {
    private String nome;
    private AreaEnvolvida[] areasEnvolvidas;
    private Responsavel[] responsaveis;
    private String duracaoProcesso;
    private Integer diasUteis;
    private Integer ordemExecucao;
    private String processoCritico;

    public Processo(String nome, AreaEnvolvida[] areasEnvolvidas, Responsavel[] responsaveis, String duracaoProcesso, Integer diasUteis, Integer ordemExecucao, String processoCritico) {
        this.nome = nome;
        this.areasEnvolvidas = areasEnvolvidas;
        this.responsaveis = responsaveis;
        this.duracaoProcesso = duracaoProcesso;
        this.diasUteis = diasUteis;
        this.ordemExecucao = ordemExecucao;
        this.processoCritico = processoCritico;
    }
}
