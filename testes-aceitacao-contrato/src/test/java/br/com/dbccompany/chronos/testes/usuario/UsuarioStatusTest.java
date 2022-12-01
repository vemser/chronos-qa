package br.com.dbccompany.chronos.testes.usuario;

import br.com.dbccompany.chronos.client.UsuarioClient;
import br.com.dbccompany.chronos.data.preloadAndRestore.UserPreloadData;
import br.com.dbccompany.chronos.dto.ResponseErrorBadDTO;
import br.com.dbccompany.chronos.dto.UsuarioDTO;
import br.com.dbccompany.chronos.testes.BaseTest;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class UsuarioStatusTest extends BaseTest {

    @Test
    @Tag("todos")
    @Tag("usuario")
    @Description("Deve falhar mudar status sem auth")
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
    @Description("Deve falhar mudar status com id inválido")
    public void deveFalharMudarStatusComIdInvalido(){
        ResponseErrorBadDTO response = UsuarioClient.mudarStatusUsuario("0",true)
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_BAD_REQUEST).extract().as(ResponseErrorBadDTO.class);
        Assert.assertEquals(response.getStatus().intValue(), HttpStatus.SC_NOT_FOUND);
        Assert.assertTrue(response.getErrors()[0].contains("id:"));
    }

    @Test
    @Tag("todos")
    @Tag("usuario")
    @Description("Deve mudar status com sucesso")
    public void deveMudarStatusComSucesso(){
        UsuarioDTO usuario = UserPreloadData.userAdmin();
        String idUsuario = usuario.getIdUsuario().toString();
        Response response = UsuarioClient.mudarStatusUsuario(idUsuario,true)
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_NO_CONTENT).extract().response();
        Assert.assertEquals(response.statusCode(), HttpStatus.SC_NO_CONTENT);
        UsuarioClient.deletarUsuario(idUsuario,true);
    }

}
