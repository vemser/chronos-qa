package br.com.dbccompany.chronos.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties
public class ResponseListUserDTO {
    Integer totalElementos;
    Integer quantidadePaginas;
    Integer pagina;
    Integer tamanho;
    UsuarioDTO[] elementos;
}
