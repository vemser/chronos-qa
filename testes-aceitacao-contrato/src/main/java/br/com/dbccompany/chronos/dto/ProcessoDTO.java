package br.com.dbccompany.chronos.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties
public class ProcessoDTO {
    Integer idProcesso;
    String nome;
    String duracaoProcesso;
    Integer diasUteis;
    Integer ordemExecucao;
    AreaEnvolvidaDTO[] areasEnvolvidas;
    ResponsavelDTO[] responsaveis;
    String processoCritico;
}
