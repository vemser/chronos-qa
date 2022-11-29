package br.com.dbccompany.chronos.testes.frontend.steps;

import br.com.dbccompany.chronos.testes.frontend.pages.LoginPage;
import br.com.dbccompany.chronos.utils.ConfigManipulation;
import io.qameta.allure.Description;
import org.junit.Assert;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static br.com.dbccompany.chronos.utils.Utils.faker;
import static org.junit.jupiter.api.Assertions.assertAll;

public class TesteLoginSteps {
    @Test
    @Tag("todos")
    @Tag("login")
    @Tag("front")
    @Description("Deve falhar fazer login sem preencher o campo email")
    public void deveFalharFazerLoginSemEmail() {
        LoginPage.preencherSenha(faker.internet().password(8,15,true,true,true));
        LoginPage.clicarEntrar();
        Assert.assertTrue(LoginPage.validarMensagemErroEmail("Por favor, digite seu Email!"));
    }

    @Test
    @Tag("todos")
    @Tag("login")
    @Tag("front")
    @Description("Deve falhar fazer login sem preencher o campo senha")
    public void deveFalharFazerLoginSemSenha() {
        LoginPage.preencherEmail(faker.internet().emailAddress());
        LoginPage.clicarEntrar();
        Assert.assertTrue(LoginPage.validarMensagemErroSenha("Por favor, digite sua senha!"));
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
        assertAll("Login",
                () -> Assert.assertTrue(LoginPage.validarMensagemErroEmail("Por favor, digite seu Email!")),
                () -> Assert.assertTrue(LoginPage.validarMensagemErroSenha("Por favor, digite sua senha!"))
        );
    }

    @Test
    @Tag("todos")
    @Tag("login")
    @Tag("front")
    @Description("Deve fazer login com sucesso")
    public void deveFazerLoginComSucesso() {
        LoginPage.preencherEmail(ConfigManipulation.getProp().getProperty("email"));
        LoginPage.preencherSenha(ConfigManipulation.getProp().getProperty("senha"));
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
        Assert.assertTrue(LoginPage.validarMensagemErroEmail("Por favor, digite um email válido"));
    }

    @Test
    @Tag("todos")
    @Tag("login")
    @Tag("front")
    @Description("Deve fazer login com senha pequena inválido")
    public void deveFazerLoginComSenhaFormatoInvalido() {
        LoginPage.preencherEmail(ConfigManipulation.getProp().getProperty("email"));
        LoginPage.preencherSenha(faker.internet().password(2,5,true,true,true));
        LoginPage.clicarEntrar();
        Assert.assertTrue(LoginPage.validarMensagemErroEmail("A senha deve ter no mínimo 6 caracteres"));
    }
}
