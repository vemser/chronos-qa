package br.com.dbccompany.chronos.testes.aceitacao.edicao;

import br.com.dbccompany.chronos.client.EdicaoClient;
import br.com.dbccompany.chronos.dto.CalendarioGeralItemDTO;
import br.com.dbccompany.chronos.testes.BaseTest;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class EdicaoCalendarioGeralTest extends BaseTest {

    @Test
    @Tag("todos")
    @Tag("edicao")
    @Owner("Kevin Aryel")
    @Epic("Aceitação")
    @Feature("Calendário")
    @Story("Listar Calendario Geral Edição")
    @Description("Deve listar calendario geral da edição com sucesso")
    public void deveListarCalendarioGeralDaEdicaoComSucesso(){
        CalendarioGeralItemDTO[] response = EdicaoClient.listarCalendarioGeral(true)
            .then()
                .log().all()
                .statusCode(200)
                .extract().as(CalendarioGeralItemDTO[].class)
            ;
    }
    @Test
    @Tag("todos")
    @Tag("edicao")
    @Owner("Kevin Aryel")
    @Epic("Aceitação")
    @Feature("Calendário")
    @Story("Listar Calendario Geral Edição")
    @Description("Deve falhar listar calendario geral da edição sem auth")
    public void deveFalharListarCalendarioGeralDaEdicaoSemAuth(){
        Response response = EdicaoClient.listarCalendarioGeral(false)
            .then()
                .log().all()
                .extract().response()
            ;
        Assert.assertEquals(HttpStatus.SC_FORBIDDEN,response.getStatusCode());
    }

}
