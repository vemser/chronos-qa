package br.com.dbccompany.chronos.pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {
    public static final By campoLogin =
            By.id("input-login-email");
    public static final By campoSenha =
            By.id("senha");
    public static final By botaoEntrar =
            By.id("button-login");
    public static final  By spanErroLogin =
            By.id("login-error-email");
    public static final  By spanErroSenha =
            By.id("login-error-senha");
    public static void preencherLogin(String login){
        sendKeys(campoLogin, login);
    }
    public static void preencherSenha(String senha){
        sendKeys(campoSenha, senha);
    }
    public static void clicarEntrar(){
        click(botaoEntrar);
    }

    public static boolean validarMensagemErroLogin() {
        return checkElementDisplayStatus(spanErroLogin);
    }
    public static boolean validarMensagemErroSenha() {
        return checkElementDisplayStatus(spanErroSenha);
    }
}
