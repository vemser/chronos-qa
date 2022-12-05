package br.com.dbccompany.chronos.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties
public class CargoDTO {
    Integer idCargo;
    String nome;
    String descricao;
}
