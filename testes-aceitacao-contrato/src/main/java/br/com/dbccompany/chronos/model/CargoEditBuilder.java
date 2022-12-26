package br.com.dbccompany.chronos.model;

public class CargoEditBuilder {
    private Cargo[] cargos;

    public CargoEditBuilder cargos(Cargo[] cargos){
        this.cargos = cargos;
        return this;
    }
    public CargoEdit build(){
        return new CargoEdit(cargos);
    }
}
