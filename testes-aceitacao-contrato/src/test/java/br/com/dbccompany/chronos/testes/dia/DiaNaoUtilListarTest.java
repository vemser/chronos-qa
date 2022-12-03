package br.com.dbccompany.chronos.testes.dia;

import br.com.dbccompany.chronos.client.DiaNaoUtilClient;
import br.com.dbccompany.chronos.dto.DiaNaoUtilListDTO;
import br.com.dbccompany.chronos.testes.BaseTest;
import io.qameta.allure.*;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class DiaNaoUtilListarTest extends BaseTest {

    @Test
    @Tag("todos")
    @Tag("dia-nao-util")
    @Owner("Kevin Aryel")
    @Epic("Backend")
    @Story("Dia não útil")
    @Feature("Listar dia não útil")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Deve listar todos os dias não úteis com sucesso")
    public void deveListarTodosOsDiasNaoUteisComSucesso() {
        DiaNaoUtilListDTO response = DiaNaoUtilClient.listarDiaNaoUtil(true)
                .then()
                .log().all()
                .extract().as(DiaNaoUtilListDTO.class);
        Assert.assertEquals(0, response.getPagina().intValue());
    }
    @Test
    @Tag("todos")
    @Tag("dia-nao-util")
    @Owner("Kevin Aryel")
    @Epic("Backend")
    @Story("Dia não útil")
    @Feature("Listar dia não útil")
    @Severity(SeverityLevel.MINOR)
    @Description("Deve retornar erro ao listar todos os dias não úteis sem auth")
    public void deveFalharListarTodosOsDiasNaoUteisSemAuth() {
        DiaNaoUtilClient.listarDiaNaoUtil(false)
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_FORBIDDEN);
    }
}
