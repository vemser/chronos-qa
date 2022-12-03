package br.com.dbccompany.chronos.pages;

import org.openqa.selenium.By;

public class AdminPage extends BasePage {
    public static final By botaoColaboradores =
            By.cssSelector("[href='/vemser/chronos-front/admin/colaboradores']> button");

    public static void clicarBotaoColaboradores(){
        click(botaoColaboradores);
    }
}
