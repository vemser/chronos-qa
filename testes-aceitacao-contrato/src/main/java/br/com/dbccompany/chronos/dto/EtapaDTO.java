package br.com.dbccompany.chronos.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties
public class EtapaDTO {
    String nome;
    Integer ordemExecucao;
    Integer idEtapa;
    ProcessoDTO[] processos;

}
