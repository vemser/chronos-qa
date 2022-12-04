package br.com.dbccompany.chronos.pages;

import org.openqa.selenium.By;

public class GestorPage extends BasePage {

    public static final By btnDetalhes =
            By.cssSelector("[aria-label='Exibir detalhes']");
    public static final By btnEditarPerfil =
            By.id("button-editar-perfil");
    public static final By botaoEdicoes =
            By.cssSelector("[href='/vemser/chronos-front/gestao/edicoes']> button");
    public static final By botaoPeriodoNaoUtil =
            By.cssSelector("[href='/vemser/chronos-front/gestao/dias-nao-uteis']");
    public static void clicarBotaoEdicoes(){
        click(botaoEdicoes);
    }
    public static void clicarBotaoPeriodoNaoUtil(){
        click(botaoPeriodoNaoUtil);
    }
    public static void clicarBotaoEditarPerfil(){
        click(btnDetalhes);
        click(btnEditarPerfil);
    }

}
