package br.com.dbccompany.chronos.testes.aceitacao.pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {
    public static final By campoEmail =
            By.id("#login-input-email");
    public static final By campoSenha =
            By.id("#login-input-senha");
    public static final By botaoEntrar =
            By.id("#login-btn-entrar");
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


}
