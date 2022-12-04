package br.com.dbccompany.chronos.pages;

import org.openqa.selenium.By;

public class VerificarEdicaoPage extends BasePage {
    private static final By btnAddEtapa =
            By.id("addButton");
    private static final By btnEditarEtapa =
            By.id("editar-etapa-0");
    private static final By btnExcluirEtapa =
            By.id("deletar-etapa-0");
    private static final By btnAddProcesso =
            By.id("novo-processo-0");
    private static final By btnEditarProcesso =
            By.id("editar-processo-0");
    private static final By btnExcluirProcesso =
            By.id("deletar-processo-0");
    public static void clicarBotaoAdicionarEtapa(){
        click(btnAddEtapa);
    }
    public static void clicarBotaoExcluirEtapa(){
        click(btnExcluirEtapa);
    }
    public static void clicarBotaoEditarEtapa(){
        click(btnEditarEtapa);
    }
    public static void clicarBotaoAdicionarProcesso(){
        click(btnAddProcesso);
    }
    public static void clicarBotaoEditarProcesso(){
        click(btnEditarProcesso);
    }
    public static void clicarBotaoExcluirProcesso(){
        click(btnExcluirProcesso);
    }
}
