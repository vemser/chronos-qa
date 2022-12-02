package br.com.dbccompany.chronos.testes.etapa;

import br.com.dbccompany.chronos.client.EdicaoClient;
import br.com.dbccompany.chronos.client.EtapaClient;
import br.com.dbccompany.chronos.data.preloadAndRestore.EdicaoPreloadData;
import br.com.dbccompany.chronos.data.preloadAndRestore.EtapaPreloadData;
import br.com.dbccompany.chronos.dto.EdicaoDTO;
import br.com.dbccompany.chronos.dto.EtapaDTO;
import br.com.dbccompany.chronos.dto.ResponseErrorBadDTO;
import br.com.dbccompany.chronos.testes.BaseTest;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertAll;

public class EtapaListarPorIdTest extends BaseTest {
    @Test
    @Tag("todos")
    @Tag("etapa")
    @Description("Deve listar etapa por id com sucesso")
    public void deveListarEtapaPorIdComSucesso(){
        EdicaoDTO edicao = EdicaoPreloadData.edicaoValida();
        String idEdicao = edicao.getIdEdicao().toString();
        try {
            EtapaDTO etapa = EtapaPreloadData.etapaValida(idEdicao);
            EtapaDTO[] response = EtapaClient.listarEtapaPorId(idEdicao, true)
                    .then()
                    .log().all()
                    .extract().as(EtapaDTO[].class);
            assertAll(
                    () -> Assert.assertEquals(etapa.getIdEtapa(), response[0].getIdEtapa()),
                    ()-> Assert.assertEquals(etapa.getNome(),response[0].getNome())
            );
        } finally {
            EdicaoClient.deletarEdicao(idEdicao, true);
        }
    }
    @Test
    @Tag("todos")
    @Tag("etapa")
    @Description("Deve falhar ao listar etapa por id inexistente")
    public void deveFalharListarEtapaPorIdInexistente(){
        ResponseErrorBadDTO response = EtapaClient.listarEtapaPorId("0", true)
                .then()
                .log().all()
                .extract().as(ResponseErrorBadDTO.class);
        Assert.assertEquals(HttpStatus.SC_BAD_REQUEST,response.getStatus().intValue());
    }
    @Test
    @Tag("todos")
    @Tag("etapa")
    @Description("Deve falhar ao listar etapa por id sem autenticação")
    public void deveFalharListarEtapaPorIdSemAutenticacao(){
            Response response = EtapaClient.listarEtapaPorId("0", false)
                    .then()
                    .log().all()
                    .extract().response();
            Assert.assertEquals(HttpStatus.SC_FORBIDDEN,response.getStatusCode());
    }
}
