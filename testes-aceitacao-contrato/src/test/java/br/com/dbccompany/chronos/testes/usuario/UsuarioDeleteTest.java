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

public class UsuarioDeleteTest extends BaseTest {;

    @Test
    @Tag("todos")
    @Tag("usuario")
    @Description("Deve falhar deletar usuario sem auth")
    public void deveFalharDeletarUsuarioSemAuth(){
        Response response = UsuarioClient.deletarUsuario("1",false)
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_FORBIDDEN).extract().response();
        Assert.assertEquals(response.statusCode(), HttpStatus.SC_FORBIDDEN);
    }

    @Test
    @Tag("todos")
    @Tag("usuario")
    @Description("Deve falhar deletar usuario com id inválido")
    public void deveFalharDeletarUsuarioComIdInvalido(){
        ResponseErrorBadDTO response = UsuarioClient.deletarUsuario("0",true)
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_BAD_REQUEST).extract().as(ResponseErrorBadDTO.class);
        Assert.assertEquals(response.getStatus().intValue(), HttpStatus.SC_NOT_FOUND);
        Assert.assertTrue(response.getErrors()[0].contains("id:"));
    }

    @Test
    @Tag("todos")
    @Tag("usuario")
    @Description("Deve deletar usuario com sucesso")
    public void deveDeletarUsuarioComSucesso(){
        UsuarioDTO usuario = UserPreloadData.userAdmin();
        Response response = UsuarioClient.deletarUsuario(usuario.getIdUsuario().toString(),true)
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_NO_CONTENT).extract().response();
        Assert.assertEquals(response.statusCode(), HttpStatus.SC_NO_CONTENT);
    }

}
