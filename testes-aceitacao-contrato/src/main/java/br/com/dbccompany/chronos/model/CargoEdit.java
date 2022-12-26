package br.com.dbccompany.chronos.model;

import lombok.Data;

@Data
public class CargoEdit {
    private Cargo[] cargos;

    public CargoEdit(Cargo[] cargos){
        this.cargos = cargos;
    }
}
