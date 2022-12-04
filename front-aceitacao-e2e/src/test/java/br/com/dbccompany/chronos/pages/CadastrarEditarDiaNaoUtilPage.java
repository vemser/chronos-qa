package br.com.dbccompany.chronos.pages;

import org.openqa.selenium.By;

public class CadastrarEditarDiaNaoUtilPage extends BasePage {
    private static final By inputDescricao =
            By.id("descricao");
    private static final By inputDataInicial =
            By.id("dataInicial");
    private static final By inputDataFinal =
            By.id("dataFinal");
    private static final By checkBoxRepeticaoAnual =
            By.cssSelector("#repeticaoAnual > span > input");
    private static final By botaoSalvar =
            By.cssSelector("[type='submit']");
    private static final By erroDescricao =
            By.id("descricao-error");
    private static final By erroDataInicial =
            By.id("data-inicial-error");
    public static void enviarDescricao(String descricao){
        sendKeys(inputDescricao, descricao);
    }
    public static void enviarDataInicial(String dataInicial){
        sendKeys(inputDataInicial, dataInicial);
    }
    public static void enviarDataFinal(String dataFinal){
        sendKeys(inputDataFinal, dataFinal);
    }
    public static void clicarCheckBoxRepeticaoAnual(){
        click(checkBoxRepeticaoAnual);
    }
    public static void clicarBotaoSubmit(){
       click(botaoSalvar);
    }
    public static void validarErroDescricao(){
        checkElementTextContains(erroDescricao, "descrição");
    }
    public static void validarErroDataInicial(){
        checkElementTextContains(erroDataInicial, "data inicial");
    }

}
