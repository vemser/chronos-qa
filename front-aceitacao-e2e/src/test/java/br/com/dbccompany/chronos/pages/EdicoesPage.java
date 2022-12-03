package br.com.dbccompany.chronos.pages;

import org.openqa.selenium.By;

public class EdicoesPage extends BasePage {
    private static final By btnAdicionarEdicoes =
            By.cssSelector("[href='/vemser/chronos-front/gestao/cadastrar-edicao']");

    private static final By nomeUltimaEdicao =
            By.cssSelector("tbody > tr:last-child > th");

    private static final By btnExcluirUltima =
            By.cssSelector("tbody > tr:last-child >td:last-child");

    private static final By btnClonarEdicaoUltima =
            By.cssSelector("tbody > tr:last-child >td:nth-child(5)");
    private static final By btnEditarUltima =
            By.cssSelector("tbody > tr:last-child >td:nth-child(4)");
    private static final By btnStatusUltima =
            By.cssSelector("tbody > tr:last-child >td:nth-child(3)");

    public static void clicarBotaoCriarEdicao(){
        click(btnAdicionarEdicoes);
    }
    public static void clicarBotaoStatusUltima(){
        click(btnStatusUltima);
    }
    public static void clicarBotaoEditarUltima(){
        click(btnEditarUltima);
    }

    public static boolean validarToastSucesso() {
        return getText(toastMessage).contains("sucesso");
    }
    public static boolean validarToastErro() {
        return getText(toastMessage).contains("erro");
    }

    public static void clicarBotaoExcluirUltima() {
        scrollBy("200");
        click(btnExcluirUltima);
    }
    public static String nomeUltimaEdicao() {
        return getText(nomeUltimaEdicao);
    }

    public static boolean validarNomeUltimaEdicao(String nome) {
        return getText(nomeUltimaEdicao).contains(nome);
    }
    public static void clicarBotaoClonarUltima() {
        scrollBy("200");
        click(btnClonarEdicaoUltima);
    }
}
