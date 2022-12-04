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
    private static final By btnDetalhesUltimo =
            By.cssSelector("tbody > tr:last-child >th:nth-child(2)");
    public static void clicarBotaoCriarEdicao(){
        click(btnAdicionarEdicoes);
    }
    public static void clicarBotaoStatusUltima() throws InterruptedException {
        if (checkElementExist(btnUltimaPagina)){
            click(btnUltimaPagina);
            Thread.sleep(1000);
        }
        click(btnStatusUltima);
    }
    public static void clicarBotaoEditarUltima() throws InterruptedException {
        if (checkElementExist(btnUltimaPagina)){
            click(btnUltimaPagina);
            Thread.sleep(1000);
        }
        click(btnEditarUltima);
    }
    public static void clicarBotaoExcluirUltima() throws InterruptedException {
        if (checkElementExist(btnUltimaPagina)){
            click(btnUltimaPagina);
            Thread.sleep(1000);
        }
        scrollBy("200");
        click(btnExcluirUltima);
        Thread.sleep(1000);
    }
    public static String nomeUltimaEdicao() throws InterruptedException {
        if (checkElementExist(btnUltimaPagina)){
            click(btnUltimaPagina);
            Thread.sleep(1000);
        }
        return getText(nomeUltimaEdicao);
    }

    public static boolean validarNomeUltimaEdicao(String nome) throws InterruptedException {
        if (checkElementExist(btnUltimaPagina)){
            click(btnUltimaPagina);
            Thread.sleep(1000);
        }
        return getText(nomeUltimaEdicao).contains(nome);
    }
    public static void clicarBotaoClonarUltima() throws InterruptedException {
        if (checkElementExist(btnUltimaPagina)){
            click(btnUltimaPagina);
            Thread.sleep(1000);
        }
        scrollBy("200");
        click(btnClonarEdicaoUltima);
    }
    public static void clicarBotaoDetalhesUltima() throws InterruptedException {
        if (checkElementExist(btnUltimaPagina)){
            click(btnUltimaPagina);
            Thread.sleep(1000);
        }
        click(btnDetalhesUltimo);
    }
}
