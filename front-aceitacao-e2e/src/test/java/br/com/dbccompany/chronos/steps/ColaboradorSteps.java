package br.com.dbccompany.chronos.steps;

import br.com.dbccompany.chronos.pages.ColaboradoresPage;
import cucumber.api.java.pt.E;

public class ColaboradorSteps {

    private static void buscarColaborador(){
        ColaboradoresPage.preencherInputPesquisaLogin("teste");
        ColaboradoresPage.clicarBotaoFiltrarCadastro();
    }
    @E("clique no botao de criar colaborador")
    public void clicarBtnCriarColaborador(){
        ColaboradoresPage.clicarBotaoCriarColaborador();
    }
    @E("clique no botao de editar colaborador")
    public void clicarBtnEditarColaborador() throws InterruptedException {
        buscarColaborador();
        ColaboradoresPage.clicarBotaoEditarUltimo();
    }
}
