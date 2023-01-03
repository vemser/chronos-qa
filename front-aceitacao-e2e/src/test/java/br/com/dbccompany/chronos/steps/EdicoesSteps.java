package br.com.dbccompany.chronos.steps;

import br.com.dbccompany.chronos.pages.EdicoesPage;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class EdicoesSteps {

    @E("clique no botao de criar edicao")
    public void clicarBtnCriarEdicao(){
        EdicoesPage.clicarBotaoCriarEdicao();
    }
    @E("clique em editar edicao")
    public void clicarBtnEditarEdicao() throws InterruptedException {
        EdicoesPage.clicarBotaoEditarUltima();
    }
    @E("clique no botao de detalhes da edicao")
    public void clicarBtnDetalhesEdicao() throws InterruptedException {
        EdicoesPage.clicarBotaoDetalhesUltima();
    }
    @Quando("clico em clonar edicao")
    public void clicarBtnClonarEdicao() throws InterruptedException {
        EdicoesPage.clicarBotaoClonarUltima();
    }
    @Quando("clico em alterar status da edicao")
    public void clicarBtnAlterarStatusEdicao() throws InterruptedException {
        EdicoesPage.clicarBotaoStatusUltima();
    }
    @Entao("devo ver um toast de sucesso de clonar edicao")
    public void validarToastSucessoClonarEdicao(){
        EdicoesPage.validarToast("Clone criado com sucesso");
    }
    @Entao("devo ver um toast de sucesso de alterar status da edicao")
    public void validarToastAlterarStatusEdicao(){
        EdicoesPage.validarToast("alterado para");
    }
}
