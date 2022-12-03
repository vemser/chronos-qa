package br.com.dbccompany.chronos.pages;

import org.openqa.selenium.By;

public class CadastrarEdicaoPage extends BasePage {
    public static final By inputNomeEdicao =
            By.id("nome");
    public static final By inputDataInicio =
            By.id("dataInicial");
    public static final By inputDataFim =
            By.id("dataFinal");
    public static final By btnSubmit =
            By.cssSelector("[type='submit']");

    public static final By erroDataInicio =
            By.id("erro-data-inicial");

    public static final By erroDataFim =
            By.id("erro-data-final");
    public static final By erroNomeEdicao =
            By.id("erro-nome");
    public static void enviarNomeEdicao(String nomeEdicao){
        sendKeys(inputNomeEdicao, nomeEdicao);
    }
    public static void enviarDataInicio(String dataInicio){
        sendKeys(inputDataInicio, dataInicio);
    }
    public static void enviarDataFim(String dataFim){
        sendKeys(inputDataFim, dataFim);
    }
    public static void clicarBotaoSubmit(){
        scrollBy("250");
        click(btnSubmit);
    }

    public static void validarErroNomeEdicao() {
        getText(erroNomeEdicao).contains("nome");
    }
    public static void validarErroDataInicio() {
        checkElementTextContains(erroDataInicio, "data inicial");
    }

    public static void validarErroDataFim(){
        checkElementTextContains(erroDataFim, "data final");
    }
}
