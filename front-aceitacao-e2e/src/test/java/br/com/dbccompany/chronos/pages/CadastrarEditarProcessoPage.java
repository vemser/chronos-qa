package br.com.dbccompany.chronos.pages;

import org.openqa.selenium.By;

public class CadastrarEditarProcessoPage extends BasePage {
    private static final By inputNome =
            By.id("nome");
    private static final By inputAreaEnvolvida =
            By.cssSelector("input[id^='react-select']");
    private static final By inputAreaEnvolvidaFirstOption =
            By.cssSelector("div[id^='react-select'][id$='listbox']>div:nth-child(1)");
    private static final By inputResponsavel =
            By.cssSelector("input[id^='react-select']");
    private static final By inputResponsavelFirstOption =
            By.cssSelector("div[id^='react-select'][id$='listbox']>div:nth-child(1)");
    private static final By inputDuracao =
            By.id("duracaoProcesso");
    private static final By inputDiasUteis =
            By.id("diasUteis");
    private static final By inputOrdem =
            By.id("ordemExecucao");
    private static final By btnSubmit =
            By.cssSelector("[type='submit']");
    public static void preencherNome(String nome) {
        sendKeys(inputNome,nome);
    }
    public static void preencherAreaEnvolvida(String areaEnvolvida) {
        sendKeys(inputAreaEnvolvida,areaEnvolvida);
        click(inputAreaEnvolvidaFirstOption);
        sendEscapeKey(inputAreaEnvolvida);
    }
    public static void selecionarOpcaoAreaEnvolvida() {
        click(inputAreaEnvolvida);
        click(inputAreaEnvolvidaFirstOption);
        sendEscapeKey(inputAreaEnvolvida);
    }
    public static void preencherResponsavel(String responsavel) {
        sendKeysLast(inputResponsavel,responsavel);
        clickLast(inputResponsavelFirstOption);
        sendEscapeKey(inputAreaEnvolvida);
    }
    public static void selecionarOpcaoResponsavel() {
        clickLast(inputResponsavel);
        clickLast(inputResponsavelFirstOption);
        sendEscapeKey(inputAreaEnvolvida);
    }
    public static void preencherDuracao(String duracao) {
        sendKeys(inputDuracao,duracao);
    }
    public static void preencherDiasUteis(String diasUteis) {
        sendKeys(inputDiasUteis,diasUteis);
    }
    public static void preencherOrdem(String ordem) {
        sendKeys(inputOrdem,ordem);
    }

    public static void clicarBotaoSubmit() {
        click(btnSubmit);
    }
}
