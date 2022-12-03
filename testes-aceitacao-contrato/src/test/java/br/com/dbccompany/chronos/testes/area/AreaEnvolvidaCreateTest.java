package br.com.dbccompany.chronos.testes.area;

import br.com.dbccompany.chronos.client.AreaEnvolvidaClient;
import br.com.dbccompany.chronos.data.factory.AreaEnvolvidaDataFactory;
import br.com.dbccompany.chronos.dto.AreaEnvolvidaDTO;
import br.com.dbccompany.chronos.dto.ResponseErrorBadDTO;
import br.com.dbccompany.chronos.model.AreaEnvolvida;
import br.com.dbccompany.chronos.testes.BaseTest;
import br.com.dbccompany.chronos.utils.Utils;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class AreaEnvolvidaCreateTest extends BaseTest {
    @Test
    @Tag("todos")
    @Tag("area-envolvida")
    @Owner("Kevin Aryel")
    @Epic("Backend")
    @Story("Area Envolvida")
    @Feature("Criar Area Envolvida")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Criar uma área envolvida com sucesso")
    public void criarAreaEnvolvidaComSucesso() {
        AreaEnvolvida areaEnvolvida = AreaEnvolvidaDataFactory.areaEnvolvidaValida();
        AreaEnvolvidaDTO response = AreaEnvolvidaClient.criarAreaEnvolvida(Utils.converterParaJson(areaEnvolvida), true)
                .then()
                .log().all()
                .extract().as(AreaEnvolvidaDTO.class);
        Assert.assertEquals(areaEnvolvida.getNome().toUpperCase(), response.getNome().toUpperCase());
        AreaEnvolvidaClient.deletarAreaEnvolvida(response.getIdAreaEnvolvida().toString(), true);
    }
    @Test
    @Tag("todos")
    @Tag("area-envolvida")
    @Owner("Kevin Aryel")
    @Epic("Backend")
    @Story("Area Envolvida")
    @Feature("Criar Area Envolvida")
    @Severity(SeverityLevel.NORMAL)
    @Description("Deve falhar criar uma área envolvida sem auth")
    public void criarAreaEnvolvidaSemAuth() {
        AreaEnvolvida areaEnvolvida = AreaEnvolvidaDataFactory.areaEnvolvidaValida();
        Response response = AreaEnvolvidaClient.criarAreaEnvolvida(Utils.converterParaJson(areaEnvolvida), false)
                .then()
                .log().all()
                .extract().response();
        Assert.assertEquals(HttpStatus.SC_FORBIDDEN, response.getStatusCode());
    }
    @Test
    @Tag("todos")
    @Tag("area-envolvida")
    @Owner("Kevin Aryel")
    @Epic("Backend")
    @Story("Area Envolvida")
    @Feature("Criar Area Envolvida")
    @Severity(SeverityLevel.MINOR)
    @Description("Deve falhar criar uma área envolvida sem nome")
    public void criarAreaEnvolvidaSemNome() {
        AreaEnvolvida areaEnvolvida = AreaEnvolvidaDataFactory.areaEnvolvidaSemNome();
        ResponseErrorBadDTO response = AreaEnvolvidaClient.criarAreaEnvolvida(Utils.converterParaJson(areaEnvolvida), true)
                .then()
                .log().all()
                .extract().as(ResponseErrorBadDTO.class);
        Assert.assertEquals(HttpStatus.SC_BAD_REQUEST, response.getStatus().intValue());
    }

}
