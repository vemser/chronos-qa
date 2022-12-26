package br.com.dbccompany.chronos.testes.contrato;

import br.com.dbccompany.chronos.client.UsuarioClient;
import br.com.dbccompany.chronos.testes.BaseTest;
import io.qameta.allure.*;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.File;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

public class CalendarioGeralContratoTest extends BaseTest {
    //@Test
    @Tag("todos")
    @Tag("contrato")
    @Owner("Kevin Aryel")
    @Epic("Contrato")
    @Feature("Calendário")
    @Story("Listar Calendário Geral")
    @Description("Deve listar os itens do calendário geral de acordo com o schema")
    public void deveListarCalendarioGeralDeAcordoAoSchema() {
        UsuarioClient.listarUsuarios(true)
                .then()
                .assertThat()
                .body(matchesJsonSchema(new File("./src/jsonSchema/usuario.json")));
    }
}
