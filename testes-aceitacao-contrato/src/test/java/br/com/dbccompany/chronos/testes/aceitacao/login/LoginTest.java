package br.com.dbccompany.chronos.testes.aceitacao.login;

import br.com.dbccompany.chronos.client.LoginClient;
import br.com.dbccompany.chronos.data.factory.LoginDataFactory;
import br.com.dbccompany.chronos.dto.ResponseErrorBadDTO;
import br.com.dbccompany.chronos.model.Login;
import br.com.dbccompany.chronos.testes.BaseTest;
import br.com.dbccompany.chronos.utils.Utils;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertAll;

public class LoginTest extends BaseTest {

    @Test
    @Tag("todos")
    @Tag("login")
    @Owner("Kevin Aryel")
    @Epic("Aceitação")
    @Feature("Login")
    @Story("Fazer Login")
    @Description("Deve fazer login com email com sucesso")
    public void deveFazerLoginComEmailComSucesso() {
        Login login = LoginDataFactory.loginValidoComEmail();
        String response = LoginClient.fazerLogin(Utils.converterParaJson(login))
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_OK).extract().asString();
        Assert.assertNotNull(response);
        Assert.assertFalse(response.isEmpty());
    }
    @Test
    @Tag("todos")
    @Tag("login")
    @Owner("Kevin Aryel")
    @Epic("Aceitação")
    @Feature("Login")
    @Story("Fazer Login")
    @Description("Deve fazer login com username com sucesso")
    public void deveFazerLoginComUsernameComSucesso() {
        Login login = LoginDataFactory.loginValidoComUsername();
        String response = LoginClient.fazerLogin(Utils.converterParaJson(login))
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_OK).extract().asString();
        Assert.assertNotNull(response);
        Assert.assertFalse(response.isEmpty());
    }
    @Test
    @Tag("todos")
    @Tag("login")
    @Owner("Kevin Aryel")
    @Epic("Aceitação")
    @Feature("Login")
    @Story("Fazer Login")
    @Description("Deve retornar erro ao fazer login sem dados")
    public void deveFalharFazerLoginComEmailFormatoInvalido() {
        Login login = LoginDataFactory.loginEmailFormatoInvalido();
        ResponseErrorBadDTO response = LoginClient.fazerLogin(Utils.converterParaJson(login))
            .then()
            .log().all()
            .statusCode(HttpStatus.SC_BAD_REQUEST)
            .extract().as(ResponseErrorBadDTO.class);
        assertAll("response",
                () -> Assert.assertEquals(response.getStatus().intValue(), HttpStatus.SC_BAD_REQUEST),
                () -> Assert.assertEquals(1, response.getErrors().length)
        );
    }

    @Test
    @Tag("todos")
    @Tag("login")
    @Owner("Kevin Aryel")
    @Epic("Aceitação")
    @Feature("Login")
    @Story("Fazer Login")
    @Description("Deve retornar erro ao fazer login com email valido e senha invalida")
    public void deveFalharFazerLoginComEmailValidoSenhaInvalida() {
        Login login = LoginDataFactory.loginEmailValidoSenhaInvalida();
        Response response = LoginClient.fazerLogin(Utils.converterParaJson(login))
                .then()
                .log().all()
                .extract().response();
        Assert.assertEquals(response.statusCode(), HttpStatus.SC_BAD_REQUEST);
    }

    @Test
    @Tag("todos")
    @Tag("login")
    @Owner("Kevin Aryel")
    @Epic("Aceitação")
    @Feature("Login")
    @Story("Fazer Login")
    @Description("Deve falhar fazer login com dados inválidos")
    public void deveFalharFazerLoginComDadosInvalidos() {
        Login login = LoginDataFactory.loginInexistente();
        Response response = LoginClient.fazerLogin(Utils.converterParaJson(login))
            .then()
            .log().all()
            .extract().response();
        Assert.assertEquals(response.statusCode(), HttpStatus.SC_BAD_REQUEST);
    }

    @Test
    @Tag("todos")
    @Tag("login")
    @Owner("Kevin Aryel")
    @Epic("Aceitação")
    @Feature("Login")
    @Story("Fazer Login")
    @Description("Deve falhar fazer login sem preencher o campo senha")
    public void deveFalharFazerLoginSemSenha() {
        Login login = LoginDataFactory.loginSemSenha();
        ResponseErrorBadDTO response =
        LoginClient.fazerLogin(Utils.converterParaJson(login))
            .then()
            .log().all()
            .statusCode(HttpStatus.SC_BAD_REQUEST)
            .extract().as(ResponseErrorBadDTO.class);
        assertAll("response",
                () -> Assert.assertEquals(response.getStatus().intValue(), HttpStatus.SC_BAD_REQUEST),
                () -> Assert.assertEquals(1, response.getErrors().length)
        );
    }

    @Test
    @Tag("todos")
    @Tag("login")
    @Owner("Kevin Aryel")
    @Epic("Aceitação")
    @Feature("Login")
    @Story("Fazer Login")
    @Description("Deve falhar fazer login sem preencher o campo email")
    public void deveFalharFazerLoginSemEmail() {
        Login login = LoginDataFactory.loginSemEmail();
        ResponseErrorBadDTO response = LoginClient.fazerLogin(Utils.converterParaJson(login))
            .then()
            .log().all()
            .statusCode(HttpStatus.SC_BAD_REQUEST)
            .extract().as(ResponseErrorBadDTO.class);
        assertAll("response",
                () -> Assert.assertEquals(response.getStatus().intValue(), HttpStatus.SC_BAD_REQUEST),
                () -> Assert.assertEquals(1, response.getErrors().length)
        );
    }

}