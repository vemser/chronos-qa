package br.com.dbccompany.chronos.testes.edicao;

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

public class EdicaoStatusTest extends BaseTest {
    @Test
    @Tag("todos")
    @Tag("edicao")
    @Owner("Kevin Aryel")
    @Epic("Backend")
    @Feature("Edição")
    @Story("Editar Status Edição")
    @Description("Deve alterar o status de uma edição com sucesso")
    public void deveAlterarStatusDeUmaEdicaoComSucesso() {
        EdicaoDTO edicao = PreloadData.edicao();
        String edicaoId = edicao.getIdEdicao().toString();
        try{
            Response response = EdicaoClient.alterarStatusEdicao(edicaoId,true)
                .then()
                    .log().all()
                    .extract().response()
                ;
            Assert.assertEquals(HttpStatus.SC_NO_CONTENT, response.getStatusCode());
        } finally {
            EdicaoClient.deletarEdicao(edicaoId,true);
        }
    }
    @Test
    @Tag("todos")
    @Tag("edicao")
    @Owner("Kevin Aryel")
    @Epic("Backend")
    @Feature("Edição")
    @Story("Editar Status Edição")
    @Description("Deve retornar erro ao tentar alterar status de uma edição com id inválido")
    public void deveFalharAoAlterarStatusDeUmaEdicaoComIdInvalido() {
        ResponseErrorBadDTO response = EdicaoClient.alterarStatusEdicao("0",true)
            .then()
                .log().all()
                .extract().as(ResponseErrorBadDTO.class)
            ;
        Assert.assertEquals(HttpStatus.SC_BAD_REQUEST, response.getStatus().intValue());
    }
    @Test
    @Tag("todos")
    @Tag("edicao")
    @Owner("Kevin Aryel")
    @Epic("Backend")
    @Feature("Edição")
    @Story("Editar Status Edição")
    @Description("Deve retornar erro ao alterar status de uma edição sem auth")
    public void deveFalharAoAlterarStatusDeUmaEdicaoSemAuth(){
        Response response = EdicaoClient.alterarStatusEdicao("0",false)
                .then()
                .log().all()
                .extract().response();
        Assert.assertEquals(HttpStatus.SC_FORBIDDEN,response.getStatusCode());
    }
}
