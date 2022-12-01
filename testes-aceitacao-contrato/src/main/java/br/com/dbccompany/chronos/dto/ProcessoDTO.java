package br.com.dbccompany.chronos.dto;

import lombok.Data;

@Data
public class ProcessoDTO {
    Integer idProcesso;
    String nome;
    String duracaoProcesso;
    Integer diasUteis;
    Integer ordemExecucao;
    AreaEnvolvidaDTO[] areasEnvolvidas;
    ResponsaveisDTO[] responsaveis;
}
