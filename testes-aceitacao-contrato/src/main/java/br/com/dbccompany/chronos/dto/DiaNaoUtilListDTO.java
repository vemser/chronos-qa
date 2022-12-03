package br.com.dbccompany.chronos.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties
public class DiaNaoUtilListDTO {
    Integer totalElementos;
    Integer pagina;
    Integer quantidadePaginas;
    Integer tamanho;
    DiaNaoUtilDTO[] elementos;
}
