package br.com.dbccompany.chronos.testes.aceitacao.processo;

import br.com.dbccompany.chronos.client.EdicaoClient;
import br.com.dbccompany.chronos.client.ProcessoClient;
import br.com.dbccompany.chronos.dto.EdicaoDTO;
import br.com.dbccompany.chronos.dto.EtapaDTO;
import br.com.dbccompany.chronos.dto.ProcessoDTO;
import br.com.dbccompany.chronos.testes.BaseTest;
import br.com.dbccompany.chronos.utils.PreloadData;
import io.qameta.allure.*;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class ProcessoListarPorIdTest extends BaseTest {
    @Test
    @Tag("todos")
    @Tag("processo")
    @Owner("Kevin Aryel")
    @Epic("Aceitação")
    @Feature("Processo")
    @Story("Listar Processo por Id")
    @Description("Deve listar um processo por id com sucesso")
    public void deveListarUmProcessoPorIdComSucesso() {
        EdicaoDTO edicao = PreloadData.edicao();
        String idEdicao = edicao.getIdEdicao().toString();
        try{
            EtapaDTO etapa = PreloadData.etapa(idEdicao);
            String idEtapa = etapa.getIdEtapa().toString();
            ProcessoDTO processo = PreloadData.processo(idEtapa);
            String idProcesso = processo.getIdProcesso().toString();
            ProcessoDTO response = ProcessoClient.listarProcessoPorId(idEtapa,true)
                    .then()
                    .log().all()
                    .extract().as(ProcessoDTO.class);
            Assert.assertEquals(processo.getNome(), response.getNome());
        }finally {
            EdicaoClient.deletarEdicao(idEdicao,true);
        }
    }
    @Test
    @Tag("todos")
    @Tag("processo")
    @Owner("Kevin Aryel")
    @Epic("Aceitação")
    @Feature("Processo")
    @Story("Listar Processo por Id")
    @Description("Deve falhar ao listar um processo por id sem auth")
    public void deveFalharAoListarUmProcessoPorIdSemAuth() {
            ProcessoClient.listarProcessoPorId("0",false)
                    .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_FORBIDDEN);
    }
    @Test
    @Tag("todos")
    @Tag("processo")
    @Owner("Kevin Aryel")
    @Epic("Aceitação")
    @Feature("Processo")
    @Story("Listar Processo por Id")
    @Description("Deve falhar ao listar um processo por id inexistente")
    public void deveFalharAoListarUmProcessoPorIdInexistente() {
        ProcessoClient.listarProcessoPorId("0",true)
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_BAD_REQUEST);
    }
}
