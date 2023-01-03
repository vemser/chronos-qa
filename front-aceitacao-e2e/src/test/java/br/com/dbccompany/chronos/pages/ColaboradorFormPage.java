package br.com.dbccompany.chronos.pages;

import org.openqa.selenium.By;

public class ColaboradorFormPage extends BasePage {
    private static final By inputLogin =
            By.id("login");
    private static final By checkboxAdmin =
            By.id("Administrador");
    private static final By checkboxGestao =
            By.id("GestaoDePessoas");
    private static final By checkboxInstrutor =
            By.id("Instrutor");
    private static final By checkboxGestor =
            By.id("Gestor");
    private static final By btnEnviar =
            By.cssSelector("[type=submit]");
    private static final By spanErroLogin =
            By.id("colab-error-login");
    public static void preencherLogin(String login){
        sendKeys(inputLogin, login);
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
    public static void clicarCheckboxGestor(){
        click(checkboxGestor);
    }
    public static void clicarBotaoEnviar(){
        click(btnEnviar);
    }
    public static void clearInputLogin(){
        clearElement(inputLogin);
    }
    public static void checarErroLogin(){
        checkElementDisplayStatus(spanErroLogin);
    }
    public static boolean checarCheckboxAdmin(){
        return checkElementIsEnable(checkboxAdmin);
    }
    public static  boolean checarCheckboxGestao(){
        return checkElementIsEnable(checkboxGestao);
    }
    public static boolean checarCheckboxInstrutor(){
        return checkElementIsEnable(checkboxInstrutor);
    }

}
