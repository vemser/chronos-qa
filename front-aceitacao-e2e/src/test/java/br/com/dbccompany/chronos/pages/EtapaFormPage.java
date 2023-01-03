package br.com.dbccompany.chronos.pages;

import org.openqa.selenium.By;

public class EtapaFormPage extends BasePage {
    private static final By inputNome =
            By.id("nome");
    private static final By inputOrdemExecucao =
            By.id("ordemExecucao");
    private static final By btnSubmitEtapa =
            By.cssSelector("button[type='submit']");
    private static final By spanErroNome =
            By.id("erro-nome");
    private static final By spanErroOrdemExecucao =
            By.id("erro-ordem");

    public static void clicarBotaoSubmitEtapa(){
        click(btnSubmitEtapa);
    }
    public static void preencherNome(String nome){
        sendKeys(inputNome, nome);
    }
    public static void preencherOrdemExecucao(String ordemExecucao){
        sendKeys(inputOrdemExecucao, ordemExecucao);
    }
    public static boolean validarErroNome(){
        return checkElementDisplayStatus(spanErroNome);
    }
    public static boolean validarErroOrdem() {return checkElementDisplayStatus(spanErroOrdemExecucao);}
}
