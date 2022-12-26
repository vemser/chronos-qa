package br.com.dbccompany.chronos.testes.aceitacao.usuario;

import br.com.dbccompany.chronos.client.UsuarioClient;
import br.com.dbccompany.chronos.dto.ResponseListUserDTO;
import br.com.dbccompany.chronos.testes.BaseTest;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;

public class UsuarioGetTest extends BaseTest {

    @Test
    @Tag("todos")
    @Tag("usuario")
    @Owner("Kevin Aryel")
    @Epic("Aceitação")
    @Feature("Usuário")
    @Story("Listar Usuários")
    @Description("Deve retornar erro ao tentar listar todos usuarios sem auth")
    public void deveFalharListarUsuarioSemAuth() {
        Response response = UsuarioClient.listarUsuarios(false)
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_FORBIDDEN).extract().response();
        Assert.assertEquals(response.statusCode(), HttpStatus.SC_FORBIDDEN);
    }

}
