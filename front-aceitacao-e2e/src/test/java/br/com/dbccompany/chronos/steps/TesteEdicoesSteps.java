package br.com.dbccompany.chronos.steps;

import br.com.dbccompany.chronos.pages.CadastrarEdicaoPage;
import br.com.dbccompany.chronos.pages.EdicoesPage;
import br.com.dbccompany.chronos.pages.GestorPage;
import br.com.dbccompany.chronos.utils.Utils;
import io.qameta.allure.*;
import org.junit.Test;

public class TesteEdicoesSteps extends BaseSteps{
    public static void criarEdicaoValida(){
        EdicoesPage.clicarBotaoCriarEdicao();
        CadastrarEdicaoPage.enviarNomeEdicao(Utils.faker.lorem().characters(10));
        CadastrarEdicaoPage.enviarDataInicio("10102023");
        CadastrarEdicaoPage.enviarDataFim("10112023");
        CadastrarEdicaoPage.clicarBotaoSubmit();
    }

    @Test
    @Owner("Kevin Aryel")
    @Epic("Frontend")
    @Feature("Edição")
    @Story("Criar edição")
    @Description("Deve criar uma edição com sucesso")
    public void testeCriarEdicoesComSucesso() throws InterruptedException {
        fazerLoginGestor();
        entrarNaPaginaDeEdicoes();
        criarEdicaoValida();
        EdicoesPage.validarToastSucesso();
        EdicoesPage.clicarBotaoExcluirUltima();
    }

    @Test
    @Owner("Kevin Aryel")
    @Epic("Frontend")
    @Feature("Edição")
    @Story("Criar edição")
    @Description("Deve retornar erro ao tentar criar uma edição sem data inicial")
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
    @Owner("Kevin Aryel")
    @Epic("Frontend")
    @Feature("Edição")
    @Story("Criar edição")
    @Description("Deve retornar erro ao tentar criar uma edição sem data final")
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
    @Owner("Kevin Aryel")
    @Epic("Frontend")
    @Feature("Edição")
    @Story("Criar edição")
    @Description("Deve retornar erro ao tentar criar uma edição sem nome")
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
    @Owner("Kevin Aryel")
    @Epic("Frontend")
    @Feature("Edição")
    @Story("Criar edição")
    @Description("Deve retornar erro ao tentar criar uma edição com data inicial inválida")
    public void testarCriarEdicoesComDataInicialMaiorQueDataFinal(){
        fazerLoginGestor();
        entrarNaPaginaDeEdicoes();
        EdicoesPage.clicarBotaoCriarEdicao();
        CadastrarEdicaoPage.enviarNomeEdicao(Utils.faker.lorem().characters(10));
        CadastrarEdicaoPage.enviarDataInicio("12122022");
        CadastrarEdicaoPage.enviarDataFim("10122022");
        CadastrarEdicaoPage.clicarBotaoSubmit();
        EdicoesPage.validarToastErro();
    }
    @Test
    @Owner("Kevin Aryel")
    @Epic("Frontend")
    @Feature("Edição")
    @Story("Criar edição")
    @Description("Deve retornar erro ao tentar criar uma edição com data final igual a data inicial")
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
    @Owner("Kevin Aryel")
    @Epic("Frontend")
    @Feature("Edição")
    @Story("Clonar edição")
    @Description("Deve clonar uma edição com sucesso")
    public void testarClonarEdicoes() throws InterruptedException {
        fazerLoginGestor();
        entrarNaPaginaDeEdicoes();
        criarEdicaoValida();
        try{
            String nomeEdicao = EdicoesPage.nomeUltimaEdicao();
            EdicoesPage.clicarBotaoClonarUltima();
            EdicoesPage.validarToastSucesso();
            EdicoesPage.validarNomeUltimaEdicao(nomeEdicao);
            EdicoesPage.clicarBotaoExcluirUltima();
        }finally {
            EdicoesPage.clicarBotaoExcluirUltima();
        }
    }
    @Test
    @Owner("Kevin Aryel")
    @Epic("Frontend")
    @Feature("Edição")
    @Story("Editar status edição")
    @Description("Deve editar o status de uma edição com sucesso")
    public void testarMudarStatusEdicoes() throws InterruptedException {
        fazerLoginGestor();
        entrarNaPaginaDeEdicoes();
        criarEdicaoValida();
        try {
            EdicoesPage.clicarBotaoStatusUltima();
            EdicoesPage.validarToastSucesso();
            EdicoesPage.clicarBotaoStatusUltima();
        } finally {
            EdicoesPage.clicarBotaoExcluirUltima();
        }
    }
    @Test
    @Owner("Kevin Aryel")
    @Epic("Frontend")
    @Feature("Edição")
    @Story("Editar edição")
    @Description("Deve editar uma edição com sucesso")
    public void testarEditarEdicaoComSucesso() throws InterruptedException {
        fazerLoginGestor();
        entrarNaPaginaDeEdicoes();
        criarEdicaoValida();
        try{
            EdicoesPage.clicarBotaoEditarUltima();
            CadastrarEdicaoPage.enviarNomeEdicao(Utils.faker.lorem().characters(12));
            CadastrarEdicaoPage.enviarDataInicio("20122023");
            CadastrarEdicaoPage.enviarDataFim("30122023");
            CadastrarEdicaoPage.clicarBotaoSubmit();
            EdicoesPage.validarToastSucesso();
        } finally {
            entrarNaPaginaDeEdicoes();
            EdicoesPage.clicarBotaoExcluirUltima();
        }

    }
    @Test
    @Owner("Kevin Aryel")
    @Epic("Frontend")
    @Feature("Edição")
    @Story("Editar edição")
    @Description("Deve retornar erro ao tentar editar uma edição sem nome")
    public void testarEditarEdicaoSemNome() throws InterruptedException {
        fazerLoginGestor();
        entrarNaPaginaDeEdicoes();
        criarEdicaoValida();
        try {
            EdicoesPage.clicarBotaoEditarUltima();
            CadastrarEdicaoPage.enviarNomeEdicao("");
            CadastrarEdicaoPage.enviarDataInicio("20122023");
            CadastrarEdicaoPage.enviarDataFim("30122023");
            CadastrarEdicaoPage.clicarBotaoSubmit();
            CadastrarEdicaoPage.validarErroNomeEdicao();
        } finally {
            entrarNaPaginaDeEdicoes();
            EdicoesPage.clicarBotaoExcluirUltima();
        }
    }
    @Test
    @Owner("Kevin Aryel")
    @Epic("Frontend")
    @Feature("Edição")
    @Story("Editar edição")
    @Description("Deve retornar erro ao tentar editar uma edição sem data inicial")
    public void testarEditarEdicaoSemDataInicio() throws InterruptedException {
        fazerLoginGestor();
        entrarNaPaginaDeEdicoes();
        criarEdicaoValida();
        try {
            EdicoesPage.clicarBotaoEditarUltima();
            CadastrarEdicaoPage.enviarNomeEdicao(Utils.faker.lorem().characters(12));
            CadastrarEdicaoPage.enviarDataInicio("");
            CadastrarEdicaoPage.enviarDataFim("30122023");
            CadastrarEdicaoPage.clicarBotaoSubmit();
            CadastrarEdicaoPage.validarErroDataInicio();
        } finally {
            entrarNaPaginaDeEdicoes();
            EdicoesPage.clicarBotaoExcluirUltima();
        }
    }
    @Test
    @Owner("Kevin Aryel")
    @Epic("Frontend")
    @Feature("Edição")
    @Story("Editar edição")
    @Description("Deve retornar erro ao tentar editar uma edição sem data final")
    public void testarEditarEdicaoSemDataFim() throws InterruptedException {
        fazerLoginGestor();
        entrarNaPaginaDeEdicoes();
        criarEdicaoValida();
        try {
            EdicoesPage.clicarBotaoEditarUltima();
            CadastrarEdicaoPage.enviarNomeEdicao(Utils.faker.lorem().characters(12));
            CadastrarEdicaoPage.enviarDataInicio("20122023");
            CadastrarEdicaoPage.enviarDataFim("");
            CadastrarEdicaoPage.clicarBotaoSubmit();
            CadastrarEdicaoPage.validarErroDataFim();
        } finally {
            entrarNaPaginaDeEdicoes();
            EdicoesPage.clicarBotaoExcluirUltima();
        }
    }
}
