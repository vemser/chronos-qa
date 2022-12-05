package br.com.dbccompany.chronos.testes.aceitacao.responsavel;

import br.com.dbccompany.chronos.client.ResponsavelClient;
import br.com.dbccompany.chronos.data.factory.ResponsavelDataFactory;
import br.com.dbccompany.chronos.dto.ResponsavelDTO;
import br.com.dbccompany.chronos.dto.ResponseErrorBadDTO;
import br.com.dbccompany.chronos.model.Responsavel;
import br.com.dbccompany.chronos.testes.BaseTest;
import br.com.dbccompany.chronos.utils.Utils;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class ResponsavelCreateTest extends BaseTest {
    @Test
    @Tag("todos")
    @Tag("responsavel")
    @Owner("Kevin Aryel")
    @Epic("Backend")
    @Feature("Responsavel")
    @Story("Criar Responsavel")
    @Description("Criar um responsável com sucesso")
    public void criarResponsavelComSucesso(){
        Responsavel responsavel = ResponsavelDataFactory.responsavelValido();
        ResponsavelDTO response = ResponsavelClient.criarResponsavel(Utils.converterParaJson(responsavel), true)
                .then()
                .log().all()
                .extract().as(ResponsavelDTO.class);
        Assert.assertEquals(responsavel.getNome().toUpperCase(), response.getNome().toUpperCase());
        ResponsavelClient.deletarResponsavel(response.getIdResponsavel().toString(), true);
    }

    @Test
    @Tag("todos")
    @Tag("responsavel")
    @Owner("Kevin Aryel")
    @Epic("Backend")
    @Feature("Responsavel")
    @Story("Criar Responsavel")
    @Description("Deve falhar criar um responsável sem Auth")
    public void deveFalharCriarResponsavelSemAuth(){
        Responsavel responsavel = ResponsavelDataFactory.responsavelValido();
        Response response = ResponsavelClient.criarResponsavel(Utils.converterParaJson(responsavel), false)
                .then()
                .log().all()
                .extract().response();
        Assert.assertEquals(HttpStatus.SC_FORBIDDEN,response.getStatusCode());
    }
    @Test
    @Tag("todos")
    @Tag("responsavel")
    @Owner("Kevin Aryel")
    @Epic("Backend")
    @Feature("Responsavel")
    @Story("Criar Responsavel")
    @Description("Deve retornar um erro criar um responsável sem nome")
    public void deveFalharCriarResponsavelSemNome(){
        Responsavel responsavel = ResponsavelDataFactory.responsavelSemNome();
        ResponseErrorBadDTO response = ResponsavelClient.criarResponsavel(Utils.converterParaJson(responsavel), true)
                .then()
                .log().all()
                .extract().as(ResponseErrorBadDTO.class);
        Assert.assertEquals(HttpStatus.SC_BAD_REQUEST,response.getStatus().intValue());
    }
}
