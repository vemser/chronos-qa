package br.com.dbccompany.chronos.data.factory;

import br.com.dbccompany.chronos.data.changeless.enums.CargoValido;
import br.com.dbccompany.chronos.model.Cargo;
import br.com.dbccompany.chronos.model.CargoBuilder;
import br.com.dbccompany.chronos.utils.Utils;

public class CargoDataFactory {
    private static Cargo cargoAdmin(){
        return new CargoBuilder()
                .nome(CargoValido.Administrador.getNome())
                .descricao("Administrador")
                .build();
    }

    private static Cargo cargoInstrutor(){
        return new CargoBuilder()
                .nome(CargoValido.Instrutor.getNome())
                .descricao("Instrutor")
                .build();
    }
    private static Cargo cargoGestaoDePessoas(){
        return new CargoBuilder()
                .nome(CargoValido.GestaoDePessoas.getNome())
                .descricao("Gestão de Pessoas")
                .build();
    }
    private static Cargo cargoInvalido(){
        return new CargoBuilder()
                .nome("CARGO_INVALIDO")
                .descricao("Cargo Inválido")
                .build();
    }

    public static Cargo[] cargosVazio(){
        return new Cargo[0];
    }

    public static Cargo[] cargosInvalido() {
      return new Cargo[]{cargoAdmin(),cargoInvalido()};
    }

    public static Cargo[] cargoUnico(){
        Integer num = Utils.faker.number().numberBetween(1,3);
        switch (num){
            case 2:{
                return new Cargo[]{cargoInstrutor()};
            }
            case 3:{
                return new Cargo[]{cargoGestaoDePessoas()};
            }
            default: {
                return new Cargo[]{cargoAdmin()};
            }
        }
    }

    public static Cargo[] cargoDuplo(){
        return new Cargo[]{cargoAdmin(),cargoGestaoDePessoas()};
    }
}
