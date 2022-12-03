package br.com.dbccompany.chronos.testes.etapa;

import br.com.dbccompany.chronos.client.EdicaoClient;
import br.com.dbccompany.chronos.client.EtapaClient;
import br.com.dbccompany.chronos.data.factory.EtapaDataFactory;
import br.com.dbccompany.chronos.data.preloadAndRestore.EdicaoPreloadData;
import br.com.dbccompany.chronos.dto.EdicaoDTO;
import br.com.dbccompany.chronos.dto.EtapaDTO;
import br.com.dbccompany.chronos.dto.ResponseErrorBadDTO;
import br.com.dbccompany.chronos.model.Etapa;
import br.com.dbccompany.chronos.testes.BaseTest;
import br.com.dbccompany.chronos.utils.Utils;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class EtapaCreateTest extends BaseTest {
    @Test
    @Tag("todos")
    @Tag("etapa")
    @Description("Deve criar etapa com sucesso")
    public void deveCriarEtapaComSucesso(){
        EdicaoDTO edicao = EdicaoPreloadData.edicaoValida();
        String idEdicao = edicao.getIdEdicao().toString();
        try{
            Etapa etapa = EtapaDataFactory.etapaValida();
            EtapaDTO response  = EtapaClient.criarEtapa(Utils.converterParaJson(etapa),idEdicao,true)
                    .then()
                    .log().all()
                    .extract().as(EtapaDTO.class);
            Assert.assertEquals(etapa.getNome(),response.getNome());
        } finally {
            EdicaoClient.deletarEdicao(idEdicao,true);
        }
    }
    @Test
    @Tag("todos")
    @Tag("etapa")
    @Description("Deve falhar ao criar etapa sem nome")
    public void deveFalharCriarEtapaSemNome(){
        EdicaoDTO edicao = EdicaoPreloadData.edicaoValida();
        String idEdicao = edicao.getIdEdicao().toString();
        try{
            Etapa etapa = EtapaDataFactory.etapaSemNome();
            ResponseErrorBadDTO response  = EtapaClient.criarEtapa(Utils.converterParaJson(etapa),idEdicao,true)
                    .then()
                    .log().all()
                    .extract().as(ResponseErrorBadDTO.class);
            Assert.assertEquals(HttpStatus.SC_BAD_REQUEST,response.getStatus().intValue());
        } finally {
            EdicaoClient.deletarEdicao(idEdicao,true);
        }
    }
    @Test
    @Tag("todos")
    @Tag("etapa")
    @Description("Deve falhar ao criar etapa sem ordem de execução")
    public void deveFalharCriarEtapaSemOrdemExecucao(){
        EdicaoDTO edicao = EdicaoPreloadData.edicaoValida();
        String idEdicao = edicao.getIdEdicao().toString();
        try{
            Etapa etapa = EtapaDataFactory.etapaSemOrdemExecucao();
            ResponseErrorBadDTO response  = EtapaClient.criarEtapa(Utils.converterParaJson(etapa),idEdicao,true)
                    .then()
                    .log().all()
                    .extract().as(ResponseErrorBadDTO.class);
            Assert.assertEquals(HttpStatus.SC_BAD_REQUEST,response.getStatus().intValue());
        } finally {
            EdicaoClient.deletarEdicao(idEdicao,true);
        }
    }

    @Test
    @Tag("todos")
    @Tag("etapa")
    @Description("Deve falhar ao criar etapa sem auth")
    public void deveFalharCriarEtapaSemAuth(){
        EdicaoDTO edicao = EdicaoPreloadData.edicaoValida();
        String idEdicao = edicao.getIdEdicao().toString();
        try{
            Etapa etapa = EtapaDataFactory.etapaValida();
            Response response  = EtapaClient.criarEtapa(Utils.converterParaJson(etapa),idEdicao,false)
                    .then()
                    .log().all()
                    .extract().response();
            Assert.assertEquals(HttpStatus.SC_FORBIDDEN,response.getStatusCode());
        } finally {
            EdicaoClient.deletarEdicao(idEdicao,true);
        }
    }
}