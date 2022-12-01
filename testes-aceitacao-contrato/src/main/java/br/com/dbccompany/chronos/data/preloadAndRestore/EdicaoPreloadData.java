package br.com.dbccompany.chronos.data.preloadAndRestore;

import br.com.dbccompany.chronos.client.EdicaoClient;
import br.com.dbccompany.chronos.data.factory.EdicaoDataFactory;
import br.com.dbccompany.chronos.dto.EdicaoDTO;
import br.com.dbccompany.chronos.model.Edicao;
import br.com.dbccompany.chronos.utils.Utils;

public class EdicaoPreloadData {
    public static EdicaoDTO edicaoValida(){
        Edicao edicao = EdicaoDataFactory.edicaoValida();
        return EdicaoClient.cadastrarEdicao(Utils.converterParaJson(edicao),true)
                .then()
                .extract().as(EdicaoDTO.class);
    }
}
