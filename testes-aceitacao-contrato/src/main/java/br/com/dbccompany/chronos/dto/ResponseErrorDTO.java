package br.com.dbccompany.chronos.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties
public abstract class ResponseErrorDTO {
    private String timestamp;
    private Integer status;
}
