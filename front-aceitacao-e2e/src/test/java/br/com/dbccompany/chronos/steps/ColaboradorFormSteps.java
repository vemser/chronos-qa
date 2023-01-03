package br.com.dbccompany.chronos.steps;

import br.com.dbccompany.chronos.pages.ColaboradorFormPage;
import br.com.dbccompany.chronos.pages.ColaboradoresPage;
import br.com.dbccompany.chronos.utils.Utils;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class ColaboradorFormSteps {
    private static void selecionarCheckBoxAleatoria(){
        Integer checkBox = Utils.faker.number().numberBetween(1,3);
        switch (checkBox){
            case 1:
                ColaboradorFormPage.clicarCheckboxAdmin();
                break;
            case 2:
                ColaboradorFormPage.clicarCheckboxGestao();
                break;
            case 3:
                ColaboradorFormPage.clicarCheckboxInstrutor();
                break;
        }
    }
    private static void limparCheckbox(){
        boolean admin = ColaboradorFormPage.checarCheckboxAdmin();
        boolean instrutor = ColaboradorFormPage.checarCheckboxInstrutor();
        boolean gestao = ColaboradorFormPage.checarCheckboxGestao();
        if (admin) {
            ColaboradorFormPage.clicarCheckboxAdmin();
        }
        if (instrutor) {
            ColaboradorFormPage.clicarCheckboxInstrutor();
        } if (gestao) {
            ColaboradorFormPage.clicarCheckboxGestao();
        }
    }

    @E ("crie um colaborador valido")
    public void criarColaboradorValido(){
        preencherLoginColaboradorValido();
        selecionarCheckBoxAleatoria();
        clicarBtnEnviarColaborador();
    }
    @E("preencho o campo login do colaborador com um login valido")
    public void preencherLoginColaboradorValido(){
        String login = "test."+ Utils.faker.name().firstName().toLowerCase().replaceAll("[^a-z]", "");
        ColaboradorFormPage.preencherLogin(login);
    }
    @E("seleciono um cargo do colaborador")
    public void selecionarCargoAleatorioColaborador(){
        selecionarCheckBoxAleatoria();
    }
    @E ("seleciono mais de um cargo do colaborador")
    public void selecionarMaisDeUmCargoColaborador(){
        ColaboradorFormPage.clicarCheckboxAdmin();
        ColaboradorFormPage.clicarCheckboxInstrutor();
    }
    @E("altere seu cargo")
    public void alterarCargo(){
        ColaboradorFormPage.clicarCheckboxGestor();
    }
    @E("limpe os cargos")
    public void limparCargos(){
        limparCheckbox();
    }
    @Quando ("clico no botao de enviar colaborador")
    public void clicarBtnEnviarColaborador(){
        ColaboradorFormPage.clicarBotaoEnviar();
    }
    @Entao("devo ver um toast de sucesso de criacao de colaborador")
    public void checarToastSucessoCriarColaborador(){
        ColaboradoresPage.validarToast("Usuário criado com sucesso!");
    }
    @Entao("devo ver um toast de erro no cargo do colaborador")
    public void checarToastErroCriarColaboradorCargo(){
        ColaboradoresPage.validarToast("não deve estar vazio");
    }
    @Entao("devo ver uma mensagem de erro no login do colaborador")
    public void checarMensagemErroLogin(){
        ColaboradorFormPage.checarErroLogin();
    }
    @Entao("devo ver um toast de sucesso de edicao de colaborador")
    public void checarToastSucessoEditarColaborador(){
        ColaboradoresPage.validarToast("Usuário editado com sucesso");
    }
}
