package br.com.dbccompany.chronos.testes.aceitacao.etapa;

import br.com.dbccompany.chronos.client.EdicaoClient;
import br.com.dbccompany.chronos.client.EtapaClient;
import br.com.dbccompany.chronos.dto.EdicaoDTO;
import br.com.dbccompany.chronos.dto.EtapaDTO;
import br.com.dbccompany.chronos.dto.ResponseErrorBadDTO;
import br.com.dbccompany.chronos.testes.BaseTest;
import br.com.dbccompany.chronos.utils.PreloadData;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;

public class EtapaListarPorIdTest extends BaseTest {
    @Test
    @Tag("todos")
    @Tag("etapa")
    @Owner("Kevin Aryel")
    @Epic("Backend")
    @Feature("Etapa")
    @Story("Listar Etapa por Id")
    @Description("Deve listar etapa por id com sucesso")
    public void deveListarEtapaPorIdComSucesso(){
        EdicaoDTO edicao = PreloadData.edicao();
        String idEdicao = edicao.getIdEdicao().toString();
        try {
            EtapaDTO etapa = PreloadData.etapa(idEdicao);
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
    @Owner("Kevin Aryel")
    @Epic("Backend")
    @Feature("Etapa")
    @Story("Listar Etapa por Id")
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
    @Owner("Kevin Aryel")
    @Epic("Backend")
    @Feature("Etapa")
    @Story("Listar Etapa por Id")
    @Description("Deve falhar ao listar etapa por id sem autenticação")
    public void deveFalharListarEtapaPorIdSemAutenticacao(){
            Response response = EtapaClient.listarEtapaPorId("0", false)
                    .then()
                    .log().all()
                    .extract().response();
            Assert.assertEquals(HttpStatus.SC_FORBIDDEN,response.getStatusCode());
    }
}
