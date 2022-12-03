package br.com.dbccompany.chronos.testes.usuario;

import br.com.dbccompany.chronos.client.UsuarioClient;
import br.com.dbccompany.chronos.dto.ResponseListUserDTO;
import br.com.dbccompany.chronos.testes.BaseTest;
import io.qameta.allure.Description;
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
    @Description("Deve listar todos usuarios com auth de  sem dados")
    public void deveListarUsuarioComSucesso() {
        ResponseListUserDTO response = UsuarioClient.listarUsuarios(true)
                .then()
                .extract().as(ResponseListUserDTO.class);
        assertAll("response",
                () -> Assert.assertEquals(0, response.getPagina().intValue()),
                () -> Assert.assertTrue(response.getTotalElementos().intValue() > 3)
        );
    }

    @Test
    @Tag("todos")
    @Tag("usuario")
    @Description("Deve retornar erro ao tentar listar todos usuarios sem auth")
    public void deveFalharListarUsuarioSemAuth() {
        Response response = UsuarioClient.listarUsuarios(false)
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_FORBIDDEN).extract().response();
        Assert.assertEquals(response.statusCode(), HttpStatus.SC_FORBIDDEN);
    }

}
