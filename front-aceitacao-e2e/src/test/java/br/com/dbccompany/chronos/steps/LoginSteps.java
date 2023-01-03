package br.com.dbccompany.chronos.steps;

import br.com.dbccompany.chronos.pages.LoginPage;
import br.com.dbccompany.chronos.utils.ConfigManipulation;
import br.com.dbccompany.chronos.utils.Utils;
import org.junit.Assert;
import cucumber.api.java.pt.*;

public class LoginSteps {

    @Dado("que estou na pagina de login")
    public void irAoLogin(){
    }
    @Dado("que esteja logado")
    public void fazerLogin(){
        preencherLoginUsernameValido();
        preencherSenhaValidaLogin();
        clicarEmFazerLogin();
    }
    @E("preencho campo login na pagina de login com email dbc valido")
    public void preencherLoginEmailValido(){
        LoginPage.preencherLogin(ConfigManipulation.getProp().getProperty("emailQa"));
    }
    @E("preencho campo login na pagina de login com email dbc inexistente")
    public void preencherLoginEmailInexistente(){
        String email = "teste."+ Utils.faker.name().firstName().toLowerCase()+"@dbccompany.com.br";
        LoginPage.preencherLogin(email);
    }
    @E ("preencho campo login na pagina de login com username valido")
    public void preencherLoginUsernameValido(){
        LoginPage.preencherLogin(ConfigManipulation.getProp().getProperty("userQa"));
    }
    @E("preencho campo senha na pagina de login com senha valida")
    public void preencherSenhaValidaLogin(){
        LoginPage.preencherSenha(ConfigManipulation.getProp().getProperty("senhaQa"));
    }
    @E("preencho campo login na pagina de login com email nao pertencente a dbc")
    public void preencherLoginInvalido(){
        LoginPage.preencherLogin(Utils.faker.internet().emailAddress());
    }
    @E("preencho campo senha na pagina de login com senha invalida")
     public void preencherSenhaInvalidaLogin(){
        LoginPage.preencherSenha(Utils.faker.internet().password(8,15,true,true,true));
    }
    @Quando ("eu clico no botao de fazer login")
    public void clicarEmFazerLogin(){
        LoginPage.clicarEntrar();
    }
    @Entao("deve redirecionar para aplicacao")
    public void checarRedirecionamentoLogin() throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertFalse(LoginPage.getUrl().equals("http://vemser-dbc.dbccompany.com.br:39000/vemser/chronos-front"));
    }
    @Entao("deve exibir mensagem de erro de autorizacao")
    public void checarErroAuthLoginInvalido() throws InterruptedException{
        Thread.sleep(2000);
        Assert.assertTrue(LoginPage.validarToast("Usuário ou senha inválida"));
    }
    @Entao("deve exibir mensagem de erro de login")
    public void checarErroLoginLogin(){
        Assert.assertTrue(LoginPage.validarMensagemErroLogin());
    }
    @Entao("deve exibir mensagem de erro de senha")
    public void checarErroLoginSenha(){
        Assert.assertTrue(LoginPage.validarMensagemErroSenha());
    }
}
