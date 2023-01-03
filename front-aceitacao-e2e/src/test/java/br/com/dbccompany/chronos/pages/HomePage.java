package br.com.dbccompany.chronos.pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage {
    private static final By botaoColaboradores =
            By.cssSelector("[href='/vemser/chronos-front/admin/colaboradores']> button");
    private static final By btnDetalhes =
            By.cssSelector("[aria-label='Exibir detalhes']");
    private static final By btnEditarPerfil =
            By.id("button-editar-perfil");
    private static final By botaoEdicoes =
            By.cssSelector("[href='/vemser/chronos-front/gestao/edicoes']> button");
    private static final By botaoPeriodoNaoUtil =
            By.cssSelector("[href='/vemser/chronos-front/gestao/dias-nao-uteis']");
    private static void clicarBotaoEdicoes(){
        click(botaoEdicoes);
    }
    private static void clicarBotaoPeriodoNaoUtil(){
        click(botaoPeriodoNaoUtil);
    }
    private static void clicarBotaoEditarPerfil(){
        click(btnDetalhes);
        click(btnEditarPerfil);
    }
    public static void clicarBtnColaboradores(){
        click(botaoColaboradores);
    }
    public static void clicarBtnEdicoes(){
        click(botaoEdicoes);
    }
}
