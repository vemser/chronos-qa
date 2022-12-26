package br.com.dbccompany.chronos.testes.aceitacao.usuario;

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
    @Epic("Aceitação")
    @Feature("Usuário")
    @Story("Criar Usuário")
    @Description("Deve criar usuario utilizando email dbc com sucesso")
    public void deveCriarUsuarioComSucessoUtilizandoEmail(){
        User user = UserDataFactory.usuarioValidoComEmail();
        UsuarioDTO response = UsuarioClient.cadastrarUsuario(Utils.converterParaJson(user),true)
            .then()
                .log().all()
                .statusCode(HttpStatus.SC_OK).extract().as(UsuarioDTO.class)
            ;
        UsuarioClient.deletarUsuario(response.getIdUsuario().toString(),true);
    }
    @Test
    @Tag("todos")
    @Tag("usuario")
    @Owner("Kevin Aryel")
    @Epic("Aceitação")
    @Feature("Usuário")
    @Story("Criar Usuário")
    @Description("Deve criar usuario com mais de um cargo com sucesso")
    public void deveCriarUsuarioComCargoDuploComSucesso(){
        User user = UserDataFactory.usuarioValidoComCargoDuplo();
        UsuarioDTO response = UsuarioClient.cadastrarUsuario(Utils.converterParaJson(user),true)
            .then()
                .log().all()
                .statusCode(HttpStatus.SC_OK)
                .extract().as(UsuarioDTO.class)
            ;
        UsuarioClient.deletarUsuario(response.getIdUsuario().toString(),true);
    }

    @Test
    @Tag("todos")
    @Tag("usuario")
    @Owner("Kevin Aryel")
    @Epic("Aceitação")
    @Feature("Usuário")
    @Story("Criar Usuário")
    @Description("Deve criar usuario utilizando username com sucesso")
    public void deveCriarUsuarioComSucessoUtilizandoUsername(){
        User user = UserDataFactory.usuarioValidoComUsername();
        UsuarioDTO response = UsuarioClient.cadastrarUsuario(Utils.converterParaJson(user),true)
            .then()
                .log().all()
                .statusCode(HttpStatus.SC_OK).extract().as(UsuarioDTO.class)
            ;
        Assert.assertEquals(response.getLogin(), user.getLogin());
        UsuarioClient.deletarUsuario(response.getIdUsuario().toString(),true);
    }

    @Test
    @Tag("todos")
    @Tag("usuario")
    @Owner("Kevin Aryel")
    @Epic("Aceitação")
    @Feature("Usuário")
    @Story("Criar Usuário")
    @Description("Deve retornar erro ao tentar criar usuario sem login")
    public void deveFalharCriarUsuarioSemLogin(){
        User user = UserDataFactory.userSemLogin();
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
    @Epic("Aceitação")
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
    }

    @Test
    @Tag("todos")
    @Tag("usuario")
    @Owner("Kevin Aryel")
    @Epic("Aceitação")
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
    @Epic("Aceitação")
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
    @Epic("Aceitação")
    @Feature("Usuário")
    @Story("Criar Usuário")
    @Description("Deve retornar erro ao tentar criar usuario com email invalido")
    public void deveFalharCriarUsuarioEmailInvalido(){
        User user = UserDataFactory.userComLoginInvalido();
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
    @Epic("Aceitação")
    @Feature("Usuário")
    @Story("Criar Usuário")
    @Description("Deve retornar erro ao tentar criar usuario sem auth")
    public void deveFalharCriarUsuarioSemAuth() {
        User user = UserDataFactory.usuarioValidoComEmail();
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
    @Epic("Aceitação")
    @Feature("Usuário")
    @Story("Criar Usuário")
    @Description("Deve retornar erro ao tentar criar usuario com email duplicado")
    public void deveFalharCriarUsuarioEmailDuplicado(){
        User user = UserDataFactory.userComLoginDuplicado();
        ResponseErrorBadDTO response = UsuarioClient.cadastrarUsuario(Utils.converterParaJson(user),true)
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_BAD_REQUEST).extract().as(ResponseErrorBadDTO.class);
        Assert.assertEquals(response.getStatus().intValue(), HttpStatus.SC_BAD_REQUEST);
    }
}
