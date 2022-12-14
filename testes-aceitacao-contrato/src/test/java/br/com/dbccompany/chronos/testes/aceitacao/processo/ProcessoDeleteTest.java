package br.com.dbccompany.chronos.testes.aceitacao.processo;

import br.com.dbccompany.chronos.client.EdicaoClient;
import br.com.dbccompany.chronos.client.ProcessoClient;
import br.com.dbccompany.chronos.dto.EdicaoDTO;
import br.com.dbccompany.chronos.dto.EtapaDTO;
import br.com.dbccompany.chronos.dto.ProcessoDTO;
import br.com.dbccompany.chronos.testes.BaseTest;
import br.com.dbccompany.chronos.utils.PreloadData;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class ProcessoDeleteTest extends BaseTest {
    @Test
    @Tag("todos")
    @Tag("processo")
    @Owner("Kevin Aryel")
    @Epic("Aceitação")
    @Feature("Processo")
    @Story("Deletar Processo")
    @Description("Deve deletar um processo com sucesso")
    public void deveDeletarUmProcessoComSucesso() {
        EdicaoDTO edicao = PreloadData.edicao();
        String idEdicao = edicao.getIdEdicao().toString();
        try{
            EtapaDTO etapa = PreloadData.etapa(idEdicao);
            String idEtapa = etapa.getIdEtapa().toString();
            ProcessoDTO processo = PreloadData.processo(idEtapa);
            String idProcesso = processo.getIdProcesso().toString();
            Response response = ProcessoClient.deletarProcesso(idProcesso,true)
                .then()
                    .log().all()
                    .extract().response()
                ;
            Assert.assertEquals(HttpStatus.SC_NO_CONTENT, response.statusCode());
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
    @Story("Deletar Processo")
    @Description("Deve falhar ao deletar um processo sem auth")
    public void deveFalharAoDeletarUmProcessoSemAuth() {
        Response response = ProcessoClient.deletarProcesso("0",false)
            .then()
                .log().all()
                .extract().response()
            ;
        Assert.assertEquals(HttpStatus.SC_FORBIDDEN, response.statusCode());
    }
}
