package br.com.dbccompany.chronos.steps;

import br.com.dbccompany.chronos.pages.EdicoesFormPage;
import br.com.dbccompany.chronos.pages.EdicoesPage;
import br.com.dbccompany.chronos.utils.Utils;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class EdicoesFormSteps {
    @E("preencho o nome da edicao com um nome valido")
    public void preencherNomeDaEdicao(){
        String nome =  "Teste" + Utils.faker.number().randomDigit();
        EdicoesFormPage.enviarNomeEdicao(nome);
    }
    @E("preencho a data inicial da edicao com uma data valida")
    public void preencherDataInicialEdicao(){
        EdicoesFormPage.enviarDataInicio("10102022");
    }
    @E("crie uma edicao valida")
    public void criarEdicaoValida(){
        preencherNomeDaEdicao();
        preencherDataInicialEdicao();
        clicarBtnEnviarEdicao();
    }
    @E("limpe o campo de nome da edicao")
    public void limparNomeEdicao(){
        EdicoesFormPage.limparNomeEdicao();
    }
    @E("limpe o campo de data inicial da edicao")
    public void limparDataInicialEdicao(){
        EdicoesFormPage.limparDataInicialEdicao();
    }
    @Quando("clico em enviar edicao")
    public void clicarBtnEnviarEdicao(){
        EdicoesFormPage.clicarBotaoSubmit();
    }
    @Entao("devo ver um toast de sucesso de criacao de edicao")
    public void validarToastCriarEdicao(){
        EdicoesFormPage.validarToast("Edição criada com sucesso");
    }
    @Entao("devo ver uma mensagem de erro na data inicial da edicao")
    public void validarMensagemErroDataInicial(){
        EdicoesFormPage.validarErroDataInicio();
    }
    @Entao("Devo ver um toast de sucesso de edicao de edicao")
    public void validarToastEditarEdicao(){
        EdicoesFormPage.validarToast("Edicao editada com sucesso");
    }
    @Entao("Devo ver uma mensagem de erro no nome da edicao")
    public void validarMensagemErroNomeEdicao(){
        EdicoesFormPage.validarErroNomeEdicao();
    }
}
