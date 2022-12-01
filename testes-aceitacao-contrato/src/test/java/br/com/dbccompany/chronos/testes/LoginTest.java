package br.com.dbccompany.chronos.testes;

import br.com.dbccompany.chronos.client.LoginClient;
import br.com.dbccompany.chronos.data.factory.LoginDataFactory;
import br.com.dbccompany.chronos.dto.ResponseErrorBadDTO;
import br.com.dbccompany.chronos.model.Login;
import br.com.dbccompany.chronos.utils.Utils;
import io.qameta.allure.Description;
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
    @Description("Deve falhar fazer login sem dados")
    public void deveFalharFazerLoginComEmailFormatoInvalido() {
        Login login = LoginDataFactory.loginEmailFormatoInvalido();
        ResponseErrorBadDTO response = LoginClient.fazerLogin(Utils.converterParaJson(login))
            .then()
            .log().all()
            .statusCode(HttpStatus.SC_BAD_REQUEST)
            .extract().as(ResponseErrorBadDTO.class);
        assertAll("response",
                () -> Assert.assertEquals(response.getStatus().intValue(), HttpStatus.SC_BAD_REQUEST),
                () -> Assert.assertEquals(1, response.getErrors().length),
                () -> Assert.assertTrue(Arrays.stream(response.getErrors()).anyMatch(item -> item.contains("email: must be a well-formed email address")))
        );
    }

    @Test
    @Tag("todos")
    @Tag("login")
    @Description("Deve falhar fazer login com email valido senha invalida")
    public void deveFalharFazerLoginComEmailValidoSenhaInvalida() {
        Login login = LoginDataFactory.loginEmailValidoSenhaInvalida();
        Response response = LoginClient.fazerLogin(Utils.converterParaJson(login))
                .then()
                .log().all()
                .extract().response();
        Assert.assertEquals(response.statusCode(), HttpStatus.SC_FORBIDDEN);
    }

    @Test
    @Tag("todos")
    @Tag("login")
    @Description("Deve falhar fazer login com dados inválidos")
    public void deveFalharFazerLoginComDadosInvalidos() {
        Login login = LoginDataFactory.loginInexistente();
        Response response = LoginClient.fazerLogin(Utils.converterParaJson(login))
            .then()
            .log().all()
            .extract().response();
        Assert.assertEquals(response.statusCode(), HttpStatus.SC_FORBIDDEN);
    }

    @Test
    @Tag("todos")
    @Tag("login")
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
                () -> Assert.assertEquals(1, response.getErrors().length),
                () -> Assert.assertTrue(Arrays.stream(response.getErrors()).anyMatch(item -> item.contains("senha: must not be null")))
        );
    }

    @Test
    @Tag("todos")
    @Tag("login")
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
                () -> Assert.assertEquals(1, response.getErrors().length),
                () -> Assert.assertTrue(Arrays.stream(response.getErrors()).anyMatch(item -> item.contains("email: must not be null")))
        );
    }

    @Test
    @Tag("todos")
    @Tag("login")
    @Description("Deve fazer login com sucesso")
    public void deveFazerLoginComSucesso() {
        Login login = LoginDataFactory.loginValido();
        String response = LoginClient.fazerLogin(Utils.converterParaJson(login))
            .then()
            .log().all()
            .statusCode(HttpStatus.SC_OK).extract().asString();
        Assert.assertNotNull(response);
        Assert.assertFalse(response.isEmpty());
    }

}