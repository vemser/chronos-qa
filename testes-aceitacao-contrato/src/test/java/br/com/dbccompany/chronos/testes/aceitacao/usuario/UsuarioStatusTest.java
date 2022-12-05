package br.com.dbccompany.chronos.testes.aceitacao.usuario;

import br.com.dbccompany.chronos.client.UsuarioClient;
import br.com.dbccompany.chronos.dto.ResponseErrorBadDTO;
import br.com.dbccompany.chronos.dto.UsuarioDTO;
import br.com.dbccompany.chronos.testes.BaseTest;
import br.com.dbccompany.chronos.utils.PreloadData;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class UsuarioStatusTest extends BaseTest {

    @Test
    @Tag("todos")
    @Tag("usuario")
    @Owner("Kevin Aryel")
    @Epic("Backend")
    @Feature("Usuário")
    @Story("Editar Status Usuário")
    @Tag("atual")
    @Description("Deve mudar status com sucesso")
    public void deveMudarStatusComSucesso(){
        UsuarioDTO usuario = PreloadData.userAdmin();
        String idUsuario = usuario.getIdUsuario().toString();
        Response response = UsuarioClient.mudarStatusUsuario(idUsuario,true)
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_NO_CONTENT).extract().response();
        Assert.assertEquals(response.statusCode(), HttpStatus.SC_NO_CONTENT);
        UsuarioClient.deletarUsuario(idUsuario,true);
    }

    @Test
    @Tag("todos")
    @Tag("usuario")
    @Owner("Kevin Aryel")
    @Epic("Backend")
    @Feature("Usuário")
    @Story("Editar Status Usuário")
    @Description("Deve retornar erro ao tentar mudar status sem auth")
    public void deveFalharMudarStatusSemAuth(){
        Response response = UsuarioClient.mudarStatusUsuario("1",false)
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_FORBIDDEN).extract().response();
        Assert.assertEquals(response.statusCode(), HttpStatus.SC_FORBIDDEN);
    }

    @Test
    @Tag("todos")
    @Tag("usuario")
    @Owner("Kevin Aryel")
    @Epic("Backend")
    @Feature("Usuário")
    @Story("Editar Status Usuário")
    @Description("Deve retornar erro ao tentar mudar status com id inválido")
    public void deveFalharMudarStatusComIdInvalido(){
        ResponseErrorBadDTO response = UsuarioClient.mudarStatusUsuario("0",true)
                .then()
                .log().all()
                .extract().as(ResponseErrorBadDTO.class);
        Assert.assertEquals(HttpStatus.SC_BAD_REQUEST, response.getStatus().intValue());
    }
}
