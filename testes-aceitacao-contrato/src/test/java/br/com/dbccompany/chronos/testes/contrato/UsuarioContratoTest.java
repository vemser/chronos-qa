package br.com.dbccompany.chronos.testes.contrato;

import br.com.dbccompany.chronos.client.EdicaoClient;
import br.com.dbccompany.chronos.client.UsuarioClient;
import br.com.dbccompany.chronos.testes.BaseTest;
import io.qameta.allure.*;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.File;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

public class UsuarioContratoTest extends BaseTest {

    @Test
    @Tag("todos")
    @Tag("contrato")
    @Owner("Kevin Aryel")
    @Epic("Contrato")
    @Feature("Usuário")
    @Story("Listar Usuários")
    @Description("Deve listar os usuarios de acordo com o schema")
    public void deveListarUsuarioDeAcordoAoSchema() {
        EdicaoClient.listarCalendarioGeral(true)
                .then()
                .assertThat()
                .body(matchesJsonSchema(new File("./src/jsonSchema/calendarioGeral.json")));
    }
}
