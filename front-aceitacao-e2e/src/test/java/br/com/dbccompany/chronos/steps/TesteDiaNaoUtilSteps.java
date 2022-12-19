package br.com.dbccompany.chronos.steps;
import br.com.dbccompany.chronos.pages.CadastrarEditarDiaNaoUtilPage;
import br.com.dbccompany.chronos.pages.DiaNaoUtilPage;
import br.com.dbccompany.chronos.pages.GestorPage;
import br.com.dbccompany.chronos.utils.Utils;
import io.qameta.allure.*;
import org.junit.Test;

public class TesteDiaNaoUtilSteps extends BaseSteps {
    public void entrarNaPaginaDeDiasNaoUteis() {
        GestorPage.clicarBotaoPeriodoNaoUtil();
    }
    private void criarDiaNaoUtilValido() {
        DiaNaoUtilPage.clicarBotaoAdicionarDiaNaoUtil();
        CadastrarEditarDiaNaoUtilPage.enviarDescricao(Utils.faker.lorem().characters(10));
        CadastrarEditarDiaNaoUtilPage.enviarDataInicial("10102023");
        CadastrarEditarDiaNaoUtilPage.clicarCheckBoxRepeticaoAnual();
        CadastrarEditarDiaNaoUtilPage.enviarDataFinal("10112023");
        CadastrarEditarDiaNaoUtilPage.clicarBotaoSubmit();
    }
    @Test
    @Owner("Kevin Aryel")
    @Epic("Frontend")
    @Feature("Dia não útil")
    @Story("Criar dia não útil")
    @Description("Deve criar um dia não útil com sucesso")
    public void deveCriarDiaNaoUtilComSucesso() throws InterruptedException {
        fazerLoginGestor();
        entrarNaPaginaDeDiasNaoUteis();
        criarDiaNaoUtilValido();
        DiaNaoUtilPage.validarToast("Dia Não Útil cadastrado com sucesso");
        DiaNaoUtilPage.clicarBotaoExcluirUltimoDiaNaoUtil();
    }
    @Test
    @Owner("Kevin Aryel")
    @Epic("Frontend")
    @Feature("Dia não útil")
    @Story("Criar dia não útil")
    @Description("Deve retornar erro ao tentar criar um dia não útil sem descrição")
    public void deveCriarDiaNaoUtilSemDescricao() {
        fazerLoginGestor();
        entrarNaPaginaDeDiasNaoUteis();
        DiaNaoUtilPage.clicarBotaoAdicionarDiaNaoUtil();
        CadastrarEditarDiaNaoUtilPage.enviarDataInicial("10102023");
        CadastrarEditarDiaNaoUtilPage.clicarCheckBoxRepeticaoAnual();
        CadastrarEditarDiaNaoUtilPage.enviarDataFinal("10112023");
        CadastrarEditarDiaNaoUtilPage.clicarBotaoSubmit();
        CadastrarEditarDiaNaoUtilPage.validarErroDescricao();
    }
    @Test
    @Owner("Kevin Aryel")
    @Epic("Frontend")
    @Feature("Dia não útil")
    @Story("Criar dia não útil")
    @Description("Deve retornar erro ao tentar criar um dia não útil sem data inicial")
    public void deveFalharCriarDiaNaoUtilSemDataInicial() {
        fazerLoginGestor();
        entrarNaPaginaDeDiasNaoUteis();
        DiaNaoUtilPage.clicarBotaoAdicionarDiaNaoUtil();
        CadastrarEditarDiaNaoUtilPage.enviarDescricao(Utils.faker.lorem().characters(10));
        CadastrarEditarDiaNaoUtilPage.clicarCheckBoxRepeticaoAnual();
        CadastrarEditarDiaNaoUtilPage.enviarDataFinal("10112023");
        CadastrarEditarDiaNaoUtilPage.clicarBotaoSubmit();
        CadastrarEditarDiaNaoUtilPage.validarErroDataInicial();
    }
    @Test
    @Owner("Kevin Aryel")
    @Epic("Frontend")
    @Feature("Dia não útil")
    @Story("Criar dia não útil")
    @Description("Deve criar um dia não útil sem data final com sucesso")
    public void deveCriarDiaNaoUtilSemDataFinalComSucesso() throws InterruptedException {
        fazerLoginGestor();
        entrarNaPaginaDeDiasNaoUteis();
        DiaNaoUtilPage.clicarBotaoAdicionarDiaNaoUtil();
        CadastrarEditarDiaNaoUtilPage.enviarDescricao(Utils.faker.lorem().characters(10));
        CadastrarEditarDiaNaoUtilPage.enviarDataInicial("10102023");
        CadastrarEditarDiaNaoUtilPage.clicarCheckBoxRepeticaoAnual();
        CadastrarEditarDiaNaoUtilPage.clicarBotaoSubmit();
        DiaNaoUtilPage.validarToast("Dia Não Útil cadastrado com sucesso");
        DiaNaoUtilPage.clicarBotaoExcluirUltimoDiaNaoUtil();
    }
    @Test
    @Owner("Kevin Aryel")
    @Epic("Frontend")
    @Feature("Dia não útil")
    @Story("Criar dia não útil")
    @Description("Deve retornar erro ao tentar criar um dia não útil com data inicial inválida")
    public void deveFalharCriarDiaNaoUtilComDataFinalAntesDaDataInicial() {
        fazerLoginGestor();
        entrarNaPaginaDeDiasNaoUteis();
        DiaNaoUtilPage.clicarBotaoAdicionarDiaNaoUtil();
        CadastrarEditarDiaNaoUtilPage.enviarDescricao(Utils.faker.lorem().characters(10));
        CadastrarEditarDiaNaoUtilPage.enviarDataInicial("10102023");
        CadastrarEditarDiaNaoUtilPage.clicarCheckBoxRepeticaoAnual();
        CadastrarEditarDiaNaoUtilPage.enviarDataFinal("10102022");
        CadastrarEditarDiaNaoUtilPage.clicarBotaoSubmit();
        DiaNaoUtilPage.validarToast("A data final antecede a data inicial");
    }
    @Test
    @Owner("Kevin Aryel")
    @Epic("Frontend")
    @Feature("Dia não útil")
    @Story("Criar dia não útil")
    @Description("Deve criar um dia não útil sem repetição anual com sucesso")
    public void criarDiaNaoUtilSemRepeticao() throws InterruptedException {
        fazerLoginGestor();
        entrarNaPaginaDeDiasNaoUteis();
        DiaNaoUtilPage.clicarBotaoAdicionarDiaNaoUtil();
        CadastrarEditarDiaNaoUtilPage.enviarDescricao(Utils.faker.lorem().characters(10));
        CadastrarEditarDiaNaoUtilPage.enviarDataInicial("10102023");
        CadastrarEditarDiaNaoUtilPage.enviarDataFinal("10112023");
        CadastrarEditarDiaNaoUtilPage.clicarBotaoSubmit();
        DiaNaoUtilPage.validarToast("Dia Não Útil cadastrado com sucesso");
        DiaNaoUtilPage.clicarBotaoExcluirUltimoDiaNaoUtil();
    }
    @Test
    @Owner("Kevin Aryel")
    @Epic("Frontend")
    @Feature("Dia não útil")
    @Story("Editar dia não útil")
    @Description("Deve editar a descricão de um dia não útil com sucesso")
    public void deveEditarDescricaoDiaNaoUtilComSucesso() throws InterruptedException {
        fazerLoginGestor();
        entrarNaPaginaDeDiasNaoUteis();
        criarDiaNaoUtilValido();
        try {
            DiaNaoUtilPage.clicarBotaoEditarUltimoDiaNaoUtil();
            CadastrarEditarDiaNaoUtilPage.enviarDescricao(Utils.faker.lorem().characters(10));
            CadastrarEditarDiaNaoUtilPage.clicarBotaoSubmit();
            DiaNaoUtilPage.validarToast("Dia Não Útil atualizado com sucesso");
        } finally {
            DiaNaoUtilPage.clicarBotaoExcluirUltimoDiaNaoUtil();
        }
    }
    @Test
    @Owner("Kevin Aryel")
    @Epic("Frontend")
    @Feature("Dia não útil")
    @Story("Editar dia não útil")
    @Description("Deve editar a data de um dia não útil com sucesso")
    public void deveEditarDataInicialDiaNaoUtilComSucesso() throws InterruptedException {
        fazerLoginGestor();
        entrarNaPaginaDeDiasNaoUteis();
        criarDiaNaoUtilValido();
        try {
            DiaNaoUtilPage.clicarBotaoEditarUltimoDiaNaoUtil();
            CadastrarEditarDiaNaoUtilPage.enviarDataInicial("05102023");
            CadastrarEditarDiaNaoUtilPage.clicarBotaoSubmit();
            DiaNaoUtilPage.validarToast("Dia Não Útil atualizado com sucesso");
        } finally {
            DiaNaoUtilPage.clicarBotaoExcluirUltimoDiaNaoUtil();
        }
    }
    @Test
    @Owner("Kevin Aryel")
    @Epic("Frontend")
    @Feature("Dia não útil")
    @Story("Editar dia não útil")
    @Description("Deve editar a data final de um dia não útil com sucesso")
    public void deveEditarDataFinalDiaNaoUtilComSucesso() throws InterruptedException {
        fazerLoginGestor();
        entrarNaPaginaDeDiasNaoUteis();
        criarDiaNaoUtilValido();
        try {
            DiaNaoUtilPage.clicarBotaoEditarUltimoDiaNaoUtil();
            CadastrarEditarDiaNaoUtilPage.enviarDataFinal("20112023");
            CadastrarEditarDiaNaoUtilPage.clicarBotaoSubmit();
            DiaNaoUtilPage.validarToast("Dia Não Útil atualizado com sucesso");
        } finally {
            DiaNaoUtilPage.clicarBotaoExcluirUltimoDiaNaoUtil();
        }
    }
}