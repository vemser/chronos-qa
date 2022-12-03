package br.com.dbccompany.chronos.testes.etapa;

import br.com.dbccompany.chronos.client.EdicaoClient;
import br.com.dbccompany.chronos.client.EtapaClient;
import br.com.dbccompany.chronos.data.preloadAndRestore.EdicaoPreloadData;
import br.com.dbccompany.chronos.data.preloadAndRestore.EtapaPreloadData;
import br.com.dbccompany.chronos.dto.EdicaoDTO;
import br.com.dbccompany.chronos.dto.EtapaDTO;
import br.com.dbccompany.chronos.dto.ResponseErrorBadDTO;
import br.com.dbccompany.chronos.testes.BaseTest;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class EtapaDeleteTest extends BaseTest {
    @Test
    @Tag("todos")
    @Tag("etapa")
    @Owner("Kevin Aryel")
    @Epic("Backend")
    @Story("Etapa")
    @Feature("Deletar Etapa")
    @Description("Deve deletar etapa com sucesso")
    public void deveDeletarEtapaComSucesso(){
        EdicaoDTO edicao = EdicaoPreloadData.edicaoValida();
        String idEdicao = edicao.getIdEdicao().toString();
        try {
            EtapaDTO etapa = EtapaPreloadData.etapaValida(idEdicao);
            String idEtapa = etapa.getIdEtapa().toString();
            Response response = EtapaClient.deletarEtapa(idEtapa, true)
                    .then()
                    .log().all()
                    .extract().response();
            Assert.assertEquals(HttpStatus.SC_NO_CONTENT, response.getStatusCode());
        } finally {
            EdicaoClient.deletarEdicao(idEdicao,true);
        }
    }

    @Test
    @Tag("todos")
    @Tag("etapa")
    @Owner("Kevin Aryel")
    @Epic("Backend")
    @Story("Etapa")
    @Feature("Deletar Etapa")
    @Description("Deve falhar ao deletar etapa sem Auth")
    public void deveFalharDeletarEtapaSemAuth(){
        Response response = EtapaClient.deletarEtapa("0", false)
                .then()
                .log().all()
                .extract().response();
        Assert.assertEquals(HttpStatus.SC_FORBIDDEN, response.getStatusCode());
    }
    @Test
    @Tag("todos")
    @Tag("etapa")
    @Owner("Kevin Aryel")
    @Epic("Backend")
    @Story("Etapa")
    @Feature("Deletar Etapa")
    @Description("Deve falhar ao deletar etapa inexistente")
    public void deveFalharDeletarEtapaInexistente(){
        ResponseErrorBadDTO response = EtapaClient.deletarEtapa("0", true)
                .then()
                .log().all()
                .extract().as(ResponseErrorBadDTO.class);
        Assert.assertEquals(HttpStatus.SC_BAD_REQUEST, response.getStatus().intValue());
    }
}
