package br.com.dbccompany.chronos.testes.aceitacao.edicao;

import br.com.dbccompany.chronos.client.EdicaoClient;
import br.com.dbccompany.chronos.dto.CalendarioEdicaoItemDTO;
import br.com.dbccompany.chronos.dto.EdicaoDTO;
import br.com.dbccompany.chronos.dto.EtapaDTO;
import br.com.dbccompany.chronos.testes.BaseTest;
import br.com.dbccompany.chronos.utils.PreloadData;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class EdicaoCalendarioTest extends BaseTest {
    @Test
    @Tag("todos")
    @Tag("edicao")
    @Owner("Kevin Aryel")
    @Epic("Aceitação")
    @Feature("Calendário")
    @Story("Listar Calendario Geral")
    @Description("Deve falhar listar calendario geral sem auth")
    public void deveFalharListarCalendarioGeralSemAuth(){
        Response response = EdicaoClient.listarCalendarioGeral(false)
                .then()
                .log().all()
                .extract().response()
                ;
        Assert.assertEquals(HttpStatus.SC_FORBIDDEN,response.getStatusCode());
    }
    @Test
    @Tag("todos")
    @Tag("edicao")
    @Owner("Kevin Aryel")
    @Epic("Aceitação")
    @Feature("Calendário")
    @Story("Listar Calendario Edição")
    @Description("Deve listar calendario da edição com sucesso")
    public void deveListarCalendarioDaEdicaoComSucesso(){
        EdicaoDTO edicao = PreloadData.edicao();
        String idEdicao = edicao.getIdEdicao().toString();
        EtapaDTO etapa = PreloadData.etapa(idEdicao);
        PreloadData.processo(etapa.getIdEtapa().toString());
        try{
            CalendarioEdicaoItemDTO[] response = EdicaoClient.listarCalendarioEdicao(idEdicao,true)
                .then()
                    .log().all()
                    .extract().as(CalendarioEdicaoItemDTO[].class)
                ;
        } finally {
            EdicaoClient.deletarEdicao(idEdicao,true);
        }
    }

}
