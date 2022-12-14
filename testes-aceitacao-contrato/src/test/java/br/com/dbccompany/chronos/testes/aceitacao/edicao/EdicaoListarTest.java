package br.com.dbccompany.chronos.testes.aceitacao.edicao;

import br.com.dbccompany.chronos.client.EdicaoClient;
import br.com.dbccompany.chronos.dto.EdicaoListDTO;
import br.com.dbccompany.chronos.testes.BaseTest;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class EdicaoListarTest extends BaseTest {
    @Test
    @Tag("todos")
    @Tag("edicao")
    @Owner("Kevin Aryel")
    @Epic("Aceitação")
    @Feature("Edição")
    @Story("Listar Edição")
    @Description("Deve listar edições com sucesso")
    public void deveListarEdicoesComSucesso(){
        EdicaoListDTO response = EdicaoClient.listarEdicoes(true)
                .then()
                .log().all()
                .extract().as(EdicaoListDTO.class)
                ;
        Assert.assertEquals(0,response.getPagina().intValue());
    }
    @Test
    @Tag("todos")
    @Tag("edicao")
    @Owner("Kevin Aryel")
    @Epic("Aceitação")
    @Feature("Edição")
    @Story("Listar Edição")
    @Description("Deve retornar erro ao listar edições sem Auth")
    public void deveFalharListarEdicoesSemAuth(){
        Response response = EdicaoClient.listarEdicoes(false)
                .then()
                .log().all()
                .extract().response()
                ;
        Assert.assertEquals(HttpStatus.SC_FORBIDDEN,response.getStatusCode());
    }
}
