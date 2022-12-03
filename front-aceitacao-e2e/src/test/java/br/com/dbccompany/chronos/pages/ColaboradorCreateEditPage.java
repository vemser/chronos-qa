package br.com.dbccompany.chronos.pages;

import org.openqa.selenium.By;

public class ColaboradorCreateEditPage extends BasePage {
    private static final By inputNome =
            By.id("nome");
    private static final By inputEmail =
            By.cssSelector("[name=email]");
    private static final By checkboxAdmin =
            By.id("Administrador");
    private static final By checkboxGestao =
            By.id("GestaoDePessoas");
    private static final By checkboxInstrutor =
            By.id("Instrutor");
    private static final By btnEnviar =
            By.cssSelector("[type=submit]");
    private static final By spanErroNome =
            By.id("colab-error-nome");
    private static final By spanErroEmail =
            By.id("colab-error-email");
    public static void preencherNome(String nome){
        sendKeys(inputNome, nome);
    }
    public static void preencherEmail(String email){
        sendKeys(inputEmail, email);
    }
    public static void clicarCheckboxAdmin(){
        click(checkboxAdmin);
    }
    public static void clicarCheckboxGestao(){
        click(checkboxGestao);
    }
    public static void clicarCheckboxInstrutor(){
        click(checkboxInstrutor);
    }
    public static void clicarBotaoEnviar(){
        click(btnEnviar);
    }
    public static void checarErroEmail(String erro){
        checkElementTextContains(spanErroEmail, erro);
    }
    public static void checarErroNome(String erro){
        checkElementTextContains(spanErroNome, erro);
    }

}
