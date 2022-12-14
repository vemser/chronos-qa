package br.com.dbccompany.chronos.steps;

import br.com.dbccompany.chronos.pages.VerificarEdicaoPage;
import cucumber.api.java.pt.E;

public class VerificarEdicaoSteps {
    @E("clique no botao de adicionar etapa")
    public void clicarBtnAdicionarEtapa(){
        VerificarEdicaoPage.clicarBotaoAdicionarEtapa();
    }
    @E("clique em editar etapa")
    public void clicarBtnEditarEtapa(){
        VerificarEdicaoPage.clicarBotaoEditarEtapa();
    }
    @E("clique em criar processo")
    public void clicarBtnCriarProcesso(){
        VerificarEdicaoPage.clicarBotaoAdicionarProcesso();
    }
    @E("clique no botao de editar processo")
    public void clicarBtnEditarProcesso(){
        VerificarEdicaoPage.clicarBotaoEditarProcesso();
    }
}
