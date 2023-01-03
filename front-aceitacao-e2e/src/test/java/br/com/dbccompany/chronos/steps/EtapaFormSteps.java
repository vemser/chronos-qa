package br.com.dbccompany.chronos.steps;

import br.com.dbccompany.chronos.pages.EtapaFormPage;
import br.com.dbccompany.chronos.utils.Utils;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import org.junit.Assert;

public class EtapaFormSteps {

    @E("crie uma etapa valida")
    public void criarEtapaValida(){
        preencherNomeEtapa();
        preencherOrdemEtapa();
        clicarBtnEnviarEtapa();
    }
    @E("preencha o nome da etapa com um nome valido")
    public void preencherNomeEtapa(){
        String nome = "teste" + Utils.faker.number().randomDigit();
        EtapaFormPage.preencherNome(nome);
    }
    @E("preencha a ordem da etapa com uma ordem valida")
    public void preencherOrdemEtapa(){
        EtapaFormPage.preencherOrdemExecucao(Utils.faker.number().digits(2));
    }
    @Quando("clico em enviar etapa")
    public void clicarBtnEnviarEtapa(){
        EtapaFormPage.clicarBotaoSubmitEtapa();
    }
    @Entao("devo ver um toast de sucesso de criar etapa")
    public void validarToastSucessoCriarEtapa(){
        Assert.assertTrue(EtapaFormPage.validarToast("cadastrada com sucesso"));
    }
    @Entao("devo ver uma mensagem de erro no nome da etapa")
    public void verificarMensagemErroNomeEtapa(){
        Assert.assertTrue(EtapaFormPage.validarErroNome());
    }
    @Entao("devo ver uma mensagem de erro na ordem da etapa")
    public void verificarMensagemErroOrdemEtapa(){
        Assert.assertTrue(EtapaFormPage.validarErroOrdem());
    }
    @Entao("devo ver um toast de sucesso de editar etapa")
    public void validarToastSucessoEditarEtapa(){
        Assert.assertTrue(EtapaFormPage.validarToast("editada com sucesso"));
    }
}
