package br.com.dbccompany.chronos.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties
public class DiaNaoUtilDTO {
    String descricao;
    String dataInicial;
    String dataFinal;
    String repeticaoAnual;
    Integer idDiaNaoUtil;
}
