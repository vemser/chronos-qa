package br.com.dbccompany.chronos.testes.aceitacao.usuario;

import br.com.dbccompany.chronos.client.UsuarioClient;
import br.com.dbccompany.chronos.dto.UsuarioDTO;
import br.com.dbccompany.chronos.testes.BaseTest;
import br.com.dbccompany.chronos.utils.ConfigManipulation;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class UsuarioListarLogadoTest extends BaseTest {
    @Test
    @Tag("todos")
    @Tag("usuario")
    @Owner("Kevin Aryel")
    @Epic("Aceitação")
    @Feature("Usuário")
    @Story("Listar Usuário Logado")
    @Description("Deve listar usuario logado com sucesso")
    public void deveListarUsuarioLogadoComSucesso() {
        UsuarioDTO response = UsuarioClient.listarUsuarioLogado(true)
                .then()
                .extract().as(UsuarioDTO.class);
        Assert.assertEquals(ConfigManipulation.getProp().getProperty("userQa"), response.getLogin());
    }
    @Test
    @Tag("todos")
    @Tag("usuario")
    @Owner("Kevin Aryel")
    @Epic("Aceitação")
    @Feature("Usuário")
    @Story("Listar Usuário Logado")
    @Description("Deve retornar erro ao tentar listar usuario logado sem auth")
    public void deveFalharListarUsuarioLogadoSemAuth() {
        Response response = UsuarioClient.listarUsuarioLogado(false)
                .then()
                .extract().response();
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_FORBIDDEN);
    }
}
