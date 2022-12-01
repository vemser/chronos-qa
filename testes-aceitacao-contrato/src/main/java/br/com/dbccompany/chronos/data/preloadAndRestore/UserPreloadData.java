package br.com.dbccompany.chronos.data.preloadAndRestore;

import br.com.dbccompany.chronos.client.UsuarioClient;
import br.com.dbccompany.chronos.data.factory.UserDataFactory;
import br.com.dbccompany.chronos.dto.UsuarioDTO;
import br.com.dbccompany.chronos.model.User;
import br.com.dbccompany.chronos.utils.Utils;

public class UserPreloadData {
    public static UsuarioDTO userAdmin(){
        User usuario = UserDataFactory.usuarioValido();
        UsuarioDTO userAdmin = UsuarioClient.cadastrarUsuario(Utils.converterParaJson(usuario),true)
                .then()
                .log().all().extract().as(UsuarioDTO.class);
        return userAdmin;
    }
}
