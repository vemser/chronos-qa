package br.com.dbccompany.chronos.testes.edicao;

import br.com.dbccompany.chronos.client.EdicaoClient;
import br.com.dbccompany.chronos.data.factory.EdicaoDataFactory;
import br.com.dbccompany.chronos.dto.EdicaoDTO;
import br.com.dbccompany.chronos.dto.ResponseErrorBadDTO;
import br.com.dbccompany.chronos.model.Edicao;
import br.com.dbccompany.chronos.testes.BaseTest;
import br.com.dbccompany.chronos.utils.Utils;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class EdicaoCreateTest extends BaseTest {
    @Test
    @Tag("todos")
    @Tag("edicao")
    @Owner("Kevin Aryel")
    @Epic("Backend")
    @Story("Edição")
    @Feature("Criar Edição")
    @Description("Deve criar uma edição com sucesso")
    public void deveCriarUmaEdicaoComSucesso() {
        Edicao edicao = EdicaoDataFactory.edicaoValida();
        EdicaoDTO response = EdicaoClient.cadastrarEdicao(Utils.converterParaJson(edicao),true)
            .then()
            .log().all()
            .extract().as(EdicaoDTO.class);
        try{
            Assert.assertEquals(response.getNome(), edicao.getNome());
        } finally{
            EdicaoClient.deletarEdicao(response.getIdEdicao().toString(),true);
        }
    }

    @Test
    @Tag("todos")
    @Tag("edicao")
    @Owner("Kevin Aryel")
    @Epic("Backend")
    @Story("Edição")
    @Feature("Criar Edição")
    @Description("Deve retornar erro ao criar uma edição sem auth")
    public void deveFalharAoCriarUmaEdicaoSemAuth() {
        Edicao edicao = EdicaoDataFactory.edicaoValida();
        Response response = EdicaoClient.cadastrarEdicao(Utils.converterParaJson(edicao),false)
            .then()
            .log().all()
            .extract().response();
        Assert.assertEquals(HttpStatus.SC_FORBIDDEN, response.statusCode());
    }

    @Test
    @Tag("todos")
    @Tag("edicao")
    @Owner("Kevin Aryel")
    @Epic("Backend")
    @Story("Edição")
    @Feature("Criar Edição")
    @Description("Deve retornar erro ao criar uma edição sem nome")
    public void deveFalharAoCriarUmaEdicaoSemNome() {
        Edicao edicao = EdicaoDataFactory.edicaoSemNome();
        ResponseErrorBadDTO response = EdicaoClient.cadastrarEdicao(Utils.converterParaJson(edicao),true)
            .then()
            .log().all()
            .extract().as(ResponseErrorBadDTO.class);
        Assert.assertEquals(HttpStatus.SC_BAD_REQUEST, response.getStatus().intValue());
    }

    @Test
    @Tag("todos")
    @Tag("edicao")
    @Owner("Kevin Aryel")
    @Epic("Backend")
    @Story("Edição")
    @Feature("Criar Edição")
    @Description("Deve retornar erro ao criar uma edição sem dataInicial")
    public void deveFalharAoCriarUmaEdicaoSemDataInicial() {
        Edicao edicao = EdicaoDataFactory.edicaoSemDataInicial();
        ResponseErrorBadDTO response = EdicaoClient.cadastrarEdicao(Utils.converterParaJson(edicao),true)
            .then()
            .log().all()
            .extract().as(ResponseErrorBadDTO.class);
        Assert.assertEquals(HttpStatus.SC_BAD_REQUEST, response.getStatus().intValue());
    }
    @Test
    @Tag("todos")
    @Tag("edicao")
    @Owner("Kevin Aryel")
    @Epic("Backend")
    @Story("Edição")
    @Feature("Criar Edição")
    @Description("Deve retornar erro ao criar uma edição sem dataFinal")
    public void deveFalharAoCriarUmaEdicaoSemDataFinal() {
        Edicao edicao = EdicaoDataFactory.edicaoSemDataFinal();
        ResponseErrorBadDTO response = EdicaoClient.cadastrarEdicao(Utils.converterParaJson(edicao),true)
            .then()
            .log().all()
            .extract().as(ResponseErrorBadDTO.class);
        Assert.assertEquals(HttpStatus.SC_BAD_REQUEST, response.getStatus().intValue());
    }

    @Test
    @Tag("todos")
    @Tag("edicao")
    @Owner("Kevin Aryel")
    @Epic("Backend")
    @Story("Edição")
    @Feature("Criar Edição")
    @Description("Deve retornar erro ao criar uma edição com dataFinal menor que Inicial")
    public void deveFalharAoCriarUmaEdicaoComDataInicialMaiorQueDataFinal() {
        Edicao edicao = EdicaoDataFactory.edicaoComDataFinalMenorQueDataInicial();
        ResponseErrorBadDTO response = EdicaoClient.cadastrarEdicao(Utils.converterParaJson(edicao),true)
            .then()
            .log().all()
            .extract().as(ResponseErrorBadDTO.class);
        Assert.assertEquals(HttpStatus.SC_BAD_REQUEST, response.getStatus().intValue());
    }

    @Test
    @Tag("todos")
    @Tag("edicao")
    @Owner("Kevin Aryel")
    @Epic("Backend")
    @Story("Edição")
    @Feature("Criar Edição")
    @Description("Deve retornar erro ao criar uma edição com dataFinal igual a Inicial")
    public void deveFalharAoCriarUmaEdicaoComDataInicialIgualADataFinal() {
        Edicao edicao = EdicaoDataFactory.edicaoComDataFinalIgualADataInicial();
        ResponseErrorBadDTO response = EdicaoClient.cadastrarEdicao(Utils.converterParaJson(edicao),true)
            .then()
            .log().all()
            .extract().as(ResponseErrorBadDTO.class);
        Assert.assertEquals(HttpStatus.SC_BAD_REQUEST, response.getStatus().intValue());
    }

    @Test
    @Tag("todos")
    @Tag("edicao")
    @Owner("Kevin Aryel")
    @Epic("Backend")
    @Story("Edição")
    @Feature("Criar Edição")
    @Description("Deve retornar erro ao criar uma edição com dataInicial no formato invalido")
    public void deveFalharAoCriarUmaEdicaoComDataInicialNoFormatoInvalido() {
        Edicao edicao = EdicaoDataFactory.edicaoComDataInicialFormatoInvalido();
        Response response = EdicaoClient.cadastrarEdicao(Utils.converterParaJson(edicao),true)
                .then()
                .log().all()
                .extract().response();
        Assert.assertEquals(HttpStatus.SC_BAD_REQUEST,response.statusCode());
    }
    @Test
    @Tag("todos")
    @Tag("edicao")
    @Owner("Kevin Aryel")
    @Epic("Backend")
    @Story("Edição")
    @Feature("Criar Edição")
    @Description("Deve retornar erro ao criar uma edição com dataFinal no formato invalido")
    public void deveFalharAoCriarUmaEdicaoComDataFinalNoFormatoInvalido() {
        Edicao edicao = EdicaoDataFactory.edicaoComDataFinalFormatoInvalido();
        Response response = EdicaoClient.cadastrarEdicao(Utils.converterParaJson(edicao),true)
            .then()
            .log().all()
            .extract().response();
        Assert.assertEquals(HttpStatus.SC_BAD_REQUEST, response.statusCode() );
    }
    @Test
    @Tag("todos")
    @Tag("edicao")
    @Owner("Kevin Aryel")
    @Epic("Backend")
    @Story("Edição")
    @Feature("Criar Edição")
    @Description("Deve retornar erro ao criar uma edição com dataInicial com tipo inválido")
    public void deveFalharAoCriarUmaEdicaoComDataInicialComTipoInvalido() {
        Edicao edicao = EdicaoDataFactory.edicaoComDataInicialTipoInvalido();
        Response response = EdicaoClient.cadastrarEdicao(Utils.converterParaJson(edicao),true)
            .then()
            .log().all()
            .extract().response();
        Assert.assertEquals(HttpStatus.SC_BAD_REQUEST, response.statusCode());
    }
    @Test
    @Tag("todos")
    @Tag("edicao")
    @Owner("Kevin Aryel")
    @Epic("Backend")
    @Story("Edição")
    @Feature("Criar Edição")
    @Description("Deve retornar erro ao criar uma edição com dataFinal com tipo inválido")
    public void deveFalharAoCriarUmaEdicaoComDataFinalComTipoInvalido() {
        Edicao edicao = EdicaoDataFactory.edicaoComDataFinalTipoInvalido();
        Response response = EdicaoClient.cadastrarEdicao(Utils.converterParaJson(edicao),true)
            .then()
            .log().all()
            .extract().response();
        Assert.assertEquals(HttpStatus.SC_BAD_REQUEST, response.statusCode());
    }
}
