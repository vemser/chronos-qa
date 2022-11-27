package br.com.dbccompany.chronos.testes.aceitacao.steps;

import br.com.dbccompany.chronos.testes.aceitacao.pages.LoginPage;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static br.com.dbccompany.chronos.utils.Utils.faker;

public class TesteLoginSteps {
    @Test
    @Tag("todos")
    @Tag("login")
    @Tag("front")
    @Description("Deve falhar fazer login sem preencher o campo email")
    public void deveFalharFazerLoginSemEmail() {
        LoginPage.preencherSenha(faker.internet().password(8,15,true,true,true));
        LoginPage.clicarEntrar();
    }

    @Test
    @Tag("todos")
    @Tag("login")
    @Tag("front")
    @Description("Deve falhar fazer login sem preencher o campo senha")
    public void deveFalharFazerLoginSemSenha() {
        LoginPage.preencherEmail(faker.internet().emailAddress());
        LoginPage.clicarEntrar();
    }

    @Test
    @Tag("todos")
    @Tag("login")
    @Tag("front")
    @Description("Deve falhar fazer login com dados inválidos")
    public void deveFalharFazerLoginComDadosInvalidos() {
        LoginPage.preencherEmail(faker.internet().emailAddress());
        LoginPage.preencherSenha(faker.internet().password(8,15,true,true,true));
        LoginPage.clicarEntrar();
    }

    @Test
    @Tag("todos")
    @Tag("login")
    @Tag("front")
    @Description("Deve falhar fazer login sem dados")
    public void deveFalharFazerLoginComDadosVazios() {
        LoginPage.clicarEntrar();
    }

    @Test
    @Tag("todos")
    @Tag("login")
    @Tag("front")
    @Description("Deve fazer login com sucesso")
    public void deveFazerLoginComSucesso() {
        LoginPage.preencherEmail("");
        LoginPage.preencherSenha("");
        LoginPage.clicarEntrar();
    }

    @Test
    @Tag("todos")
    @Tag("login")
    @Tag("front")
    @Description("Deve fazer login com email inválido")
    public void deveFazerLoginComEmailInvalido() {
        LoginPage.preencherEmail("emailinvalido");
        LoginPage.preencherSenha(faker.internet().password(8,15,true,true,true));
        LoginPage.clicarEntrar();
    }
}
