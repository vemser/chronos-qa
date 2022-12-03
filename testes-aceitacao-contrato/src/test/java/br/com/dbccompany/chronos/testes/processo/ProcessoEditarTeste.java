package br.com.dbccompany.chronos.testes.processo;

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
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class ProcessoEditarTeste extends BaseTest {

    @Test
    @Tag("todos")
    @Tag("processo")
    @Owner("Kevin Aryel")
    @Epic("Backend")
    @Story("Processo")
    @Feature("Editar Processo")
    @Description("Deve editar um processo com sucesso")
    public void deveEditarUmProcessoComSucesso() {
        EdicaoDTO edicao = PreloadData.edicao();
        String idEdicao = edicao.getIdEdicao().toString();
        try {
            EtapaDTO etapa = PreloadData.etapa(idEdicao);
            String idEtapa = etapa.getIdEtapa().toString();
            ProcessoDTO processo = PreloadData.processo(idEtapa);
            String idProcesso = processo.getIdProcesso().toString();
            Processo processoEditar = ProcessoDataFactory.processoValido();
            ProcessoDTO response = ProcessoClient.atualizarProcesso(Utils.converterParaJson(processoEditar),idProcesso,true)
                    .then()
                    .log().all()
                    .extract().as(ProcessoDTO.class);
            Assert.assertEquals(processoEditar.getNome(), response.getNome());
        } finally {
            EdicaoClient.deletarEdicao(idEdicao,true);
        }
    }
    @Test
    @Tag("todos")
    @Tag("processo")
    @Owner("Kevin Aryel")
    @Epic("Backend")
    @Story("Processo")
    @Feature("Editar Processo")
    @Description("Deve falhar editar processo sem nome")
    public void deveFalharEditarProcessoSemNome() {
        EdicaoDTO edicao = PreloadData.edicao();
        String idEdicao = edicao.getIdEdicao().toString();
        try {
            EtapaDTO etapa = PreloadData.etapa(idEdicao);
            String idEtapa = etapa.getIdEtapa().toString();
            ProcessoDTO processo = PreloadData.processo(idEtapa);
            String idProcesso = processo.getIdProcesso().toString();
            Processo processoEditar = ProcessoDataFactory.processoSemNome();
            ResponseErrorBadDTO response = ProcessoClient.atualizarProcesso(Utils.converterParaJson(processoEditar),idProcesso,true)
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
    @Epic("Backend")
    @Story("Processo")
    @Feature("Editar Processo")
    @Description("Deve falhar editar processo sem ordem de execução")
    public void deveFalharEditarProcessoSemOrdem() {
        EdicaoDTO edicao = PreloadData.edicao();
        String idEdicao = edicao.getIdEdicao().toString();
        try {
            EtapaDTO etapa = PreloadData.etapa(idEdicao);
            String idEtapa = etapa.getIdEtapa().toString();
            ProcessoDTO processo = PreloadData.processo(idEtapa);
            String idProcesso = processo.getIdProcesso().toString();
            Processo processoEditar = ProcessoDataFactory.processoSemOrdemExecucao();
            ResponseErrorBadDTO response = ProcessoClient.atualizarProcesso(Utils.converterParaJson(processoEditar),idProcesso,true)
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
    @Epic("Backend")
    @Story("Processo")
    @Feature("Editar Processo")
    @Description("Deve falhar editar processo sem responsável")
    public void deveFalharEditarProcessoSemResponsavel() {
        EdicaoDTO edicao = PreloadData.edicao();
        String idEdicao = edicao.getIdEdicao().toString();
        try {
            EtapaDTO etapa = PreloadData.etapa(idEdicao);
            String idEtapa = etapa.getIdEtapa().toString();
            ProcessoDTO processo = PreloadData.processo(idEtapa);
            String idProcesso = processo.getIdProcesso().toString();
            Processo processoEditar = ProcessoDataFactory.processoSemResponsavel();
            ResponseErrorBadDTO response = ProcessoClient.atualizarProcesso(Utils.converterParaJson(processoEditar),idProcesso,true)
                    .then()
                    .log().all()
                    .extract().as(ResponseErrorBadDTO.class);
            Assert.assertEquals(HttpStatus.SC_BAD_REQUEST, response.getStatus().intValue());
        } finally {
            EdicaoClient.deletarEdicao(idEdicao,true);
        }
    }
}
