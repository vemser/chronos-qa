package br.com.dbccompany.chronos.testes.aceitacao.processo;

import br.com.dbccompany.chronos.client.EdicaoClient;
import br.com.dbccompany.chronos.client.ProcessoClient;
import br.com.dbccompany.chronos.data.factory.ProcessoDataFactory;
import br.com.dbccompany.chronos.dto.EdicaoDTO;
import br.com.dbccompany.chronos.dto.EtapaDTO;
import br.com.dbccompany.chronos.dto.ProcessoDTO;
import br.com.dbccompany.chronos.dto.ResponseErrorBadDTO;
import br.com.dbccompany.chronos.model.Processo;
import br.com.dbccompany.chronos.testes.BaseTest;
import br.com.dbccompany.chronos.utils.PreloadData;
import br.com.dbccompany.chronos.utils.Utils;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class ProcessoCreateTest extends BaseTest {
    @Test
    @Tag("todos")
    @Tag("processo")
    @Owner("Kevin Aryel")
    @Epic("Aceitação")
    @Feature("Processo")
    @Story("Criar Processo")
    @Description("Deve criar um novo processo com sucesso")
    public void deveCriarUmNovoProcessoComSucesso() {
        EdicaoDTO edicao = PreloadData.edicao();
        String idEdicao = edicao.getIdEdicao().toString();
        try{
            EtapaDTO etapa = PreloadData.etapa(idEdicao);
            String idEtapa = etapa.getIdEtapa().toString();
            Processo processo = ProcessoDataFactory.processoValido();
            ProcessoDTO response = ProcessoClient.cadastrarProcesso(Utils.converterParaJson(processo),idEtapa ,true)
                    .then()
                    .log().all()
                    .extract().as(ProcessoDTO.class);
            Assert.assertEquals(processo.getNome(), response.getNome());
        } finally {
            EdicaoClient.deletarEdicao(idEdicao,true);
        }
    }
    @Test
    @Tag("todos")
    @Tag("processo")
    @Owner("Kevin Aryel")
    @Epic("Aceitação")
    @Feature("Processo")
    @Story("Criar Processo")
    @Description("Deve falhar ao tentar criar um processo com idEtapa inexistente")
    public void deveFalharAoTentarCriarUmProcessoComIdEtapaInexistente() {
        Processo processo = ProcessoDataFactory.processoValido();
        Response response = ProcessoClient.cadastrarProcesso(Utils.converterParaJson(processo),"0",true)
                .then()
                .log().all()
                .extract().response();
        Assert.assertEquals(HttpStatus.SC_BAD_REQUEST, response.statusCode());
    }

    @Test
    @Tag("todos")
    @Tag("processo")
    @Owner("Kevin Aryel")
    @Epic("Aceitação")
    @Feature("Processo")
    @Story("Criar Processo")
    @Description("Deve retornar erro ao tentar criar um novo processo sem nome")
    public void deveFalharCriarUmNovoProcessoSemNome() {
        EdicaoDTO edicao = PreloadData.edicao();
        String idEdicao = edicao.getIdEdicao().toString();
        try{
            EtapaDTO etapa = PreloadData.etapa(idEdicao);
            String idEtapa = etapa.getIdEtapa().toString();
            Processo processo = ProcessoDataFactory.processoSemNome();
            ResponseErrorBadDTO response = ProcessoClient.cadastrarProcesso(Utils.converterParaJson(processo),idEtapa ,true)
                    .then()
                    .log().all()
                    .extract().as(ResponseErrorBadDTO.class);
            Assert.assertEquals(HttpStatus.SC_BAD_REQUEST, response.getStatus().intValue());
        } finally {
            EdicaoClient.deletarEdicao(idEdicao,true);
        }
    }
    @Test
    @Tag("todos")
    @Tag("processo")
    @Owner("Kevin Aryel")
    @Epic("Aceitação")
    @Feature("Processo")
    @Story("Criar Processo")
    @Description("Deve falhar criar um novo processo sem auth")
    public void deveFalharCriarUmNovoProcessoSemAuth() {
        Processo processo = ProcessoDataFactory.processoValido();
        Response response = ProcessoClient.cadastrarProcesso(Utils.converterParaJson(processo),"0" ,false)
                .then()
                .log().all()
                .extract().response();
        Assert.assertEquals(HttpStatus.SC_FORBIDDEN, response.statusCode());
    }
    @Test
    @Tag("todos")
    @Tag("processo")
    @Owner("Kevin Aryel")
    @Epic("Aceitação")
    @Feature("Processo")
    @Story("Criar Processo")
    @Description("Deve falhar criar um novo processo sem duracaoProcesso")
    public void deveFalharCriarUmNovoProcessoSemDuracaoProcesso() {
        EdicaoDTO edicao = PreloadData.edicao();
        String idEdicao = edicao.getIdEdicao().toString();
        try{
            EtapaDTO etapa = PreloadData.etapa(idEdicao);
            String idEtapa = etapa.getIdEtapa().toString();
            Processo processo = ProcessoDataFactory.processoSemDuracaoProcesso();
            ResponseErrorBadDTO response = ProcessoClient.cadastrarProcesso(Utils.converterParaJson(processo),idEtapa ,true)
                    .then()
                    .log().all()
                    .extract().as(ResponseErrorBadDTO.class);
            Assert.assertEquals(HttpStatus.SC_BAD_REQUEST, response.getStatus().intValue());
        } finally {
            EdicaoClient.deletarEdicao(idEdicao,true);
        }
    }
    @Test
    @Tag("todos")
    @Tag("processo")
    @Owner("Kevin Aryel")
    @Epic("Aceitação")
    @Feature("Processo")
    @Story("Criar Processo")
    @Description("Deve falhar criar um novo processo sem dias uteis")
    public void deveFalharCriarUmNovoProcessoSemDiasUteis() {
        EdicaoDTO edicao = PreloadData.edicao();
        String idEdicao = edicao.getIdEdicao().toString();
        try{
            EtapaDTO etapa = PreloadData.etapa(idEdicao);
            String idEtapa = etapa.getIdEtapa().toString();
            Processo processo = ProcessoDataFactory.processoSemDiasUteis();
            ResponseErrorBadDTO response = ProcessoClient.cadastrarProcesso(Utils.converterParaJson(processo),idEtapa ,true)
                    .then()
                    .log().all()
                    .extract().as(ResponseErrorBadDTO.class);
            Assert.assertEquals(HttpStatus.SC_BAD_REQUEST, response.getStatus().intValue());
        } finally {
            EdicaoClient.deletarEdicao(idEdicao,true);
        }
    }
    @Test
    @Tag("todos")
    @Tag("processo")
    @Owner("Kevin Aryel")
    @Epic("Aceitação")
    @Feature("Processo")
    @Story("Criar Processo")
    @Description("Deve falhar criar um novo processo sem processo critico")
    public void deveFalharCriarUmNovoProcessoSemProcessoCritico() {
        EdicaoDTO edicao = PreloadData.edicao();
        String idEdicao = edicao.getIdEdicao().toString();
        try{
            EtapaDTO etapa = PreloadData.etapa(idEdicao);
            String idEtapa = etapa.getIdEtapa().toString();
            Processo processo = ProcessoDataFactory.processoSemProcessoCritico();
            ResponseErrorBadDTO response = ProcessoClient.cadastrarProcesso(Utils.converterParaJson(processo),idEtapa ,true)
                    .then()
                    .log().all()
                    .extract().as(ResponseErrorBadDTO.class);
            Assert.assertEquals(HttpStatus.SC_BAD_REQUEST, response.getStatus().intValue());
        } finally {
            EdicaoClient.deletarEdicao(idEdicao,true);
        }
    }

    @Test
    @Tag("todos")
    @Tag("processo")
    @Owner("Kevin Aryel")
    @Epic("Aceitação")
    @Feature("Processo")
    @Story("Criar Processo")
    @Description("Deve falhar criar um novo processo com proceso critico invalido")
    public void deveFalharCriarUmNovoProcessoComProcessoCriticoInvalido() {
        EdicaoDTO edicao = PreloadData.edicao();
        String idEdicao = edicao.getIdEdicao().toString();
        try{
            EtapaDTO etapa = PreloadData.etapa(idEdicao);
            String idEtapa = etapa.getIdEtapa().toString();
            Processo processo = ProcessoDataFactory.processoComProcessoCriticoInvalido();
            ResponseErrorBadDTO response = ProcessoClient.cadastrarProcesso(Utils.converterParaJson(processo),idEtapa ,true)
                    .then()
                    .log().all()
                    .extract().as(ResponseErrorBadDTO.class);
            Assert.assertEquals(HttpStatus.SC_BAD_REQUEST, response.getStatus().intValue());
        } finally {
            EdicaoClient.deletarEdicao(idEdicao,true);
        }
    }
}
