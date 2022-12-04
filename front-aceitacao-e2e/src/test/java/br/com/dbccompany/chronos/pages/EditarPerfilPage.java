package br.com.dbccompany.chronos.pages;

import org.openqa.selenium.By;

public class EditarPerfilPage extends BasePage{

    private static final By inputNome =
            By.id("nome");
    private static final By inputSenhaAtual =
            By.id("senhaAtual");
    private static final By inputNovaSenha =
            By.id("novaSenha");
    private static final By inputConfirmarNovaSenha =
            By.id("confirmacaoNovaSenha");
    private static final By spanErroNome =
            By.id("nome-error");
    private static final By spanErroSenhaAtual =
            By.id("senha-atual-error");
    private static final By spanErroNovaSenha =
            By.id("nova-senha-error");
    private static final By spanErroConfirmarNovaSenha =
            By.id("confirmacao-error");
    private static final By btnSubmit =
            By.cssSelector("button[type='submit']");
    public static void preencherNome(String nome){
        sendKeys(inputNome, nome);
    }
    public static void preencherSenhaAtual(String senhaAtual){
        sendKeys(inputSenhaAtual, senhaAtual);
    }
    public static void preencherNovaSenha(String novaSenha){
        sendKeys(inputNovaSenha, novaSenha);
    }
    public static void preencherConfirmarNovaSenha(String confirmarNovaSenha){
        sendKeys(inputConfirmarNovaSenha, confirmarNovaSenha);
    }
    public static void clicarBotaoSubmit(){
        click(btnSubmit);
    }
    public static boolean validarErroNome(){
        return checkElementDisplayStatus(spanErroNome);
    }
    public static boolean validarErroSenhaAtual(){
        return checkElementDisplayStatus(spanErroSenhaAtual);
    }
    public static boolean validarErroNovaSenha(){
        return checkElementDisplayStatus(spanErroNovaSenha);
    }
    public static boolean validarErroConfirmarNovaSenha(){
        return checkElementDisplayStatus(spanErroConfirmarNovaSenha);
    }
    public static boolean validarToastErroSenha(){
        return checkElementTextContains(toastMessage, "Senha");
    }
}
