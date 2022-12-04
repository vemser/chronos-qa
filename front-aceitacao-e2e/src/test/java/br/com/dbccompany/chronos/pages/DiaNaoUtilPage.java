package br.com.dbccompany.chronos.pages;

import org.openqa.selenium.By;

public class DiaNaoUtilPage extends BasePage {
    private static final By botaoAdicionar = By.id("addButton");
    private static final By botaoExcluirUltimo =
            By.cssSelector("tbody>tr:last-child>td:last-child");
    private static final By botaoEditarUltimo =
            By.cssSelector("tbody>tr:last-child>td:nth-child(6)");
    public static void clicarBotaoAdicionarDiaNaoUtil(){
        click(botaoAdicionar);
    }
    public static void clicarBotaoExcluirUltimoDiaNaoUtil() throws InterruptedException {
        if (checkElementExist(btnUltimaPagina)){
            click(btnUltimaPagina);
            Thread.sleep(1000);
        }
        click(botaoExcluirUltimo);
        Thread.sleep(1000);
    }
    public static void clicarBotaoEditarUltimoDiaNaoUtil() throws InterruptedException {
        if (checkElementExist(btnUltimaPagina)){
            click(btnUltimaPagina);
            Thread.sleep(1000);
        }
        click(botaoEditarUltimo);
        Thread.sleep(1000);
    }

}
