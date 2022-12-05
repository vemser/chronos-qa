package br.com.dbccompany.chronos.testes.contrato;

import br.com.dbccompany.chronos.client.ProcessoClient;
import br.com.dbccompany.chronos.testes.BaseTest;
import io.qameta.allure.*;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.File;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

public class ProcessoContratoTest extends BaseTest {
    @Test
    @Tag("todos")
    @Tag("contrato")
    @Owner("Kevin Aryel")
    @Epic("Contrato")
    @Feature("Processo")
    @Story("Listar Processos")
    @Description("Deve listar os processos de acordo com o schema")
    public void deveListarProcessosDeAcordoAoSchema() {
        ProcessoClient.listarProcessos(true)
                .then()
                .assertThat()
                .body(matchesJsonSchema(new File("./src/jsonSchema/processo.json")));
    }
}
