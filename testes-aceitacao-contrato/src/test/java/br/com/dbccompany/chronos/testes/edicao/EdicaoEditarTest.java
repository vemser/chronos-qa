package br.com.dbccompany.chronos.testes.edicao;

import br.com.dbccompany.chronos.client.EdicaoClient;
import br.com.dbccompany.chronos.data.factory.EdicaoDataFactory;
import br.com.dbccompany.chronos.data.preloadAndRestore.EdicaoPreloadData;
import br.com.dbccompany.chronos.dto.EdicaoDTO;
import br.com.dbccompany.chronos.model.Edicao;
import br.com.dbccompany.chronos.testes.BaseTest;
import br.com.dbccompany.chronos.utils.Utils;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class EdicaoEditarTest extends BaseTest {

    @Test
    @Tag("todos")
    @Tag("edicao")
    @Description("Deve editar uma edição com sucesso")
    public void deveEditarUmaEdicaoComSucesso() {
        EdicaoDTO edicao = EdicaoPreloadData.edicaoValida();
        String edicaoId = edicao.getIdEdicao().toString();
        try {
            Edicao edicaoEditada = EdicaoDataFactory.edicaoValida();
            EdicaoDTO response = EdicaoClient
                    .atualizarEdicao(Utils.converterParaJson(edicaoEditada),edicaoId, true)
                    .then()
                        .log().all()
                        .extract().as(EdicaoDTO.class);
            Assert.assertEquals(response.getNome(), edicaoEditada.getNome());
        } finally {
            EdicaoClient.deletarEdicao(edicaoId, true);
        }
    }
    @Test
    @Tag("todos")
    @Tag("edicao")
    @Description("Deve falhar ao editar uma edição sem auth")
    public void deveFalharAoEditarUmaEdicaoSemAuth() {
            Edicao edicaoEditada = EdicaoDataFactory.edicaoValida();
            Response response = EdicaoClient.atualizarEdicao(Utils.converterParaJson(edicaoEditada),"1", false)
                    .then()
                        .log().all()
                        .extract().response()
                    ;
            Assert.assertEquals(HttpStatus.SC_FORBIDDEN, response.getStatusCode());
    }
    @Test
    @Tag("todos")
    @Tag("edicao")
    @Description("Deve falhar ao editar uma edição com id inválido")
    public void deveFalharAoEditarUmaEdicaoComIdInvalido() {
            Edicao edicaoEditada = EdicaoDataFactory.edicaoValida();
            Response response = EdicaoClient.atualizarEdicao(Utils.converterParaJson(edicaoEditada),"0", true)
                    .then()
                        .log().all()
                        .extract().response()
                    ;
            Assert.assertEquals(HttpStatus.SC_BAD_REQUEST, response.getStatusCode());
    }
    @Test
    @Tag("todos")
    @Tag("edicao")
    @Description("Deve falhar ao editar uma edição sem nome")
    public void deveFalharAoEditarUmaEdicaoSemNome() {
        EdicaoDTO edicao = EdicaoPreloadData.edicaoValida();
        String edicaoId = edicao.getIdEdicao().toString();
        try {
            Edicao edicaoEditada = EdicaoDataFactory.edicaoSemNome();
            edicaoEditada.setNome(null);
            Response response = EdicaoClient.atualizarEdicao(Utils.converterParaJson(edicaoEditada),edicaoId, true)
                    .then()
                    .log().all()
                    .extract().response()
                    ;
            Assert.assertEquals(HttpStatus.SC_BAD_REQUEST, response.getStatusCode());
        } finally {
            EdicaoClient.deletarEdicao(edicaoId, true);
        }
    }
    @Test
    @Tag("todos")
    @Tag("edicao")
    @Description("Deve falhar ao editar uma edição sem dataInicial")
    public void deveFalharAoEditarUmaEdicaoSemDataInicial() {
        EdicaoDTO edicao = EdicaoPreloadData.edicaoValida();
        String edicaoId = edicao.getIdEdicao().toString();
        try {
            Edicao edicaoEditada = EdicaoDataFactory.edicaoSemDataInicial();
            edicaoEditada.setDataInicial(null);
            Response response = EdicaoClient.atualizarEdicao(Utils.converterParaJson(edicaoEditada),edicaoId, true)
                    .then()
                    .log().all()
                    .extract().response()
                    ;
            Assert.assertEquals(HttpStatus.SC_BAD_REQUEST, response.getStatusCode());
        } finally {
            EdicaoClient.deletarEdicao(edicaoId, true);
        }
    }
    @Test
    @Tag("todos")
    @Tag("edicao")
    @Description("Deve falhar ao editar uma edição sem dataFinal")
    public void deveFalharAoEditarUmaEdicaoSemDataFinal() {
        EdicaoDTO edicao = EdicaoPreloadData.edicaoValida();
        String edicaoId = edicao.getIdEdicao().toString();
        try {
            Edicao edicaoEditada = EdicaoDataFactory.edicaoSemDataFinal();
            edicaoEditada.setDataFinal(null);
            Response response = EdicaoClient.atualizarEdicao(Utils.converterParaJson(edicaoEditada),edicaoId, true)
                    .then()
                    .log().all()
                    .extract().response()
                    ;
            Assert.assertEquals(HttpStatus.SC_BAD_REQUEST, response.getStatusCode());
        } finally {
            EdicaoClient.deletarEdicao(edicaoId, true);
        }
    }

    @Test
    @Tag("todos")
    @Tag("edicao")
    @Description("Deve falhar ao editar uma edição com dataFinal menor que dataInicial")
    public void deveFalharAoEditarUmaEdicaoComDataFinalMenorQueDataInicial() {
        EdicaoDTO edicao = EdicaoPreloadData.edicaoValida();
        String edicaoId = edicao.getIdEdicao().toString();
        try {
            Edicao edicaoEditada = EdicaoDataFactory.edicaoComDataFinalMenorQueDataInicial();
            Response response = EdicaoClient.atualizarEdicao(Utils.converterParaJson(edicaoEditada),edicaoId, true)
                    .then()
                    .log().all()
                    .extract().response()
                    ;
            Assert.assertEquals(HttpStatus.SC_BAD_REQUEST, response.getStatusCode());
        } finally {
            EdicaoClient.deletarEdicao(edicaoId, true);
        }
    }
    @Test
    @Tag("todos")
    @Tag("edicao")
    @Description("Deve falhar ao editar uma edição com dataFinal igual a dataInicial")
    public void deveFalharAoEditarUmaEdicaoComDataFinalIgualADataInicial() {
        EdicaoDTO edicao = EdicaoPreloadData.edicaoValida();
        String edicaoId = edicao.getIdEdicao().toString();
        try {
            Edicao edicaoEditada = EdicaoDataFactory.edicaoComDataFinalIgualADataInicial();
            Response response = EdicaoClient.atualizarEdicao(Utils.converterParaJson(edicaoEditada),edicaoId, true)
                    .then()
                    .log().all()
                    .extract().response()
                    ;
            Assert.assertEquals(HttpStatus.SC_BAD_REQUEST, response.getStatusCode());
        } finally {
            EdicaoClient.deletarEdicao(edicaoId, true);
        }
    }
    @Test
    @Tag("todos")
    @Tag("edicao")
    @Description("Deve falhar ao editar uma edição com dataFinal no formato Inválido")
    public void deveFalharAoEditarUmaEdicaoComDataFinalNoFormatoInvalido() {
        EdicaoDTO edicao = EdicaoPreloadData.edicaoValida();
        String edicaoId = edicao.getIdEdicao().toString();
        try {
            Edicao edicaoEditada = EdicaoDataFactory.edicaoComDataFinalFormatoInvalido();
            Response response = EdicaoClient.atualizarEdicao(Utils.converterParaJson(edicaoEditada),edicaoId, true)
                    .then()
                    .log().all()
                    .extract().response()
                    ;
            Assert.assertEquals(HttpStatus.SC_BAD_REQUEST, response.getStatusCode());
        } finally {
            EdicaoClient.deletarEdicao(edicaoId, true);
        }
    }
    @Test
    @Tag("todos")
    @Tag("edicao")
    @Description("Deve falhar ao editar uma edição com dataInicial no formato invalido")
    public void deveFalharAoEditarUmaEdicaoComDataInicialNoFormatoInvalido() {
        EdicaoDTO edicao = EdicaoPreloadData.edicaoValida();
        String edicaoId = edicao.getIdEdicao().toString();
        try {
            Edicao edicaoEditada = EdicaoDataFactory.edicaoComDataInicialFormatoInvalido();
            Response response = EdicaoClient.atualizarEdicao(Utils.converterParaJson(edicaoEditada),edicaoId, true)
                    .then()
                    .log().all()
                    .extract().response()
                    ;
            Assert.assertEquals(HttpStatus.SC_BAD_REQUEST, response.getStatusCode());
        } finally {
            EdicaoClient.deletarEdicao(edicaoId, true);
        }
    }
    @Test
    @Tag("todos")
    @Tag("edicao")
    @Description("Deve falhar ao editar uma edição com data inicial tipo invalido")
    public void deveFalharAoEditarUmaEdicaoComDataInicialTipoInvalido() {
        EdicaoDTO edicao = EdicaoPreloadData.edicaoValida();
        String edicaoId = edicao.getIdEdicao().toString();
        try {
            Edicao edicaoEditada = EdicaoDataFactory.edicaoComDataInicialTipoInvalido();
            Response response = EdicaoClient.atualizarEdicao(Utils.converterParaJson(edicaoEditada),edicaoId, true)
                    .then()
                    .log().all()
                    .extract().response()
                    ;
            Assert.assertEquals(HttpStatus.SC_BAD_REQUEST, response.getStatusCode());
        } finally {
            EdicaoClient.deletarEdicao(edicaoId, true);
        }
    }
    @Test
    @Tag("todos")
    @Tag("edicao")
    @Description("Deve falhar ao editar uma edição com data final tipo invalido")
    public void deveFalharAoEditarUmaEdicaoComDataFinalTipoInvalido() {
        EdicaoDTO edicao = EdicaoPreloadData.edicaoValida();
        String edicaoId = edicao.getIdEdicao().toString();
        try {
            Edicao edicaoEditada = EdicaoDataFactory.edicaoComDataFinalTipoInvalido();
            Response response = EdicaoClient.atualizarEdicao(Utils.converterParaJson(edicaoEditada),edicaoId, true)
                    .then()
                    .log().all()
                    .extract().response()
                    ;
            Assert.assertEquals(HttpStatus.SC_BAD_REQUEST, response.getStatusCode());
        } finally {
            EdicaoClient.deletarEdicao(edicaoId, true);
        }
    }
}
