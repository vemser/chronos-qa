package br.com.dbccompany.chronos.testes.area;

import br.com.dbccompany.chronos.client.AreaEnvolvidaClient;
import br.com.dbccompany.chronos.dto.AreaEnvolvidaDTO;
import br.com.dbccompany.chronos.dto.ResponseErrorBadDTO;
import br.com.dbccompany.chronos.testes.BaseTest;
import br.com.dbccompany.chronos.utils.PreloadData;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class AreaEnvolvidaDeleteTest extends BaseTest {
    @Test
    @Tag("todos")
    @Tag("area-envolvida")
    @Owner("Kevin Aryel")
    @Epic("Backend")
    @Story("Area Envolvida")
    @Feature("Deletar Area Envolvida")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Deve deletar uma área envolvida com sucesso")
    public void deletarAreaEnvolvidaComSucesso() {
        AreaEnvolvidaDTO areaEnvolvida = PreloadData.areaEnvolvida();
        String idAreaEnvolvida = areaEnvolvida.getIdAreaEnvolvida().toString();
        Response response = AreaEnvolvidaClient.deletarAreaEnvolvida(idAreaEnvolvida, true)
                .then()
                .log().all()
                .extract().response();
        Assert.assertEquals(HttpStatus.SC_NO_CONTENT, response.getStatusCode());
    }
    @Test
    @Tag("todos")
    @Tag("area-envolvida")
    @Owner("Kevin Aryel")
    @Epic("Backend")
    @Story("Area Envolvida")
    @Feature("Deletar Area Envolvida")
    @Severity(SeverityLevel.MINOR)
    @Description("Deve retornar erro ao deletar uma área envolvida sem auth")
    public void deletarAreaEnvolvidaSemAuth() {
        Response response = AreaEnvolvidaClient.deletarAreaEnvolvida("0", false)
                .then()
                .log().all()
                .extract().response();
        Assert.assertEquals(HttpStatus.SC_FORBIDDEN, response.getStatusCode());
    }
    @Test
    @Tag("todos")
    @Tag("area-envolvida")
    @Severity(SeverityLevel.MINOR)
    @Description("Deve retornar erro ao deletar uma área envolvida com id inválido")
    public void deletarAreaEnvolvidaComIdInvalido() {
        ResponseErrorBadDTO response = AreaEnvolvidaClient.deletarAreaEnvolvida("0", true)
                .then()
                .log().all()
                .extract().as(ResponseErrorBadDTO.class);
        Assert.assertEquals(HttpStatus.SC_BAD_REQUEST, response.getStatus().intValue());
    }
}
