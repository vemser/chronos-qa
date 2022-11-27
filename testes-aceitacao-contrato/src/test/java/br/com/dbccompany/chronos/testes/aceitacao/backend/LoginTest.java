package br.com.dbccompany.chronos.testes.aceitacao.backend;

import br.com.dbccompany.chronos.client.LoginClient;
import br.com.dbccompany.chronos.data.factory.LoginDataFactory;
import br.com.dbccompany.chronos.model.Login;
import br.com.dbccompany.chronos.utils.Utils;
import io.qameta.allure.Description;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class LoginTest {

    @Test
    @Tag("todos")
    @Tag("login")
    @Description("Deve falhar fazer login sem dados")
    public void deveFalharFazerLoginComDadosVazios() {
        LoginClient.fazerLogin(Utils.converterParaJson(new Object()))
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_BAD_REQUEST);
    }

    @Test
    @Tag("todos")
    @Tag("login")
    @Description("Deve falhar fazer login com dados inválidos")
    public void deveFalharFazerLoginComDadosInvalidos() {
        Login login = LoginDataFactory.loginInvalidoCompleto();
        LoginClient.fazerLogin(Utils.converterParaJson(login))
            .then()
            .log().all()
            .statusCode(HttpStatus.SC_BAD_REQUEST);
    }

    @Test
    @Tag("todos")
    @Tag("login")
    @Description("Deve falhar fazer login sem preencher o campo senha")
    public void deveFalharFazerLoginSemSenha() {
        Login login = LoginDataFactory.loginSemSenha();
        LoginClient.fazerLogin(Utils.converterParaJson(login))
            .then()
            .log().all()
            .statusCode(HttpStatus.SC_BAD_REQUEST);
    }

    @Test
    @Tag("todos")
    @Tag("login")
    @Description("Deve falhar fazer login sem preencher o campo email")
    public void deveFalharFazerLoginSemEmail() {
        Login login = LoginDataFactory.loginSemEmail();
        LoginClient.fazerLogin(Utils.converterParaJson(login))
            .then()
            .log().all()
            .statusCode(HttpStatus.SC_BAD_REQUEST);
    }

    @Test
    @Tag("todos")
    @Tag("login")
    @Description("Deve fazer login com sucesso")
    public void deveFazerLoginComSucesso() {
        Login login = LoginDataFactory.loginValido();
        LoginClient.fazerLogin(Utils.converterParaJson(login))
            .then()
            .log().all()
            .statusCode(HttpStatus.SC_OK);
    }

}
