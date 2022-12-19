package br.com.dbccompany.chronos.steps;

import br.com.dbccompany.chronos.pages.CadastrarEditarProcessoPage;
import br.com.dbccompany.chronos.pages.EdicoesPage;
import br.com.dbccompany.chronos.pages.VerificarEdicaoPage;
import br.com.dbccompany.chronos.utils.Utils;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.Test;

public class TesteProcessoSteps extends BaseSteps {

    private static void criarProcessoValido(){
        TesteEtapaSteps.criarEtapaValida();
        VerificarEdicaoPage.clicarBotaoAdicionarProcesso();
        CadastrarEditarProcessoPage.preencherNome(Utils.faker.lorem().characters(10));
        CadastrarEditarProcessoPage.selecionarOpcaoAreaEnvolvida();
        CadastrarEditarProcessoPage.selecionarOpcaoResponsavel();
        CadastrarEditarProcessoPage.preencherDuracao("10");
        CadastrarEditarProcessoPage.preencherDiasUteis("5");
        CadastrarEditarProcessoPage.preencherOrdem("1");
        CadastrarEditarProcessoPage.clicarBotaoSubmit();

    }
    @Test
    @Owner("Kevin Aryel")
    @Epic("Frontend")
    @Feature("Processo")
    @Story("Criar Processo")
    public void testarCriarProcessoComSucesso() throws InterruptedException {
        fazerLoginGestor();
        entrarNaPaginaDeEdicoes();
        TesteEdicoesSteps.criarEdicaoValida();
        try{
            EdicoesPage.clicarBotaoDetalhesUltima();
            criarProcessoValido();
            CadastrarEditarProcessoPage.validarToast("Processo cadastrado com sucesso");
        } finally {
            entrarNaPaginaDeEdicoes();
//            EdicoesPage.clicarBotaoExcluirUltima();
        }
    }
    @Test
    @Owner("Kevin Aryel")
    @Epic("Frontend")
    @Feature("Processo")
    @Story("Criar Processo")
    public void testarCriarProcessoComNovoResponsavelAreaEnvolvida() throws InterruptedException {
        fazerLoginGestor();
        entrarNaPaginaDeEdicoes();
        TesteEdicoesSteps.criarEdicaoValida();
        try{
            EdicoesPage.clicarBotaoDetalhesUltima();
            TesteEtapaSteps.criarEtapaValida();
            VerificarEdicaoPage.clicarBotaoAdicionarProcesso();
            CadastrarEditarProcessoPage.preencherNome(Utils.faker.lorem().characters(10));
            CadastrarEditarProcessoPage.preencherAreaEnvolvida(Utils.faker.job().position());
            CadastrarEditarProcessoPage.preencherResponsavel(Utils.faker.job().title());
            CadastrarEditarProcessoPage.preencherDuracao("10");
            CadastrarEditarProcessoPage.preencherDiasUteis("5");
            CadastrarEditarProcessoPage.preencherOrdem("1");
            CadastrarEditarProcessoPage.clicarBotaoSubmit();
            CadastrarEditarProcessoPage.validarToast("Processo cadastrado com sucesso");
        } finally {
            entrarNaPaginaDeEdicoes();
//            EdicoesPage.clicarBotaoExcluirUltima();
        }
    }

    @Test
    @Owner("Kevin Aryel")
    @Epic("Frontend")
    @Feature("Processo")
    @Story("Editar Processo")
    public void testarEditarProcessoComSucesso() throws InterruptedException{
        fazerLoginGestor();
        entrarNaPaginaDeEdicoes();
        TesteEdicoesSteps.criarEdicaoValida();
        try {
            EdicoesPage.clicarBotaoDetalhesUltima();
            criarProcessoValido();
            VerificarEdicaoPage.clicarBotaoEditarProcesso();
            CadastrarEditarProcessoPage.preencherNome(Utils.faker.lorem().characters(10));
            CadastrarEditarProcessoPage.preencherDuracao(Utils.faker.number().digits(1));
            CadastrarEditarProcessoPage.preencherDiasUteis("5");
            CadastrarEditarProcessoPage.preencherOrdem(Utils.faker.number().digits(2));
            CadastrarEditarProcessoPage.clicarBotaoSubmit();
            CadastrarEditarProcessoPage.validarToast("Processo editado com sucesso");
        } finally {
            entrarNaPaginaDeEdicoes();
            EdicoesPage.clicarBotaoExcluirUltima();
        }
    }
    @Test
    @Owner("Kevin Aryel")
    @Epic("Frontend")
    @Feature("Processo")
    @Story("Deletar Processo")
    public void testarDeletarProcessoComSucesso() throws InterruptedException{
        fazerLoginGestor();
        entrarNaPaginaDeEdicoes();
        TesteEdicoesSteps.criarEdicaoValida();
        try {
            EdicoesPage.clicarBotaoDetalhesUltima();
            criarProcessoValido();
            VerificarEdicaoPage.clicarBotaoExcluirProcesso();
            CadastrarEditarProcessoPage.validarToast("Processo removido com sucesso");
        } finally {
            entrarNaPaginaDeEdicoes();
            EdicoesPage.clicarBotaoExcluirUltima();
        }
    }
}
