package br.com.dbccompany.chronos.testes.usuario;

import br.com.dbccompany.chronos.client.UsuarioClient;
import br.com.dbccompany.chronos.dto.UsuarioDTO;
import br.com.dbccompany.chronos.testes.BaseTest;
import br.com.dbccompany.chronos.utils.ConfigManipulation;
import org.junit.Assert;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class UsuarioListarLogado extends BaseTest {
    @Test
    @Tag("todos")
    @Tag("usuario")
    public void deveListarUsuarioLogadoComSucesso() {
        UsuarioDTO response = UsuarioClient.listarUsuarioLogado(true)
                .then()
                .extract().as(UsuarioDTO.class);
        Assert.assertEquals(ConfigManipulation.getProp().getProperty("emailAdm"), response.getEmail());
    }
}
