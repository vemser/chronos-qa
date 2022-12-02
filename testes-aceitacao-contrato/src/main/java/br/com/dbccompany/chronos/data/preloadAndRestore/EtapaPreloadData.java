package br.com.dbccompany.chronos.data.preloadAndRestore;

import br.com.dbccompany.chronos.client.EtapaClient;
import br.com.dbccompany.chronos.data.factory.EtapaDataFactory;
import br.com.dbccompany.chronos.dto.EtapaDTO;
import br.com.dbccompany.chronos.model.Etapa;
import br.com.dbccompany.chronos.utils.Utils;

public class EtapaPreloadData {
    public static EtapaDTO etapaValida(String idEdicao){
        Etapa etapa = EtapaDataFactory.etapaValida();
        return EtapaClient.criarEtapa(Utils.converterParaJson(etapa),idEdicao,true)
                .then()
                .log().all()
                .extract().as(EtapaDTO.class);
    }
}
