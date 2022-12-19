package br.com.dbccompany.chronos.steps;

import br.com.dbccompany.chronos.pages.AdminPage;
import br.com.dbccompany.chronos.pages.ColaboradorCreateEditPage;
import br.com.dbccompany.chronos.pages.ColaboradoresPage;
import br.com.dbccompany.chronos.utils.Utils;
import io.qameta.allure.*;
import org.junit.Assert;
import org.junit.Test;

public class TesteColaboradorSteps extends BaseSteps {
    public static void entrarNaPaginaDeColaborador(){
        AdminPage.clicarBotaoColaboradores();
    }
    private static String nomeValido(){
        return Utils.faker.name().fullName().replaceAll("[^A-Z a-z]", "");
    }
    private static String emailValido(){
        return nomeValido().toLowerCase().replaceAll("[^a-z]", "")+"@dbccompany.com.br";
    }
    private static void selecionarCheckBoxAleatoria(){
        Integer checkBox = Utils.faker.number().numberBetween(1,3);
        switch (checkBox){
            case 1:
                ColaboradorCreateEditPage.clicarCheckboxAdmin();
                break;
            case 2:
                ColaboradorCreateEditPage.clicarCheckboxGestao();
                break;
            case 3:
                ColaboradorCreateEditPage.clicarCheckboxInstrutor();
                break;
        }
    }

    private static void criarColaboradorValido(){
        ColaboradoresPage.clicarBotaoCriarColaborador();
        ColaboradorCreateEditPage.preencherNome(nomeValido());
        ColaboradorCreateEditPage.preencherEmail(emailValido());
        selecionarCheckBoxAleatoria();
        ColaboradorCreateEditPage.clicarBotaoEnviar();
    }

    @Test
    @Owner("Kevin Aryel")
    @Epic("Frontend")
    @Feature("Colaborador")
    @Story("Criar Colaborador")
    @Description("Criar um colaborador com sucesso")
    public void deveCriarColaboradorValido() throws InterruptedException {
        fazerLoginAdm();
        entrarNaPaginaDeColaborador();
        criarColaboradorValido();
        boolean sucesso = ColaboradoresPage.validarToastSucesso();
        if(sucesso){
            entrarNaPaginaDeColaborador();
//            ColaboradoresPage.clicarBotaoExcluirUltimo();
        };
    }
    @Test
    @Owner("Kevin Aryel")
    @Epic("Frontend")
    @Feature("Colaborador")
    @Story("Criar Colaborador")
    @Description("Criar um colaborador com mais de um cargo")
    public void deveCriarColaboradorComCargoDuplo() throws InterruptedException {
        fazerLoginAdm();
        entrarNaPaginaDeColaborador();
        ColaboradoresPage.clicarBotaoCriarColaborador();
        ColaboradorCreateEditPage.preencherNome(nomeValido());
        ColaboradorCreateEditPage.preencherEmail(emailValido());
        ColaboradorCreateEditPage.clicarCheckboxAdmin();
        ColaboradorCreateEditPage.clicarCheckboxInstrutor();
        ColaboradorCreateEditPage.clicarBotaoEnviar();
        boolean sucesso = ColaboradoresPage.validarToastSucesso();
        if(sucesso){
            entrarNaPaginaDeColaborador();
//            ColaboradoresPage.clicarBotaoExcluirUltimo();
        };
        Assert.assertTrue(sucesso);
    }
    @Test
    @Owner("Kevin Aryel")
    @Epic("Frontend")
    @Feature("Colaborador")
    @Story("Criar Colaborador")
    @Description("Deve retornar erro ao tentar criar um colaborador sem nome")
    public void deveFalharCriarColaboradorSemNome(){
        fazerLoginAdm();
        entrarNaPaginaDeColaborador();
        ColaboradoresPage.clicarBotaoCriarColaborador();
        ColaboradorCreateEditPage.preencherEmail(Utils.faker.internet().emailAddress());
        selecionarCheckBoxAleatoria();
        ColaboradorCreateEditPage.clicarBotaoEnviar();
        ColaboradorCreateEditPage.checarErroNome("nome");
    }
    @Test
    @Owner("Kevin Aryel")
    @Epic("Frontend")
    @Feature("Colaborador")
    @Story("Criar Colaborador")
    @Description("Deve retornar erro ao tentar criar um colaborador sem email")
    public void deveFalharCriarColaboradorSemEmail(){
        fazerLoginAdm();
        entrarNaPaginaDeColaborador();
        ColaboradoresPage.clicarBotaoCriarColaborador();
        ColaboradorCreateEditPage.preencherNome(nomeValido());
        selecionarCheckBoxAleatoria();
        ColaboradorCreateEditPage.clicarBotaoEnviar();
        ColaboradorCreateEditPage.checarErroEmail();
    }
    @Test
    @Owner("Kevin Aryel")
    @Epic("Frontend")
    @Feature("Colaborador")
    @Story("Criar Colaborador")
    @Description("Deve retornar erro ao tentar criar um colaborador sem cargo")
    public void deveFalharCriarColaboradorSemCargo(){
        fazerLoginAdm();
        entrarNaPaginaDeColaborador();
        ColaboradoresPage.clicarBotaoCriarColaborador();
        ColaboradorCreateEditPage.preencherNome(nomeValido());
        ColaboradorCreateEditPage.preencherEmail(emailValido());
        ColaboradorCreateEditPage.clicarBotaoEnviar();
        boolean erro = ColaboradoresPage.validarToastErro();
        Assert.assertTrue(erro);
    }
    @Test
    @Owner("Kevin Aryel")
    @Epic("Frontend")
    @Feature("Colaborador")
    @Story("Criar Colaborador")
    @Description("Deve retornar erro ao tentar criar um colaborador com email inválido")
    public void deveFalharCriarColaboradorComEmailInvalido(){
        fazerLoginAdm();
        entrarNaPaginaDeColaborador();
        ColaboradoresPage.clicarBotaoCriarColaborador();
        ColaboradorCreateEditPage.preencherNome(nomeValido());
        ColaboradorCreateEditPage.preencherEmail(Utils.faker.internet().emailAddress());
        selecionarCheckBoxAleatoria();
        ColaboradorCreateEditPage.clicarBotaoEnviar();
        ColaboradorCreateEditPage.checarErroEmail();
    }
    @Test
    @Owner("Kevin Aryel")
    @Epic("Frontend")
    @Feature("Colaborador")
    @Story("Editar Status Colaborador")
    @Description("Deve mudar o status de um colaborador com sucesso")
    public void deveMudarStatusColaboradorComSucesso() throws InterruptedException {
        fazerLoginAdm();
        entrarNaPaginaDeColaborador();
        ColaboradoresPage.clicarBotaoStatusUltimo();
        ColaboradoresPage.validarToastSucesso();
        ColaboradoresPage.clicarBotaoStatusUltimo();
        Thread.sleep(1000);
    }
    @Test
    @Owner("Kevin Aryel")
    @Epic("Frontend")
    @Feature("Colaborador")
    @Story("Editar Colaborador")
    @Description("Deve editar um colaborador com sucesso")
    public void deveEditarNomeColaboradorComSucesso() throws InterruptedException {
        fazerLoginAdm();
        entrarNaPaginaDeColaborador();
        criarColaboradorValido();
        try {
            ColaboradoresPage.clicarBotaoEditarUltimo();
            ColaboradorCreateEditPage.preencherNome(nomeValido());
            ColaboradorCreateEditPage.clicarBotaoEnviar();
            ColaboradoresPage.validarToastSucesso();
        } finally {
            entrarNaPaginaDeColaborador();
//            ColaboradoresPage.clicarBotaoExcluirUltimo();
        }
    }
    @Test
    @Owner("Kevin Aryel")
    @Epic("Frontend")
    @Feature("Colaborador")
    @Story("Editar Colaborador")
    @Description("Deve retornar erro ao tentar editar um colaborador com sucesso")
    public void deveFalharEditarColaboradorSemNome() throws InterruptedException {
        fazerLoginAdm();
        entrarNaPaginaDeColaborador();
        criarColaboradorValido();
        try{
            ColaboradoresPage.clicarBotaoEditarUltimo();
            ColaboradorCreateEditPage.clearInputNome();
            ColaboradorCreateEditPage.clicarBotaoEnviar();
            ColaboradorCreateEditPage.checarErroNome("nome");
        } finally {
            entrarNaPaginaDeColaborador();
//            ColaboradoresPage.clicarBotaoExcluirUltimo();
        }
    }
    @Test
    @Owner("Kevin Aryel")
    @Epic("Frontend")
    @Feature("Colaborador")
    @Story("Editar Colaborador")
    @Description("Deve retornar erro ao tentar editar um colaborador sem cargo")
    public void deveFalharEditarColaboradorSemCargo() throws InterruptedException {
        fazerLoginAdm();
        entrarNaPaginaDeColaborador();
        criarColaboradorValido();
        try {
            ColaboradoresPage.clicarBotaoEditarUltimo();
            boolean admin = ColaboradorCreateEditPage.checarCheckboxAdmin();
            boolean instrutor = ColaboradorCreateEditPage.checarCheckboxInstrutor();
            boolean gestao = ColaboradorCreateEditPage.checarCheckboxGestao();
            if (admin) {
                ColaboradorCreateEditPage.clicarCheckboxAdmin();
            } if (instrutor) {
                ColaboradorCreateEditPage.clicarCheckboxInstrutor();
            } if (gestao) {
                ColaboradorCreateEditPage.clicarCheckboxGestao();
            }
            ColaboradorCreateEditPage.clicarBotaoEnviar();
            ColaboradoresPage.validarToastErro();
        } finally {
            entrarNaPaginaDeColaborador();
//            ColaboradoresPage.clicarBotaoExcluirUltimo();
        }
    }

}
