package br.com.dbccompany.chronos.testes.usuario;

import br.com.dbccompany.chronos.client.UsuarioClient;
import br.com.dbccompany.chronos.data.factory.UserDataFactory;
import br.com.dbccompany.chronos.dto.ResponseErrorBadDTO;
import br.com.dbccompany.chronos.dto.UsuarioDTO;
import br.com.dbccompany.chronos.model.User;
import br.com.dbccompany.chronos.testes.BaseTest;
import br.com.dbccompany.chronos.utils.Utils;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;

public class UsuarioCreateTest extends BaseTest {

    @Test
    @Tag("todos")
    @Tag("usuario")
    @Owner("Kevin Aryel")
    @Epic("Backend")
    @Feature("Usuário")
    @Story("Criar Usuário")
    @Description("Deve criar usuario com sucesso")
    public void deveCriarUsuarioComSucesso(){
        User user = UserDataFactory.usuarioValido();
        UsuarioDTO response = UsuarioClient.cadastrarUsuario(Utils.converterParaJson(user),true)
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_OK).extract().as(UsuarioDTO.class)
                ;
        assertAll("Usuario",
                () -> Assert.assertEquals(response.getStatus(), "ATIVO"),
                () -> Assert.assertEquals(response.getNome(), user.getNome())
        );
        UsuarioClient.deletarUsuario(response.getIdUsuario().toString(),true);
    }

    @Test
    @Tag("todos")
    @Tag("usuario")
    @Owner("Kevin Aryel")
    @Epic("Backend")
    @Feature("Usuário")
    @Story("Criar Usuário")
    @Description("Deve retornar erro ao tentar criar usuario sem nome")
    public void deveFalharCriarUsuarioSemNome(){
        User user = UserDataFactory.userSemNome();
        ResponseErrorBadDTO response = UsuarioClient.cadastrarUsuario(Utils.converterParaJson(user),true)
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_BAD_REQUEST).extract().as(ResponseErrorBadDTO.class);
        Assert.assertEquals(response.getStatus().intValue(), HttpStatus.SC_BAD_REQUEST);
    }


    @Test
    @Tag("todos")
    @Tag("usuario")
    @Owner("Kevin Aryel")
    @Epic("Backend")
    @Feature("Usuário")
    @Story("Criar Usuário")
    @Description("Deve retornar erro ao tentar criar usuario sem email")
    public void deveFalharCriarUsuarioSemEmail(){
        User user = UserDataFactory.userSemEmail();
        ResponseErrorBadDTO response = UsuarioClient.cadastrarUsuario(Utils.converterParaJson(user),true)
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_BAD_REQUEST).extract().as(ResponseErrorBadDTO.class);
        Assert.assertEquals(response.getStatus().intValue(), HttpStatus.SC_BAD_REQUEST);
    }

    @Test
    @Tag("todos")
    @Tag("usuario")
    @Owner("Kevin Aryel")
    @Epic("Backend")
    @Feature("Usuário")
    @Story("Criar Usuário")
    @Description("Deve retornar erro ao tentar criar usuario sem cargo")
    public void deveFalharCriarUsuarioSemCargo(){
        User user = UserDataFactory.userSemCargo();
        ResponseErrorBadDTO response = UsuarioClient.cadastrarUsuario(Utils.converterParaJson(user),true)
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_BAD_REQUEST).extract().as(ResponseErrorBadDTO.class);
        Assert.assertEquals(response.getStatus().intValue(), HttpStatus.SC_BAD_REQUEST);
        Assert.assertTrue(response.getErrors()[0].contains("cargos:"));
    }

    @Test
    @Tag("todos")
    @Tag("usuario")
    @Owner("Kevin Aryel")
    @Epic("Backend")
    @Feature("Usuário")
    @Story("Criar Usuário")
    @Description("Deve retornar erro ao tentar criar usuario com cargos vazio")
    public void deveFalharCriarUsuarioCargoVazio(){
        User user = UserDataFactory.userComCargoVazio();
        ResponseErrorBadDTO response = UsuarioClient.cadastrarUsuario(Utils.converterParaJson(user),true)
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_BAD_REQUEST).extract().as(ResponseErrorBadDTO.class);
        Assert.assertEquals(response.getStatus().intValue(), HttpStatus.SC_BAD_REQUEST);
    }

    @Test
    @Tag("todos")
    @Tag("usuario")
    @Owner("Kevin Aryel")
    @Epic("Backend")
    @Feature("Usuário")
    @Story("Criar Usuário")
    @Description("Deve retornar erro ao tentar criar usuario com cargo invalido")
    public void deveFalharCriarUsuarioCargosInvalido(){
        User user = UserDataFactory.userComCargoInvalido();
        ResponseErrorBadDTO response = UsuarioClient.cadastrarUsuario(Utils.converterParaJson(user),true)
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_BAD_REQUEST).extract().as(ResponseErrorBadDTO.class);
        Assert.assertEquals(response.getStatus().intValue(), HttpStatus.SC_BAD_REQUEST);
    }

    @Test
    @Tag("todos")
    @Tag("usuario")
    @Owner("Kevin Aryel")
    @Epic("Backend")
    @Feature("Usuário")
    @Story("Criar Usuário")
    @Description("Deve retornar erro ao tentar criar usuario com email invalido")
    public void deveFalharCriarUsuarioEmailInvalido(){
        User user = UserDataFactory.userComEmailInvalido();
        ResponseErrorBadDTO response = UsuarioClient.cadastrarUsuario(Utils.converterParaJson(user),true)
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_BAD_REQUEST).extract().as(ResponseErrorBadDTO.class);
        Assert.assertEquals(response.getStatus().intValue(), HttpStatus.SC_BAD_REQUEST);
    }

    @Test
    @Tag("todos")
    @Tag("usuario")
    @Owner("Kevin Aryel")
    @Epic("Backend")
    @Feature("Usuário")
    @Story("Criar Usuário")
    @Description("Deve retornar erro ao tentar criar usuario sem auth")
    public void deveFalharCriarUsuarioSemAuth() {
        User user = UserDataFactory.usuarioValido();
        Response response = UsuarioClient.cadastrarUsuario(Utils.converterParaJson(user),false)
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
    @Story("Criar Usuário")
    @Description("Deve retornar erro ao tentar criar usuario com email duplicado")
    public void deveFalharCriarUsuarioEmailDuplicado(){
        User user = UserDataFactory.userComEmailDuplicado();
        ResponseErrorBadDTO response = UsuarioClient.cadastrarUsuario(Utils.converterParaJson(user),true)
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_BAD_REQUEST).extract().as(ResponseErrorBadDTO.class);
        Assert.assertEquals(response.getStatus().intValue(), HttpStatus.SC_BAD_REQUEST);
    }
}
