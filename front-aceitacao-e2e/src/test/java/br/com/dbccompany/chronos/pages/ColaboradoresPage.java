package br.com.dbccompany.chronos.pages;

import org.openqa.selenium.By;

public class ColaboradoresPage extends BasePage {
    private static final By btnAdicionarColaborador =
            By.cssSelector("[href='/vemser/chronos-front/admin/cadastrar']");
    private static final By btnStatusUltimo =
            By.cssSelector("tbody > tr:last-child >td:nth-child(4)");
    private static final By btnEditarUltimo =
            By.cssSelector("tbody > tr:last-child >td:nth-child(5)");
    private static final By btnExcluirUltimo =
            By.cssSelector("tbody > tr:last-child >td:nth-child(6)");
    public static void clicarBotaoCriarColaborador(){
        click(btnAdicionarColaborador);
    }
    public static void clicarBotaoStatusUltimo(){
        click(btnStatusUltimo);
    }
    public static void clicarBotaoEditarUltimo(){
        click(btnEditarUltimo);
    }
    public static void clicarBotaoExcluirUltimo() {
        click(btnExcluirUltimo);
    }
}
