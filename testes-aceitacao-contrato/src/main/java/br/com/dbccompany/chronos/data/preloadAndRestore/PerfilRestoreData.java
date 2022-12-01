package br.com.dbccompany.chronos.data.preloadAndRestore;

import br.com.dbccompany.chronos.client.UsuarioClient;
import br.com.dbccompany.chronos.data.factory.PerfilDataFactory;
import br.com.dbccompany.chronos.model.Perfil;
import br.com.dbccompany.chronos.utils.Utils;
import io.restassured.response.Response;

public class PerfilRestoreData {

    public static Response restaurarPerfil(String senhaAtual){
        Perfil perfil = PerfilDataFactory.perfilRestore(senhaAtual);
        return UsuarioClient.atualizarPerfil(Utils.converterParaJson(perfil),true);
    }

}
