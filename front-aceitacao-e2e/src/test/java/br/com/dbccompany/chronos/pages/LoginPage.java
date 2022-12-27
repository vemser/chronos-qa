package br.com.dbccompany.chronos.pages;

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
    public static void preencherEmail(String email){
        sendKeys(campoEmail, email);
    }
    public static void preencherSenha(String senha){
        sendKeys(campoSenha, senha);
    }
    public static void clicarEntrar(){
        click(botaoEntrar);
    }

    public static boolean validarMensagemErroEmail() {
        return checkElementDisplayStatus(spanErroEmail);
    }
    public static boolean validarMensagemErroSenha() {
        return checkElementDisplayStatus(spanErroSenha);
    }
}
