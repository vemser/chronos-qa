package br.com.dbccompany.chronos.testes.contrato;

import br.com.dbccompany.chronos.client.AreaEnvolvidaClient;
import br.com.dbccompany.chronos.testes.BaseTest;
import io.qameta.allure.*;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.File;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

public class AreaEnvolvidaContratoTest extends BaseTest {
    //@Test
    @Tag("todos")
    @Tag("contrato")
    @Owner("Kevin Aryel")
    @Epic("Contrato")
    @Feature("Area Envolvida")
    @Story("Listar Areas Envolvidas")
    @Description("Deve listar as áreas envolvidas de acordo com o schema")
    public void deveListarAreaEnvolvidaComSucesso() {
        AreaEnvolvidaClient.listarAreaEnvolvida(true)
                .then()
                .assertThat()
                .body(matchesJsonSchema(new File("./src/jsonSchema/areaEnvolvida.json")));
    }
}
