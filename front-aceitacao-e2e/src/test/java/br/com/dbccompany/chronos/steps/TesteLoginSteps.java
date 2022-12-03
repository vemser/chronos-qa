package br.com.dbccompany.chronos.steps;

import br.com.dbccompany.chronos.pages.LoginPage;
import br.com.dbccompany.chronos.utils.ConfigManipulation;
import io.qameta.allure.Description;
import org.junit.Assert;
import org.junit.Test;
import static br.com.dbccompany.chronos.utils.Utils.faker;

public class TesteLoginSteps extends BaseSteps {
    @Test
    @Description("Deve falhar fazer login sem preencher o campo email")
    public void deveFalharFazerLoginSemEmail() {
        LoginPage.preencherSenha(faker.internet().password(8,15,true,true,true));
        LoginPage.clicarEntrar();
        Assert.assertTrue(LoginPage.validarMensagemErroEmail("Por favor, digite seu Email!"));
    }

    @Test
    @Description("Deve falhar fazer login sem preencher o campo senha")
    public void deveFalharFazerLoginSemSenha() {
        LoginPage.preencherEmail(faker.internet().emailAddress());
        LoginPage.clicarEntrar();
        Assert.assertTrue(LoginPage.validarMensagemErroSenha("Por favor, digite sua senha!"));
    }

    @Test
    @Description("Deve falhar fazer login com dados inválidos")
    public void deveFalharFazerLoginComDadosInvalidos() {
        LoginPage.preencherEmail(faker.internet().emailAddress());
        LoginPage.preencherSenha(faker.internet().password(8,15,true,true,true));
        LoginPage.clicarEntrar();
    }
    @Test
    @Description("Deve fazer login com senha pequena inválido")
    public void deveFazerLoginComSenhaFormatoInvalido() {
        LoginPage.preencherEmail(ConfigManipulation.getProp().getProperty("emailAdm"));
        LoginPage.preencherSenha(faker.internet().password(2,5,true,true,true));
        LoginPage.clicarEntrar();
        Assert.assertTrue(LoginPage.validarMensagemErroSenha("A senha deve ter no mínimo 6 caracteres"));
    }
    @Test
    @Description("Deve falhar fazer login sem dados")
    public void deveFalharFazerLoginComDadosVazios() {
        LoginPage.clicarEntrar();
        Assert.assertTrue(LoginPage.validarMensagemErroEmail("Por favor, digite seu Email!"));
        Assert.assertTrue(LoginPage.validarMensagemErroSenha("Por favor, digite sua senha!"));
    }

    @Test
    @Description("Deve fazer login como admin com sucesso")
    public void deveFazerLoginComSucesso() throws InterruptedException {
        LoginPage.preencherEmail(ConfigManipulation.getProp().getProperty("emailAdm"));
        LoginPage.preencherSenha(ConfigManipulation.getProp().getProperty("senhaAdm"));
        LoginPage.clicarEntrar();
        Thread.sleep(2000);
        Assert.assertTrue(LoginPage.validarUrlAdmin());
    }
    @Test
    @Description("Deve fazer login como instrutor com sucesso")
    public void deveFazerLoginComoInstrutorComSucesso() throws InterruptedException {
        LoginPage.preencherEmail(ConfigManipulation.getProp().getProperty("emailInstrutor"));
        LoginPage.preencherSenha(ConfigManipulation.getProp().getProperty("senhaInstrutor"));
        LoginPage.clicarEntrar();
        Thread.sleep(2000);
        Assert.assertTrue(LoginPage.validarUrlInstrutor());
    }
    @Test
    @Description("Deve fazer login como gestor com sucesso")
    public void deveFazerLoginComoGestorComSucesso() throws InterruptedException {
        LoginPage.preencherEmail(ConfigManipulation.getProp().getProperty("emailGestao"));
        LoginPage.preencherSenha(ConfigManipulation.getProp().getProperty("senhaGestao"));
        LoginPage.clicarEntrar();
        Thread.sleep(2000);
        Assert.assertTrue(LoginPage.validarUrlGestao());
    }

    @Test
    @Description("Deve fazer login com email inválido")
    public void deveFazerLoginComEmailInvalido() throws InterruptedException {
        LoginPage.preencherEmail("emailinvalido");
        LoginPage.preencherSenha(faker.internet().password(8,15,true,true,true));
        LoginPage.clicarEntrar();
        Thread.sleep(2000);
        Assert.assertTrue(LoginPage.validarMensagemErroEmail("Por favor, digite um email válido"));
    }


}
