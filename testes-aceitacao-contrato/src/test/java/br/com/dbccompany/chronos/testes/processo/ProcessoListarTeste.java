package br.com.dbccompany.chronos.testes.processo;

import br.com.dbccompany.chronos.client.ProcessoClient;
import br.com.dbccompany.chronos.dto.ProcessoListDTO;
import br.com.dbccompany.chronos.testes.BaseTest;
import io.qameta.allure.*;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class ProcessoListarTeste extends BaseTest {
    @Test
    @Tag("todos")
    @Tag("processo")
    @Owner("Kevin Aryel")
    @Epic("Backend")
    @Feature("Processo")
    @Story("Listar Processos")
    @Description("Deve listar todos os processos com sucesso")
    public void deveListarTodosOsProcessosComSucesso() {
        ProcessoListDTO response = ProcessoClient.listarProcessos(true)
                .then()
                .log().all()
                .extract().as(ProcessoListDTO.class);
        Assert.assertEquals(0, response.getPagina().intValue());
    }
    @Test
    @Tag("todos")
    @Tag("processo")
    @Owner("Kevin Aryel")
    @Epic("Backend")
    @Feature("Processo")
    @Story("Listar Processos")
    @Description("Deve falhar ao listar todos os processos sem auth")
    public void deveFalharAoListarTodosOsProcessosSemAuth() {
        ProcessoClient.listarProcessos(false)
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_FORBIDDEN);
    }
}
