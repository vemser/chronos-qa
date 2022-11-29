package br.com.dbccompany.chronos.testes.frontend.pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {
    public static final By campoEmail =
            By.id("input-login-email");
    public static final By campoSenha =
            By.id("input-login-senha");
    public static final By botaoEntrar =
            By.id("button-login");
    public static final  By spanErroEmail =
            By.id("login-error-email");
    public static final  By spanErroSenha =
            By.id("login-error-senha");
    public static final By botaoEsqueciSenha =
            By.id("#login-btn-esqueci-senha");

    public static void preencherEmail(String email){
        sendKeys(campoEmail, email);
    }
    public static void preencherSenha(String senha){
        sendKeys(campoSenha, senha);
    }
    public static void clicarEntrar(){
        click(botaoEntrar);
    }
    public static void clicarEsqueciSenha(){
        click(botaoEsqueciSenha);
    }

    public static boolean validarMensagemErroEmail(String text) {
        return getText(spanErroEmail).contains(text);
    }
    public static boolean validarMensagemErroSenha(String text) {
        return getText(spanErroSenha).contains(text);
    }
}
