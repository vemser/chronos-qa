package br.com.dbccompany.chronos.steps;

import br.com.dbccompany.chronos.pages.CadastrarEditarEtapaPage;
import br.com.dbccompany.chronos.pages.EdicoesPage;
import br.com.dbccompany.chronos.pages.VerificarEdicaoPage;
import br.com.dbccompany.chronos.utils.Utils;
import io.qameta.allure.*;
import org.junit.Test;

public class TesteEtapaSteps extends BaseSteps {
    public static void criarEtapaValida() {
        VerificarEdicaoPage.clicarBotaoAdicionarEtapa();
        CadastrarEditarEtapaPage.preencherNome(Utils.faker.lorem().characters(10));
        CadastrarEditarEtapaPage.preencherOrdemExecucao("1");
        CadastrarEditarEtapaPage.clicarBotaoSubmitEtapa();
    }

    private static void rotinaCriarEdicaoValida() throws InterruptedException {
        fazerLoginGestor();
        entrarNaPaginaDeEdicoes();
        TesteEdicoesSteps.criarEdicaoValida();
    }

    @Test
    @Owner("Kevin Aryel")
    @Epic("Frontend")
    @Feature("Etape")
    @Story("Criar Etapa")
    @Description("Deve criar uma etapa com sucesso")
    public void testeCriarEtapaComSucesso() throws InterruptedException {
        rotinaCriarEdicaoValida();
        EdicoesPage.clicarBotaoDetalhesUltima();
        criarEtapaValida();
        if(VerificarEdicaoPage.validarToastSucesso()){
            entrarNaPaginaDeEdicoes();
            EdicoesPage.clicarBotaoExcluirUltima();
        }
    }
    @Test
    @Owner("Kevin Aryel")
    @Epic("Frontend")
    @Feature("Etape")
    @Story("Criar Etapa")
    @Description("Deve retornar erro ao tentar criar uma etapa sem nome")
    public void testeCriarEtapaSemNome() throws InterruptedException {
        fazerLoginGestor();
        entrarNaPaginaDeEdicoes();
        TesteEdicoesSteps.criarEdicaoValida();
        EdicoesPage.clicarBotaoDetalhesUltima();
        try{
            VerificarEdicaoPage.clicarBotaoAdicionarEtapa();
            CadastrarEditarEtapaPage.preencherOrdemExecucao("1");
            CadastrarEditarEtapaPage.clicarBotaoSubmitEtapa();
            CadastrarEditarEtapaPage.validarErroNome();
        } finally {
            entrarNaPaginaDeEdicoes();
            EdicoesPage.clicarBotaoExcluirUltima();
        }
    }
    @Test
    @Owner("Kevin Aryel")
    @Epic("Frontend")
    @Feature("Etape")
    @Story("Editar Etapa")
    @Description("Deve editar uma etapa com sucesso")
    public void testarEditarEtapaComSucesso() throws InterruptedException{
        fazerLoginGestor();
        entrarNaPaginaDeEdicoes();
        TesteEdicoesSteps.criarEdicaoValida();
        EdicoesPage.clicarBotaoDetalhesUltima();
        criarEtapaValida();
        try{
            VerificarEdicaoPage.clicarBotaoEditarEtapa();
            CadastrarEditarEtapaPage.preencherNome(Utils.faker.lorem().characters(10));
            CadastrarEditarEtapaPage.preencherOrdemExecucao("1");
            CadastrarEditarEtapaPage.clicarBotaoSubmitEtapa();
            VerificarEdicaoPage.validarToastSucesso();
        } finally {
            entrarNaPaginaDeEdicoes();
            EdicoesPage.clicarBotaoExcluirUltima();
        }
    }
    @Test
    @Owner("Kevin Aryel")
    @Epic("Frontend")
    @Feature("Etape")
    @Story("Editar Etapa")
    @Description("Deve excluir uma etapa sem nome")
    public void testarExcluirEtapaComSucesso() throws InterruptedException{
        fazerLoginGestor();
        entrarNaPaginaDeEdicoes();
        TesteEdicoesSteps.criarEdicaoValida();
        EdicoesPage.clicarBotaoDetalhesUltima();
        criarEtapaValida();
        try{
            VerificarEdicaoPage.clicarBotaoExcluirEtapa();
            VerificarEdicaoPage.validarToastSucesso();
        } finally {
            entrarNaPaginaDeEdicoes();
            EdicoesPage.clicarBotaoExcluirUltima();
        }
    }

    @Test
    @Owner("Kevin Aryel")
    @Epic("Frontend")
    @Feature("Etape")
    @Story("Editar Etapa")
    @Description("Deve retornar erro ao tentar editar uma etapa sem nome")
    public void testarEditarEtapaSemNome() throws InterruptedException{
        fazerLoginGestor();
        entrarNaPaginaDeEdicoes();
        TesteEdicoesSteps.criarEdicaoValida();
        EdicoesPage.clicarBotaoDetalhesUltima();
        criarEtapaValida();
        try{
            VerificarEdicaoPage.clicarBotaoEditarEtapa();
            CadastrarEditarEtapaPage.preencherOrdemExecucao("1");
            CadastrarEditarEtapaPage.preencherNome("");
            CadastrarEditarEtapaPage.clicarBotaoSubmitEtapa();
            CadastrarEditarEtapaPage.validarErroNome();
        } finally {
            entrarNaPaginaDeEdicoes();
            EdicoesPage.clicarBotaoExcluirUltima();
        }
    }
}
