package br.com.dbccompany.chronos.steps;

import br.com.dbccompany.chronos.pages.ProcessoFormPage;
import br.com.dbccompany.chronos.utils.Utils;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class ProcessoFormSteps {
    @E("preencha um nome de processo valido")
    public void preencherNomeProcesso(){
        ProcessoFormPage.preencherNome("Teste");
    }
    @E("preencha uma area envovlvida")
    public void preencherAreaEnvolvidaProcesso(){
        ProcessoFormPage.preencherAreaEnvolvida("teste");
    }
    @E("preencha um responsavel")
    public void preencherResponsavelProcesso(){
        ProcessoFormPage.preencherResponsavel("teste");
    }
    @E("preencha uma duracao de processo")
    public void preencherDuracaoProceso(){
        ProcessoFormPage.preencherDuracao("Teste Duração");
    }
    @E("preencha dias uteis de processo")
    public void preencherDiasUteisProcesso(){
        ProcessoFormPage.preencherDiasUteis(Utils.faker.number().digits(2));
    }
    @E("preencha ordem de processo")
    public void preencherOrdemProcesso(){
        ProcessoFormPage.preencherOrdem(Utils.faker.number().digits(2));
    }
    @E("marque a opcao de processo critico")
    public void marcarCheckboxProcessoCritico(){
        ProcessoFormPage.marcarCheckboxProcessoCritico();
    }
    @E("crie um processo valido")
    public void criarProcessoValido(){
        preencherNomeProcesso();
        preencherResponsavelProcesso();
        preencherAreaEnvolvidaProcesso();
        preencherDuracaoProceso();
        preencherDiasUteisProcesso();
        preencherOrdemProcesso();
        clicarBtnEnviarProcesso();
    }
    @Quando("clico em enviar processo")
    public void clicarBtnEnviarProcesso(){
        ProcessoFormPage.clicarBotaoSubmit();
    }
    @Entao("devo ver um toast de sucesso de criacao de processo")
    public void validarToastSucessoCriarProcesso(){
        ProcessoFormPage.validarToast("Processo cadastrado com sucesso");
    }
    @Entao("devo ver uma mensagem de sucesso de edicao de processo0")
    public void validarToastSucessoEditarProcesso(){
        ProcessoFormPage.validarToast("Processo Editado com sucesso");
    }
}
