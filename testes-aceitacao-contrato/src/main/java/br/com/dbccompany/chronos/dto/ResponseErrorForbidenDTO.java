package br.com.dbccompany.chronos.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties
public class ResponseErrorForbidenDTO extends ResponseErrorDTO {
    private String error;
    private String path;
}
