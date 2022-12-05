package br.com.dbccompany.chronos.testes.contrato;

import br.com.dbccompany.chronos.client.EdicaoClient;
import io.qameta.allure.*;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.File;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

public class EdicaoContratoTest {
    @Test
    @Tag("todos")
    @Tag("contrato")
    @Owner("Kevin Aryel")
    @Epic("Contrato")
    @Feature("Edição")
    @Story("Listar Edição")
    @Description("Deve listar as edições de acordo com o schema")
    public void deveListarEdicoesDeAcordoAoSchema() {
        EdicaoClient.listarEdicoes(true)
                .then()
                .assertThat()
                .body(matchesJsonSchema(new File("./src/jsonSchema/edicaoSemEtapa.json")));
    }
}
