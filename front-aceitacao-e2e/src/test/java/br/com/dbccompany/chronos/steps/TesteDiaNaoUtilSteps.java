package br.com.dbccompany.chronos.steps;

public class TesteDiaNaoUtilSteps{
//    public void entrarNaPaginaDeDiasNaoUteis() {
//        GestorPage.clicarBotaoPeriodoNaoUtil();
//    }
//    private void criarDiaNaoUtilValido() {
//        DiaNaoUtilPage.clicarBotaoAdicionarDiaNaoUtil();
//        CadastrarEditarDiaNaoUtilPage.enviarDescricao(Utils.faker.lorem().characters(10));
//        CadastrarEditarDiaNaoUtilPage.enviarDataInicial("10102023");
//        CadastrarEditarDiaNaoUtilPage.clicarCheckBoxRepeticaoAnual();
//        CadastrarEditarDiaNaoUtilPage.enviarDataFinal("10112023");
//        CadastrarEditarDiaNaoUtilPage.clicarBotaoSubmit();
//    }
//    @Test
//    @Owner("Kevin Aryel")
//    @Epic("Frontend")
//    @Feature("Dia não útil")
//    @Story("Criar dia não útil")
//    @Description("Deve criar um dia não útil com sucesso")
//    public void deveCriarDiaNaoUtilComSucesso() throws InterruptedException {
//        BaseSteps.fazerLoginGestor();
//        entrarNaPaginaDeDiasNaoUteis();
//        criarDiaNaoUtilValido();
//        DiaNaoUtilPage.validarToast("Dia Não Útil cadastrado com sucesso");
//        DiaNaoUtilPage.clicarBotaoExcluirUltimoDiaNaoUtil();
//    }
//    @Test
//    @Owner("Kevin Aryel")
//    @Epic("Frontend")
//    @Feature("Dia não útil")
//    @Story("Criar dia não útil")
//    @Description("Deve retornar erro ao tentar criar um dia não útil sem descrição")
//    public void deveCriarDiaNaoUtilSemDescricao() {
//        BaseSteps.fazerLoginGestor();
//        entrarNaPaginaDeDiasNaoUteis();
//        DiaNaoUtilPage.clicarBotaoAdicionarDiaNaoUtil();
//        CadastrarEditarDiaNaoUtilPage.enviarDataInicial("10102023");
//        CadastrarEditarDiaNaoUtilPage.clicarCheckBoxRepeticaoAnual();
//        CadastrarEditarDiaNaoUtilPage.enviarDataFinal("10112023");
//        CadastrarEditarDiaNaoUtilPage.clicarBotaoSubmit();
//        CadastrarEditarDiaNaoUtilPage.validarErroDescricao();
//    }
//    @Test
//    @Owner("Kevin Aryel")
//    @Epic("Frontend")
//    @Feature("Dia não útil")
//    @Story("Criar dia não útil")
//    @Description("Deve retornar erro ao tentar criar um dia não útil sem data inicial")
//    public void deveFalharCriarDiaNaoUtilSemDataInicial() {
//        BaseSteps.fazerLoginGestor();
//        entrarNaPaginaDeDiasNaoUteis();
//        DiaNaoUtilPage.clicarBotaoAdicionarDiaNaoUtil();
//        CadastrarEditarDiaNaoUtilPage.enviarDescricao(Utils.faker.lorem().characters(10));
//        CadastrarEditarDiaNaoUtilPage.clicarCheckBoxRepeticaoAnual();
//        CadastrarEditarDiaNaoUtilPage.enviarDataFinal("10112023");
//        CadastrarEditarDiaNaoUtilPage.clicarBotaoSubmit();
//        CadastrarEditarDiaNaoUtilPage.validarErroDataInicial();
//    }
//    @Test
//    @Owner("Kevin Aryel")
//    @Epic("Frontend")
//    @Feature("Dia não útil")
//    @Story("Criar dia não útil")
//    @Description("Deve criar um dia não útil sem data final com sucesso")
//    public void deveCriarDiaNaoUtilSemDataFinalComSucesso() throws InterruptedException {
//        BaseSteps.fazerLoginGestor();
//        entrarNaPaginaDeDiasNaoUteis();
//        DiaNaoUtilPage.clicarBotaoAdicionarDiaNaoUtil();
//        CadastrarEditarDiaNaoUtilPage.enviarDescricao(Utils.faker.lorem().characters(10));
//        CadastrarEditarDiaNaoUtilPage.enviarDataInicial("10102023");
//        CadastrarEditarDiaNaoUtilPage.clicarCheckBoxRepeticaoAnual();
//        CadastrarEditarDiaNaoUtilPage.clicarBotaoSubmit();
//        DiaNaoUtilPage.validarToast("Dia Não Útil cadastrado com sucesso");
//        DiaNaoUtilPage.clicarBotaoExcluirUltimoDiaNaoUtil();
//    }
//    @Test
//    @Owner("Kevin Aryel")
//    @Epic("Frontend")
//    @Feature("Dia não útil")
//    @Story("Criar dia não útil")
//    @Description("Deve retornar erro ao tentar criar um dia não útil com data inicial inválida")
//    public void deveFalharCriarDiaNaoUtilComDataFinalAntesDaDataInicial() {
//        BaseSteps.fazerLoginGestor();
//        entrarNaPaginaDeDiasNaoUteis();
//        DiaNaoUtilPage.clicarBotaoAdicionarDiaNaoUtil();
//        CadastrarEditarDiaNaoUtilPage.enviarDescricao(Utils.faker.lorem().characters(10));
//        CadastrarEditarDiaNaoUtilPage.enviarDataInicial("10102023");
//        CadastrarEditarDiaNaoUtilPage.clicarCheckBoxRepeticaoAnual();
//        CadastrarEditarDiaNaoUtilPage.enviarDataFinal("10102022");
//        CadastrarEditarDiaNaoUtilPage.clicarBotaoSubmit();
//        DiaNaoUtilPage.validarToast("A data final antecede a data inicial");
//    }
//    @Test
//    @Owner("Kevin Aryel")
//    @Epic("Frontend")
//    @Feature("Dia não útil")
//    @Story("Criar dia não útil")
//    @Description("Deve criar um dia não útil sem repetição anual com sucesso")
//    public void criarDiaNaoUtilSemRepeticao() throws InterruptedException {
//        BaseSteps.fazerLoginGestor();
//        entrarNaPaginaDeDiasNaoUteis();
//        DiaNaoUtilPage.clicarBotaoAdicionarDiaNaoUtil();
//        CadastrarEditarDiaNaoUtilPage.enviarDescricao(Utils.faker.lorem().characters(10));
//        CadastrarEditarDiaNaoUtilPage.enviarDataInicial("10102023");
//        CadastrarEditarDiaNaoUtilPage.enviarDataFinal("10112023");
//        CadastrarEditarDiaNaoUtilPage.clicarBotaoSubmit();
//        DiaNaoUtilPage.validarToast("Dia Não Útil cadastrado com sucesso");
//        DiaNaoUtilPage.clicarBotaoExcluirUltimoDiaNaoUtil();
//    }
//    @Test
//    @Owner("Kevin Aryel")
//    @Epic("Frontend")
//    @Feature("Dia não útil")
//    @Story("Editar dia não útil")
//    @Description("Deve editar a descricão de um dia não útil com sucesso")
//    public void deveEditarDescricaoDiaNaoUtilComSucesso() throws InterruptedException {
//        BaseSteps.fazerLoginGestor();
//        entrarNaPaginaDeDiasNaoUteis();
//        criarDiaNaoUtilValido();
//        try {
//            DiaNaoUtilPage.clicarBotaoEditarUltimoDiaNaoUtil();
//            CadastrarEditarDiaNaoUtilPage.enviarDescricao(Utils.faker.lorem().characters(10));
//            CadastrarEditarDiaNaoUtilPage.clicarBotaoSubmit();
//            DiaNaoUtilPage.validarToast("Dia Não Útil atualizado com sucesso");
//        } finally {
//            DiaNaoUtilPage.clicarBotaoExcluirUltimoDiaNaoUtil();
//        }
//    }
//    @Test
//    @Owner("Kevin Aryel")
//    @Epic("Frontend")
//    @Feature("Dia não útil")
//    @Story("Editar dia não útil")
//    @Description("Deve editar a data de um dia não útil com sucesso")
//    public void deveEditarDataInicialDiaNaoUtilComSucesso() throws InterruptedException {
//        BaseSteps.fazerLoginGestor();
//        entrarNaPaginaDeDiasNaoUteis();
//        criarDiaNaoUtilValido();
//        try {
//            DiaNaoUtilPage.clicarBotaoEditarUltimoDiaNaoUtil();
//            CadastrarEditarDiaNaoUtilPage.enviarDataInicial("05102023");
//            CadastrarEditarDiaNaoUtilPage.clicarBotaoSubmit();
//            DiaNaoUtilPage.validarToast("Dia Não Útil atualizado com sucesso");
//        } finally {
//            DiaNaoUtilPage.clicarBotaoExcluirUltimoDiaNaoUtil();
//        }
//    }
//    @Test
//    @Owner("Kevin Aryel")
//    @Epic("Frontend")
//    @Feature("Dia não útil")
//    @Story("Editar dia não útil")
//    @Description("Deve editar a data final de um dia não útil com sucesso")
//    public void deveEditarDataFinalDiaNaoUtilComSucesso() throws InterruptedException {
//        BaseSteps.fazerLoginGestor();
//        entrarNaPaginaDeDiasNaoUteis();
//        criarDiaNaoUtilValido();
//        try {
//            DiaNaoUtilPage.clicarBotaoEditarUltimoDiaNaoUtil();
//            CadastrarEditarDiaNaoUtilPage.enviarDataFinal("20112023");
//            CadastrarEditarDiaNaoUtilPage.clicarBotaoSubmit();
//            DiaNaoUtilPage.validarToast("Dia Não Útil atualizado com sucesso");
//        } finally {
//            DiaNaoUtilPage.clicarBotaoExcluirUltimoDiaNaoUtil();
//        }
//    }
}