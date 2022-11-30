package br.com.dbccompany.chronos.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties
public class UsuarioDTO<T> {
    String nome;
    String email;
    String status;
    Integer idUsuario;
    T imagem;
    CargoDTO[] cargos;
}
