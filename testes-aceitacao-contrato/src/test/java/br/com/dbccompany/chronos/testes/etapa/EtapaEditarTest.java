package br.com.dbccompany.chronos.testes.etapa;

import br.com.dbccompany.chronos.client.EdicaoClient;
import br.com.dbccompany.chronos.client.EtapaClient;
import br.com.dbccompany.chronos.data.factory.EtapaDataFactory;
import br.com.dbccompany.chronos.data.preloadAndRestore.EdicaoPreloadData;
import br.com.dbccompany.chronos.data.preloadAndRestore.EtapaPreloadData;
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

public class EtapaEditarTest extends BaseTest {

    @Test
    @Tag("todos")
    @Tag("etapa")
    @Description("Deve editar uma etapa com sucesso")
    public void deveEditarEtapaComSucesso(){
        EdicaoDTO edicao = EdicaoPreloadData.edicaoValida();
        String idEdicao = edicao.getIdEdicao().toString();
        try{
            EtapaDTO etapa = EtapaPreloadData.etapaValida(idEdicao);
            String idEtapa = etapa.getIdEtapa().toString();
            Etapa etapaEditar = EtapaDataFactory.etapaValida();
            EtapaDTO response = EtapaClient.atualizarEtapa(Utils.converterParaJson(etapaEditar),idEtapa,true)
                    .then()
                    .log().all()
                    .extract().as(EtapaDTO.class)
           ;
            Assert.assertEquals(etapaEditar.getNome(),response.getNome());
        }finally {
            EdicaoClient.deletarEdicao(idEdicao,true);
        }
    }

    @Test
    @Tag("todos")
    @Tag("etapa")
    @Description("Deve falhar ao editar uma etapa sem Auth")
    public void deveFalharEditarEtapaSemAuth(){
        Etapa etapa = EtapaDataFactory.etapaValida();
        Response response = EtapaClient.atualizarEtapa(Utils.converterParaJson(etapa),"1",false)
                .then()
                .log().all()
                .extract().response();
        Assert.assertEquals(HttpStatus.SC_FORBIDDEN,response.getStatusCode());
    }
    @Test
    @Tag("todos")
    @Tag("etapa")
    @Description("Deve falhar ao editar uma etapa com id inválido")
    public void deveFalharEditarEtapaComIdInvalido(){
        Etapa etapa = EtapaDataFactory.etapaValida();
        ResponseErrorBadDTO response = EtapaClient.atualizarEtapa(Utils.converterParaJson(etapa),"0",true)
                .then()
                .log().all()
                .extract().as(ResponseErrorBadDTO.class);
        Assert.assertEquals(HttpStatus.SC_BAD_REQUEST,response.getStatus().intValue());
    }
    @Test
    @Tag("todos")
    @Tag("etapa")
    @Description("Deve falhar ao editar uma etapa sem nome")
    public void deveFalharEditarEtapaSemNome(){
        EdicaoDTO edicao = EdicaoPreloadData.edicaoValida();
        String idEdicao = edicao.getIdEdicao().toString();
        try {
            EtapaDTO etapa = EtapaPreloadData.etapaValida(idEdicao);
            String idEtapa = etapa.getIdEtapa().toString();
            Etapa etapaEditar = EtapaDataFactory.etapaSemNome();
            Response response = EtapaClient.atualizarEtapa(Utils.converterParaJson(etapaEditar), idEtapa, true)
                    .then()
                    .log().all()
                    .extract().response();
            Assert.assertEquals(HttpStatus.SC_BAD_REQUEST, response.getStatusCode());
        } finally {
            EdicaoClient.deletarEdicao(idEdicao,true);
        }
    }

    @Test
    @Tag("todos")
    @Tag("etapa")
    @Description("Deve falhar ao editar uma etapa sem ordemExecucao")
    public void deveFalharEditarEtapaSemOrdemExecucao(){
        EdicaoDTO edicao = EdicaoPreloadData.edicaoValida();
        String idEdicao = edicao.getIdEdicao().toString();
        try {
            EtapaDTO etapa = EtapaPreloadData.etapaValida(idEdicao);
            String idEtapa = etapa.getIdEtapa().toString();
            Etapa etapaEditar = EtapaDataFactory.etapaSemOrdemExecucao();
            Response response = EtapaClient.atualizarEtapa(Utils.converterParaJson(etapaEditar), idEtapa, true)
                    .then()
                    .log().all()
                    .extract().response();
            Assert.assertEquals(HttpStatus.SC_BAD_REQUEST, response.getStatusCode());
        } finally {
            EdicaoClient.deletarEdicao(idEdicao,true);
        }
    }

}
