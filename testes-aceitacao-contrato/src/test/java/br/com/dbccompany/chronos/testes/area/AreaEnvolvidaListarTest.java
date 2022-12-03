package br.com.dbccompany.chronos.testes.area;

import br.com.dbccompany.chronos.client.AreaEnvolvidaClient;
import br.com.dbccompany.chronos.dto.AreaEnvolvidaDTO;
import br.com.dbccompany.chronos.testes.BaseTest;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class AreaEnvolvidaListarTest extends BaseTest {

    @Test
    @Tag("todos")
    @Tag("area-envolvida")
    @Owner("Kevin Aryel")
    @Epic("Backend")
    @Feature("Area Envolvida")
    @Story("Listar Area Envolvida")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Deve listar todas as áreas envolvidas com sucesso")
    public void deveListarTodasAsAreasEnvolvidasComSucesso() {
        AreaEnvolvidaDTO[] response = AreaEnvolvidaClient.listarAreaEnvolvida(true)
                .then()
                .log().all()
                .extract().as(AreaEnvolvidaDTO[].class)
                ;
    }
    @Test
    @Tag("todos")
    @Tag("area-envolvida")
    @Owner("Kevin Aryel")
    @Epic("Backend")
    @Feature("Area Envolvida")
    @Story("Listar Area Envolvida")
    @Severity(SeverityLevel.MINOR)
    @Description("Deve retornar erro ao listar todas as áreas envolvidas sem auth")
    public void deveFalharListarTodasAsAreasEnvolvidas(){
        Response response = AreaEnvolvidaClient.listarAreaEnvolvida(false)
                .then()
                .log().all()
                .extract().response();
        Assert.assertEquals(HttpStatus.SC_FORBIDDEN, response.getStatusCode());
    }

}
