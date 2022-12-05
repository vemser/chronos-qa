package br.com.dbccompany.chronos.testes.contrato;

import br.com.dbccompany.chronos.client.ResponsavelClient;
import br.com.dbccompany.chronos.testes.BaseTest;
import io.qameta.allure.*;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.File;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

public class ResponsavelContratoTest extends BaseTest {
    @Test
    @Tag("todos")
    @Tag("contrato")
    @Owner("Kevin Aryel")
    @Epic("Contrato")
    @Feature("Responsavel")
    @Story("Listar Responsáveis")
    @Description("Deve listar os responsáveis de acordo com o schema")
    public void deveListarResponsavelDeAcordoAoSchema() {
        ResponsavelClient.listarResponsavel(true)
                .then()
                .assertThat()
                .body(matchesJsonSchema(new File("./src/jsonSchema/responsavel.json")));
    }
}
