package br.com.dbccompany.chronos.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties
public class UsuarioDTO<T> {
    String login;
    Integer idUsuario;
    T imagem;
    CargoDTO[] cargos;
}
