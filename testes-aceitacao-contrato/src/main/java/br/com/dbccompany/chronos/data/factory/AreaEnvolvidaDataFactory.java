package br.com.dbccompany.chronos.data.factory;

import br.com.dbccompany.chronos.model.AreaEnvolvida;
import br.com.dbccompany.chronos.model.AreaEnvolvidaBuilder;
import br.com.dbccompany.chronos.utils.Utils;

public class AreaEnvolvidaDataFactory {
    private static String nomeValido = Utils.faker.job().position();

    private static AreaEnvolvida novaAreaEnvolvida(){
        return  new AreaEnvolvidaBuilder()
                .nome(nomeValido)
                .build();
    }
    public static AreaEnvolvida areaEnvolvidaValida(){
        return novaAreaEnvolvida();
    }
    public static AreaEnvolvida areaEnvolvidaSemNome(){
        AreaEnvolvida areaEnvolvidaSemNome = novaAreaEnvolvida();
        areaEnvolvidaSemNome.setNome(null);
        return areaEnvolvidaSemNome;
    }
}
