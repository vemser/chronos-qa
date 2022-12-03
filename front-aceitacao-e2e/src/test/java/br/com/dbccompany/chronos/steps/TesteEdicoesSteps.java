package br.com.dbccompany.chronos.steps;

import br.com.dbccompany.chronos.pages.CadastrarEdicaoPage;
import br.com.dbccompany.chronos.pages.EdicoesPage;
import br.com.dbccompany.chronos.pages.GestorPage;
import br.com.dbccompany.chronos.utils.Utils;
import org.junit.Test;

public class TesteEdicoesSteps extends BaseSteps{
    public void entrarNaPaginaDeEdicoes(){
        GestorPage.clicarBotaoEdicoes();
    }

    public void criarEdicaoValida(){
        EdicoesPage.clicarBotaoCriarEdicao();
        CadastrarEdicaoPage.enviarNomeEdicao(Utils.faker.lorem().characters(10));
        CadastrarEdicaoPage.enviarDataInicio("10102023");
        CadastrarEdicaoPage.enviarDataFim("10112023");
        CadastrarEdicaoPage.clicarBotaoSubmit();
    }

    @Test
    public void testeCriarEdicoesComSucesso() throws InterruptedException {
        fazerLoginGestor();
        entrarNaPaginaDeEdicoes();
        criarEdicaoValida();
        EdicoesPage.clicarBotaoExcluirUltima();
        EdicoesPage.validarToastSucesso();
    }

    @Test
    public void testarCriarEdicoesSemDataInicial(){
        fazerLoginGestor();
        entrarNaPaginaDeEdicoes();
        EdicoesPage.clicarBotaoCriarEdicao();
        CadastrarEdicaoPage.enviarNomeEdicao(Utils.faker.lorem().characters(10));
        CadastrarEdicaoPage.enviarDataFim("10112023");
        CadastrarEdicaoPage.clicarBotaoSubmit();
        CadastrarEdicaoPage.validarErroDataInicio();
    }

    @Test
    public void testarCriarEdicoesSemDataFinal(){
        fazerLoginGestor();
        entrarNaPaginaDeEdicoes();
        EdicoesPage.clicarBotaoCriarEdicao();
        CadastrarEdicaoPage.enviarNomeEdicao(Utils.faker.lorem().characters(10));
        CadastrarEdicaoPage.enviarDataInicio("10102023");
        CadastrarEdicaoPage.clicarBotaoSubmit();
        CadastrarEdicaoPage.validarErroDataFim();
    }
    @Test
    public void testarCriarEdicoesSemNome(){
        fazerLoginGestor();
        entrarNaPaginaDeEdicoes();
        EdicoesPage.clicarBotaoCriarEdicao();
        CadastrarEdicaoPage.enviarDataInicio("10102023");
        CadastrarEdicaoPage.enviarDataFim("10112023");
        CadastrarEdicaoPage.clicarBotaoSubmit();
        CadastrarEdicaoPage.validarErroNomeEdicao();
    }
    @Test
    public void testarCriarEdicoesComDataInicialIncompleta(){
        fazerLoginGestor();
        entrarNaPaginaDeEdicoes();
        EdicoesPage.clicarBotaoCriarEdicao();
        CadastrarEdicaoPage.enviarNomeEdicao(Utils.faker.lorem().characters(10));
        CadastrarEdicaoPage.enviarDataInicio("1010");
        CadastrarEdicaoPage.enviarDataFim("10112023");
        CadastrarEdicaoPage.clicarBotaoSubmit();
        CadastrarEdicaoPage.validarErroDataInicio();
    }

    @Test
    public void testarCriarEdicoesComDataInicialMaiorQueDataFinal(){
        fazerLoginGestor();
        entrarNaPaginaDeEdicoes();
        EdicoesPage.clicarBotaoCriarEdicao();
        CadastrarEdicaoPage.enviarNomeEdicao(Utils.faker.lorem().characters(10));
        CadastrarEdicaoPage.enviarDataInicio("12122022");
        CadastrarEdicaoPage.enviarDataFim("10122022");
    //    EdicoesPage.validarToastErro();
    }
    @Test
    public void testarCriarEdicoesComDataInicialIgualDataFinal(){
        fazerLoginGestor();
        entrarNaPaginaDeEdicoes();
        EdicoesPage.clicarBotaoCriarEdicao();
        CadastrarEdicaoPage.enviarNomeEdicao(Utils.faker.lorem().characters(10));
        CadastrarEdicaoPage.enviarDataInicio("10122023");
        CadastrarEdicaoPage.enviarDataFim("10122023");
        CadastrarEdicaoPage.clicarBotaoSubmit();
        EdicoesPage.validarToastErro();
    }
    @Test
    public void testarClonarEdicoes(){
        fazerLoginGestor();
        entrarNaPaginaDeEdicoes();
        String nomeEdicao = EdicoesPage.nomeUltimaEdicao();
        EdicoesPage.clicarBotaoClonarUltima();
        EdicoesPage.validarToastSucesso();
        EdicoesPage.validarNomeUltimaEdicao(nomeEdicao);
        EdicoesPage.clicarBotaoExcluirUltima();
    }
    @Test
    public void testarMudarStatusEdicoes(){
        fazerLoginGestor();
        entrarNaPaginaDeEdicoes();
        EdicoesPage.clicarBotaoStatusUltima();
        EdicoesPage.validarToastSucesso();
        EdicoesPage.clicarBotaoStatusUltima();
    }
    @Test
    public void testarEditarEdicaoComSucesso(){
        fazerLoginGestor();
        entrarNaPaginaDeEdicoes();
        criarEdicaoValida();
        EdicoesPage.clicarBotaoEditarUltima();
        CadastrarEdicaoPage.enviarNomeEdicao(Utils.faker.lorem().characters(12));
        CadastrarEdicaoPage.enviarDataInicio("20122023");
        CadastrarEdicaoPage.enviarDataFim("30122023");
        CadastrarEdicaoPage.clicarBotaoSubmit();
        EdicoesPage.validarToastSucesso();
    }
    @Test
    public void testarEditarEdicaoSemNome(){
        fazerLoginGestor();
        entrarNaPaginaDeEdicoes();
        criarEdicaoValida();
        try {
            EdicoesPage.clicarBotaoEditarUltima();
            CadastrarEdicaoPage.enviarDataInicio("20122023");
            CadastrarEdicaoPage.enviarDataFim("30122023");
            CadastrarEdicaoPage.clicarBotaoSubmit();
            CadastrarEdicaoPage.validarErroNomeEdicao();
        } finally {
            EdicoesPage.clicarBotaoExcluirUltima();
        }
    }
    @Test
    public void testarEditarEdicaoSemDataInicio(){
        fazerLoginGestor();
        entrarNaPaginaDeEdicoes();
        criarEdicaoValida();
        try {
            EdicoesPage.clicarBotaoEditarUltima();
            CadastrarEdicaoPage.enviarNomeEdicao(Utils.faker.lorem().characters(12));
            CadastrarEdicaoPage.enviarDataFim("30122023");
            CadastrarEdicaoPage.clicarBotaoSubmit();
            CadastrarEdicaoPage.validarErroDataInicio();
        } finally {
            EdicoesPage.clicarBotaoExcluirUltima();
        }
    }
    @Test
    public void testarEditarEdicaoSemDataFim(){
        fazerLoginGestor();
        entrarNaPaginaDeEdicoes();
        criarEdicaoValida();
        try {
            EdicoesPage.clicarBotaoEditarUltima();
            CadastrarEdicaoPage.enviarNomeEdicao(Utils.faker.lorem().characters(12));
            CadastrarEdicaoPage.enviarDataInicio("20122023");
            CadastrarEdicaoPage.clicarBotaoSubmit();
            CadastrarEdicaoPage.validarErroDataFim();
        } finally {
            EdicoesPage.clicarBotaoExcluirUltima();
        }
    }
    @Test
    public void testarEditarEdicaoComDataInicialIncompleta(){
        fazerLoginGestor();
        entrarNaPaginaDeEdicoes();
        criarEdicaoValida();
        try {
            EdicoesPage.clicarBotaoEditarUltima();
            CadastrarEdicaoPage.enviarNomeEdicao(Utils.faker.lorem().characters(12));
            CadastrarEdicaoPage.enviarDataInicio("2012");
            CadastrarEdicaoPage.enviarDataFim("30122023");
            CadastrarEdicaoPage.clicarBotaoSubmit();
            CadastrarEdicaoPage.validarErroDataInicio();
        } finally {
            EdicoesPage.clicarBotaoExcluirUltima();
        }
    }
    @Test
    public void testarEditarEdicaoComDataFinalIncompleta(){
        fazerLoginGestor();
        entrarNaPaginaDeEdicoes();
        criarEdicaoValida();
        try {
            EdicoesPage.clicarBotaoEditarUltima();
            CadastrarEdicaoPage.enviarNomeEdicao(Utils.faker.lorem().characters(12));
            CadastrarEdicaoPage.enviarDataInicio("20122023");
            CadastrarEdicaoPage.enviarDataFim("3012");
            CadastrarEdicaoPage.clicarBotaoSubmit();
            CadastrarEdicaoPage.validarErroDataFim();
        } finally {
            EdicoesPage.clicarBotaoExcluirUltima();
        }
    }
}
