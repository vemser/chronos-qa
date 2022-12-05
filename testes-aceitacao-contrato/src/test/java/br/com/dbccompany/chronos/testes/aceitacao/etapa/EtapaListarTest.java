package br.com.dbccompany.chronos.testes.aceitacao.etapa;

import br.com.dbccompany.chronos.client.EtapaClient;
import br.com.dbccompany.chronos.data.factory.EtapaDataFactory;
import br.com.dbccompany.chronos.dto.EtapaListDTO;
import br.com.dbccompany.chronos.model.Etapa;
import br.com.dbccompany.chronos.testes.BaseTest;
import io.qameta.allure.*;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class EtapaListarTest extends BaseTest {
    @Test
    @Tag("todos")
    @Tag("etapa")
    @Owner("Kevin Aryel")
    @Epic("Backend")
    @Feature("Etapa")
    @Story("Listar Etapa")
    @Description("Deve listar etapas com sucesso")
    public void deveListarEtapasComSucesso(){
        EtapaListDTO response = EtapaClient.listarEtapa(true)
                .then()
                .log().all()
                .extract().as(EtapaListDTO.class)
        ;
        Assert.assertEquals(0,response.getPagina().intValue());
    }
    @Test
    @Tag("todos")
    @Tag("etapa")
    @Owner("Kevin Aryel")
    @Epic("Backend")
    @Feature("Etapa")
    @Story("Listar Etapa")
    @Description("Deve falhar ao listar etapas sem Auth")
    public void deveFalharListarEtapasSemAuth(){
        EtapaClient.listarEtapa(false)
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_FORBIDDEN)
        ;
    }
}
