package br.com.dbccompany.chronos.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties
public class CalendarioEdicaoItemDTO {
    private String dia;
    private Integer idEtapa;
    private String etapa;
    private Integer idProcesso;
    private String processo;
    private String cor;
    private String[] areas;
    private String feriado;
    private String critico;
}
