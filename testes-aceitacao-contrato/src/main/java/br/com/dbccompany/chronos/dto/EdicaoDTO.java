package br.com.dbccompany.chronos.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties
public class EdicaoDTO {
    String nome;
    String dataInicial;
    String dataFinal;
    String status;
    Integer idEdicao;
    EtapaDTO[] etapas;
}
