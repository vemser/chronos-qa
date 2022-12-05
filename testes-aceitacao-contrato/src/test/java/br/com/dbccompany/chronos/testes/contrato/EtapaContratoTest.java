package br.com.dbccompany.chronos.testes.contrato;

import br.com.dbccompany.chronos.client.EtapaClient;
import br.com.dbccompany.chronos.testes.BaseTest;
import io.qameta.allure.*;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.File;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

public class EtapaContratoTest extends BaseTest {
    @Test
    @Tag("todos")
    @Tag("contrato")
    @Owner("Kevin Aryel")
    @Epic("Contrato")
    @Feature("Etapa")
    @Story("Listar Etapas")
    @Description("Deve listar as etapas de acordo com o schema")
    public void deveListarCalendarioGeralDeAcordoAoSchema() {
        EtapaClient.listarEtapa(true)
                .then()
                .assertThat()
                .body(matchesJsonSchema(new File("./src/jsonSchema/etapa.json")));
    }
}
