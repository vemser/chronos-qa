package br.com.dbccompany.chronos.data.factory;

import br.com.dbccompany.chronos.model.Cargo;
import br.com.dbccompany.chronos.model.CargoEdit;
import br.com.dbccompany.chronos.model.CargoEditBuilder;

public class CargoEditDataFactory {
    private static CargoEdit novoCargoEdit(){
        return new CargoEditBuilder()
            .cargos(CargoDataFactory.cargoUnico())
            .build()
        ;
    }
    public static CargoEdit cargoEditValido(){
        return novoCargoEdit();
    }
    public static CargoEdit cargoEditValidoDuplo(){
        CargoEdit cargoEditValidoDuplo = novoCargoEdit();
        cargoEditValidoDuplo.setCargos(CargoDataFactory.cargoDuplo());
        return cargoEditValidoDuplo;
    }
    public static CargoEdit cargoEditVazio(){
        return new CargoEditBuilder()
                .cargos(new Cargo[0])
                .build();
    }
    public static CargoEdit cargoEditInvalido(){
        CargoEdit cargoEditInvalido = novoCargoEdit();
        cargoEditInvalido.setCargos(CargoDataFactory.cargosInvalido());
        return cargoEditInvalido;
    }
}
