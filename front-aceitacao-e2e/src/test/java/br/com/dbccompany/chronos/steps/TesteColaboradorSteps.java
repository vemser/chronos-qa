package br.com.dbccompany.chronos.steps;

import br.com.dbccompany.chronos.pages.AdminPage;
import br.com.dbccompany.chronos.pages.ColaboradorCreateEditPage;
import br.com.dbccompany.chronos.pages.ColaboradoresPage;
import br.com.dbccompany.chronos.utils.Utils;
import org.junit.Test;

public class TesteColaboradorSteps extends BaseSteps {
    public static void entrarNaPaginaDeColaborador(){
        AdminPage.clicarBotaoColaboradores();
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
        ColaboradorCreateEditPage.preencherNome(Utils.faker.name().fullName().replaceAll("[^A-Za-z]", ""));
        ColaboradorCreateEditPage.preencherEmail(Utils.faker.internet().emailAddress());
        selecionarCheckBoxAleatoria();
        ColaboradorCreateEditPage.clicarBotaoEnviar();
    }

    @Test
    public void deveCriarColaboradorValido() throws InterruptedException {
        fazerLoginAdm();
        entrarNaPaginaDeColaborador();
        criarColaboradorValido();
        ColaboradoresPage.validarToastSucesso();
        ColaboradoresPage.clicarBotaoExcluirUltimo();
    }
    @Test
    public void deveCriarColaboradorComCargoDuplo() throws InterruptedException {
        fazerLoginAdm();
        entrarNaPaginaDeColaborador();
        ColaboradoresPage.clicarBotaoCriarColaborador();
        ColaboradorCreateEditPage.preencherNome(Utils.faker.name().firstName().replaceAll("[^A-Za-z]", ""));
        ColaboradorCreateEditPage.preencherEmail(Utils.faker.internet().emailAddress());
        ColaboradorCreateEditPage.clicarCheckboxAdmin();
        ColaboradorCreateEditPage.clicarCheckboxInstrutor();
        ColaboradorCreateEditPage.clicarBotaoEnviar();
        ColaboradoresPage.validarToastSucesso();
        ColaboradoresPage.clicarBotaoExcluirUltimo();
    }
    @Test
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
    public void deveFalharCriarColaboradorSemEmail(){
        fazerLoginAdm();
        entrarNaPaginaDeColaborador();
        ColaboradoresPage.clicarBotaoCriarColaborador();
        ColaboradorCreateEditPage.preencherNome(Utils.faker.name().firstName().replaceAll("[^A-Za-z]", ""));
        selecionarCheckBoxAleatoria();
        ColaboradorCreateEditPage.clicarBotaoEnviar();
        ColaboradorCreateEditPage.checarErroEmail("email");
    }
    @Test
    public void deveFalharCriarColaboradorSemCargo(){
        fazerLoginAdm();
        entrarNaPaginaDeColaborador();
        ColaboradoresPage.clicarBotaoCriarColaborador();
        ColaboradorCreateEditPage.preencherNome(Utils.faker.name().firstName().replaceAll("[^A-Za-z]", ""));
        ColaboradorCreateEditPage.preencherEmail(Utils.faker.internet().emailAddress());
        ColaboradorCreateEditPage.clicarBotaoEnviar();
        ColaboradoresPage.validarToastErro();
    }
    @Test
    public void deveFalharCriarColaboradorComEmailInvalido(){
        fazerLoginAdm();
        entrarNaPaginaDeColaborador();
        ColaboradoresPage.clicarBotaoCriarColaborador();
        ColaboradorCreateEditPage.preencherNome(Utils.faker.name().firstName().replaceAll("[^A-Za-z]", ""));
        ColaboradorCreateEditPage.preencherEmail(Utils.faker.name().firstName().replaceAll("[^A-Za-z]", ""));
        selecionarCheckBoxAleatoria();
        ColaboradorCreateEditPage.clicarBotaoEnviar();
        ColaboradorCreateEditPage.checarErroEmail("email");
    }
    @Test
    public void deveMudarStatusColaboradorComSucesso() throws InterruptedException {
        fazerLoginAdm();
        entrarNaPaginaDeColaborador();
        ColaboradoresPage.clicarBotaoStatusUltimo();
        ColaboradoresPage.validarToastSucesso();
        ColaboradoresPage.clicarBotaoStatusUltimo();
    }
    @Test
    public void deveEditarColaboradorComSucesso() throws InterruptedException {
        fazerLoginAdm();
        entrarNaPaginaDeColaborador();
        criarColaboradorValido();
        ColaboradoresPage.clicarBotaoEditarUltimo();
        ColaboradorCreateEditPage.preencherNome(Utils.faker.name().firstName().replaceAll("[^A-Za-z]", ""));
        ColaboradorCreateEditPage.preencherEmail(Utils.faker.internet().emailAddress());
        selecionarCheckBoxAleatoria();
        ColaboradorCreateEditPage.clicarBotaoEnviar();
        ColaboradoresPage.validarToastSucesso();
    }
    @Test
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
            ColaboradoresPage.clicarBotaoExcluirUltimo();
        }
    }
    @Test
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
            ColaboradoresPage.clicarBotaoExcluirUltimo();
        }
    }

}
