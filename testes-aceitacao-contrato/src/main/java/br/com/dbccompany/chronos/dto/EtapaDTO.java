package br.com.dbccompany.chronos.dto;

import lombok.Data;

@Data
public class EtapaDTO {
    String nome;
    Integer ordemExecucao;
    Integer idEtapa;
    ProcessoDTO[] processos;

}
