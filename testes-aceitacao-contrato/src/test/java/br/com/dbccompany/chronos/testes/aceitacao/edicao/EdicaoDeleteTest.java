package br.com.dbccompany.chronos.testes.aceitacao.edicao;

import br.com.dbccompany.chronos.client.EdicaoClient;
import br.com.dbccompany.chronos.dto.EdicaoDTO;
import br.com.dbccompany.chronos.dto.ResponseErrorBadDTO;
import br.com.dbccompany.chronos.testes.BaseTest;
import br.com.dbccompany.chronos.utils.PreloadData;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class EdicaoDeleteTest extends BaseTest {
    @Test
    @Tag("todos")
    @Tag("edicao")
    @Owner("Kevin Aryel")
    @Epic("Backend")
    @Feature("Edição")
    @Story("Deletar Edição")
    @Description("Deve deletar uma edição com sucesso")
    public void deveDeletarUmaEdicaoComSucesso() {
        EdicaoDTO edicao = PreloadData.edicao();
        String edicaoId = edicao.getIdEdicao().toString();
        try {
            Response response = EdicaoClient.deletarEdicao(edicaoId, true)
                .then()
                    .log().all()
                    .extract().response()
                ;
            Assert.assertEquals(HttpStatus.SC_NO_CONTENT, response.getStatusCode());
        } finally {
            EdicaoClient.deletarEdicao(edicaoId, true);
        }
    }
    @Test
    @Tag("todos")
    @Tag("edicao")
    @Owner("Kevin Aryel")
    @Epic("Backend")
    @Feature("Edição")
    @Story("Deletar Edição")
    @Description("Deve retornar erro ao deletar uma edição sem auth")
    public void deveFalharAoDeletarUmaEdicaoSemAuth() {
        EdicaoDTO edicao = PreloadData.edicao();
        String edicaoId = edicao.getIdEdicao().toString();
        try {
            Response response = EdicaoClient.deletarEdicao(edicaoId, false)
                .then()
                    .log().all()
                    .extract().response()
                ;
            Assert.assertEquals(HttpStatus.SC_FORBIDDEN, response.getStatusCode());
        } finally {
            EdicaoClient.deletarEdicao(edicaoId, true);
        }
    }
    @Test
    @Tag("todos")
    @Tag("edicao")
    @Owner("Kevin Aryel")
    @Epic("Backend")
    @Feature("Edição")
    @Story("Deletar Edição")
    @Description("Deve retornar erro ao deletar uma edição inexistente")
    public void deveFalharAoTentarDeletarEdicaoComIdInvalido(){
        ResponseErrorBadDTO response = EdicaoClient.deletarEdicao("0",true)
            .then()
                .log().all()
                .extract().as(ResponseErrorBadDTO.class)
            ;
        Assert.assertEquals(HttpStatus.SC_BAD_REQUEST,response.getStatus().intValue());
    }
}
