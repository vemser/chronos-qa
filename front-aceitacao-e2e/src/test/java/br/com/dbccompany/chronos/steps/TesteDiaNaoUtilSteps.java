package br.com.dbccompany.chronos.steps;
import br.com.dbccompany.chronos.pages.CadastrarEditarDiaNaoUtilPage;
import br.com.dbccompany.chronos.pages.DiaNaoUtilPage;
import br.com.dbccompany.chronos.pages.GestorPage;
import br.com.dbccompany.chronos.utils.Utils;
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
    public void deveCriarDiaNaoUtilComSucesso() throws InterruptedException {
        fazerLoginGestor();
        entrarNaPaginaDeDiasNaoUteis();
        criarDiaNaoUtilValido();
        DiaNaoUtilPage.validarToastSucesso();
        DiaNaoUtilPage.clicarBotaoExcluirUltimoDiaNaoUtil();
    }

    @Test
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
    public void deveCriarDiaNaoUtilSemDataFinalComSucesso() throws InterruptedException {
        fazerLoginGestor();
        entrarNaPaginaDeDiasNaoUteis();
        DiaNaoUtilPage.clicarBotaoAdicionarDiaNaoUtil();
        CadastrarEditarDiaNaoUtilPage.enviarDescricao(Utils.faker.lorem().characters(10));
        CadastrarEditarDiaNaoUtilPage.enviarDataInicial("10102023");
        CadastrarEditarDiaNaoUtilPage.clicarCheckBoxRepeticaoAnual();
        CadastrarEditarDiaNaoUtilPage.clicarBotaoSubmit();
        DiaNaoUtilPage.validarToastSucesso();
        DiaNaoUtilPage.clicarBotaoExcluirUltimoDiaNaoUtil();
    }

    @Test
    public void deveFalharCriarDiaNaoUtilComDataFinalAntesDaDataInicial() {
        fazerLoginGestor();
        entrarNaPaginaDeDiasNaoUteis();
        DiaNaoUtilPage.clicarBotaoAdicionarDiaNaoUtil();
        CadastrarEditarDiaNaoUtilPage.enviarDescricao(Utils.faker.lorem().characters(10));
        CadastrarEditarDiaNaoUtilPage.enviarDataInicial("10102023");
        CadastrarEditarDiaNaoUtilPage.clicarCheckBoxRepeticaoAnual();
        CadastrarEditarDiaNaoUtilPage.enviarDataFinal("10102022");
        CadastrarEditarDiaNaoUtilPage.clicarBotaoSubmit();
        DiaNaoUtilPage.validarToastErro();
    }

    @Test
    public void criarDiaNaoUtilSemRepeticao() throws InterruptedException {
        fazerLoginGestor();
        entrarNaPaginaDeDiasNaoUteis();
        DiaNaoUtilPage.clicarBotaoAdicionarDiaNaoUtil();
        CadastrarEditarDiaNaoUtilPage.enviarDescricao(Utils.faker.lorem().characters(10));
        CadastrarEditarDiaNaoUtilPage.enviarDataInicial("10102023");
        CadastrarEditarDiaNaoUtilPage.enviarDataFinal("10112023");
        CadastrarEditarDiaNaoUtilPage.clicarBotaoSubmit();
        DiaNaoUtilPage.validarToastSucesso();
        DiaNaoUtilPage.clicarBotaoExcluirUltimoDiaNaoUtil();
    }

    @Test
    public void deveEditarRepeticaoDiaNaoUtilComSucesso() throws InterruptedException {
        fazerLoginGestor();
        entrarNaPaginaDeDiasNaoUteis();
        criarDiaNaoUtilValido();
        try {
            DiaNaoUtilPage.clicarBotaoEditarUltimoDiaNaoUtil();
            CadastrarEditarDiaNaoUtilPage.clicarCheckBoxRepeticaoAnual();
            CadastrarEditarDiaNaoUtilPage.clicarBotaoSubmit();
            DiaNaoUtilPage.validarToastSucesso();
        } finally {
            DiaNaoUtilPage.clicarBotaoExcluirUltimoDiaNaoUtil();
        }
    }

    @Test
    public void deveEditarDescricaoDiaNaoUtilComSucesso() throws InterruptedException {
        fazerLoginGestor();
        entrarNaPaginaDeDiasNaoUteis();
        criarDiaNaoUtilValido();
        try {
            DiaNaoUtilPage.clicarBotaoEditarUltimoDiaNaoUtil();
            CadastrarEditarDiaNaoUtilPage.enviarDescricao(Utils.faker.lorem().characters(10));
            CadastrarEditarDiaNaoUtilPage.clicarBotaoSubmit();
            DiaNaoUtilPage.validarToastSucesso();
        } finally {
            DiaNaoUtilPage.clicarBotaoExcluirUltimoDiaNaoUtil();
        }
    }
    @Test
    public void deveEditarDataInicialDiaNaoUtilComSucesso() throws InterruptedException {
        fazerLoginGestor();
        entrarNaPaginaDeDiasNaoUteis();
        criarDiaNaoUtilValido();
        try {
            DiaNaoUtilPage.clicarBotaoEditarUltimoDiaNaoUtil();
            CadastrarEditarDiaNaoUtilPage.enviarDataInicial("05102023");
            CadastrarEditarDiaNaoUtilPage.clicarBotaoSubmit();
            DiaNaoUtilPage.validarToastSucesso();
        } finally {
            DiaNaoUtilPage.clicarBotaoExcluirUltimoDiaNaoUtil();
        }
    }
    @Test
    public void deveEditarDataFinalDiaNaoUtilComSucesso() throws InterruptedException {
        fazerLoginGestor();
        entrarNaPaginaDeDiasNaoUteis();
        criarDiaNaoUtilValido();
        try {
            DiaNaoUtilPage.clicarBotaoEditarUltimoDiaNaoUtil();
            CadastrarEditarDiaNaoUtilPage.enviarDataFinal("20112023");
            CadastrarEditarDiaNaoUtilPage.clicarBotaoSubmit();
            DiaNaoUtilPage.validarToastSucesso();
        } finally {
            DiaNaoUtilPage.clicarBotaoExcluirUltimoDiaNaoUtil();
        }
    }

}