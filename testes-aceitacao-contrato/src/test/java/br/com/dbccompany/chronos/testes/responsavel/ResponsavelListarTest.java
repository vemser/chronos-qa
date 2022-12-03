package br.com.dbccompany.chronos.testes.responsavel;

import br.com.dbccompany.chronos.client.ResponsavelClient;
import br.com.dbccompany.chronos.dto.ResponsavelDTO;
import br.com.dbccompany.chronos.testes.BaseTest;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class ResponsavelListarTest extends BaseTest {

    @Test
    @Tag("todos")
    @Tag("responsavel")
    @Description("Deve listar todos os responsáveis com sucesso")
    public void deveListarTodosOsResponsaveisComSucesso() {
        ResponsavelDTO[] response = ResponsavelClient.listarResponsavel(true)
                .then()
                .log().all()
                .extract().as(ResponsavelDTO[].class)
                ;
    }
    @Test
    @Tag("todos")
    @Tag("responsavel")
    @Description("Deve falhar listar todos os responsáveis sem Auth")
    public void deveFalharListarTodosOsResponsaveisSemAuth() {
        Response response = ResponsavelClient.listarResponsavel(false)
            .then()
                .log().all()
                .extract().response()
            ;
        Assert.assertEquals(HttpStatus.SC_FORBIDDEN,response.getStatusCode());
    }
}
