package br.com.dbccompany.chronos.utils;

import br.com.dbccompany.chronos.client.AreaEnvolvidaClient;
import br.com.dbccompany.chronos.client.ResponsavelClient;
import br.com.dbccompany.chronos.data.factory.AreaEnvolvidaDataFactory;
import br.com.dbccompany.chronos.data.factory.ResponsavelDataFactory;
import br.com.dbccompany.chronos.dto.AreaEnvolvidaDTO;
import br.com.dbccompany.chronos.dto.ResponsavelDTO;
import br.com.dbccompany.chronos.model.AreaEnvolvida;
import br.com.dbccompany.chronos.model.Responsavel;
import br.com.dbccompany.chronos.utils.Utils;

public class PreloadData {
    public static ResponsavelDTO responsavel(){
        Responsavel responsavel = ResponsavelDataFactory.responsavelValido();
        return ResponsavelClient.criarResponsavel(Utils.converterParaJson(responsavel), true)
                .then()
                .log().all()
                .extract().as(ResponsavelDTO.class);
    }
    public static AreaEnvolvidaDTO areaEnvolvida(){
        AreaEnvolvida areaEnvolvida = AreaEnvolvidaDataFactory.areaEnvolvidaValida();
        return AreaEnvolvidaClient.criarAreaEnvolvida(Utils.converterParaJson(areaEnvolvida), true)
                .then()
                .log().all()
                .extract().as(AreaEnvolvidaDTO.class);
    }
}
