package br.com.dbccompany.chronos.testes.contrato;

import br.com.dbccompany.chronos.client.DiaNaoUtilClient;
import br.com.dbccompany.chronos.testes.BaseTest;
import io.qameta.allure.*;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.File;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

public class DiaNaoUtilContratoTest extends BaseTest {
    //@Test
    @Tag("todos")
    @Tag("contrato")
    @Owner("Kevin Aryel")
    @Epic("Contrato")
    @Feature("Dia não útil")
    @Story("Listar Dias não úteis")
    @Description("Deve listar os dias não úteis de acordo com o schema")
    public void deveListarDiaNaoUtilDeAcordoAoSchema() {
        DiaNaoUtilClient.listarDiaNaoUtil(true)
                .then()
                .assertThat()
                .body(matchesJsonSchema(new File("./src/jsonSchema/diaNaoUtil.json")));
    }
}
