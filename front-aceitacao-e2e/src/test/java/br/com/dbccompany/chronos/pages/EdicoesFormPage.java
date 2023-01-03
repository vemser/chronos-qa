package br.com.dbccompany.chronos.pages;

import org.openqa.selenium.By;

public class EdicoesFormPage extends BasePage {
    public static final By inputNomeEdicao =
            By.id("nome");
    public static final By inputDataInicio =
            By.id("dataInicial");
    public static final By btnSubmit =
            By.cssSelector("[type='submit']");

    public static final By erroDataInicio =
            By.id("erro-data-inicial");

    public static final By erroNomeEdicao =
            By.id("erro-nome");
    public static void enviarNomeEdicao(String nomeEdicao){
        sendKeys(inputNomeEdicao, nomeEdicao);
    }
    public static void enviarDataInicio(String dataInicio){
        sendKeys(inputDataInicio, dataInicio);
    }
    public static void clicarBotaoSubmit(){
        click(btnSubmit);
    }
    public static void limparNomeEdicao(){
        clearElement(inputNomeEdicao);
    }
    public static void limparDataInicialEdicao(){
        clearElement(inputDataInicio);
    }
    public static void validarErroNomeEdicao() {
        checkElementDisplayStatus(erroNomeEdicao);
    }
    public static void validarErroDataInicio() {
        checkElementDisplayStatus(erroDataInicio);
    }

}
