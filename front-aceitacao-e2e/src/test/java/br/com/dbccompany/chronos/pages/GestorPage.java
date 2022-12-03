package br.com.dbccompany.chronos.pages;

import org.openqa.selenium.By;

public class GestorPage extends BasePage {

    public static final By botaoEdicoes =
            By.cssSelector("[href='/vemser/chronos-front/gestao/edicoes']> button");

    public static void clicarBotaoEdicoes(){
        click(botaoEdicoes);
    }

}
