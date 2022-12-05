package br.com.dbccompany.chronos.testes.aceitacao.dia;

import br.com.dbccompany.chronos.client.DiaNaoUtilClient;
import br.com.dbccompany.chronos.dto.DiaNaoUtilDTO;
import br.com.dbccompany.chronos.testes.BaseTest;
import br.com.dbccompany.chronos.utils.PreloadData;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class DiaNaoUtilDeleteTest extends BaseTest {
    @Test
    @Tag("todos")
    @Tag("dia-nao-util")
    @Owner("Kevin Aryel")
    @Epic("Aceitação")
    @Feature("Dia não útil")
    @Story("Deletar dia não útil")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Deve deletar um dia não útil com sucesso")
    public void deveDeletarUmDiaNaoUtilComSucesso() {
        DiaNaoUtilDTO diaNaoUtil = PreloadData.diaNaoUtil();
        String idDiaNaoUtil = diaNaoUtil.getIdDiaNaoUtil().toString();
        Response response = DiaNaoUtilClient.deletarDiaNaoUtil(idDiaNaoUtil,true)
                .then()
                .log().all()
                .extract().response();
        Assert.assertEquals(HttpStatus.SC_NO_CONTENT, response.getStatusCode());
    }
    @Test
    @Tag("todos")
    @Tag("dia-nao-util")
    @Owner("Kevin Aryel")
    @Epic("Aceitação")
    @Feature("Dia não útil")
    @Story("Deletar dia não útil")
    @Severity(SeverityLevel.MINOR)
    @Description("Deve retornar erro ao tentar deletar um dia não útil sem auth")
    public void deveFalharDeletarUmDiaNaoUtilSemAuth() {
        Response response = DiaNaoUtilClient.deletarDiaNaoUtil("0",false)
                .then()
                .log().all()
                .extract().response();
        Assert.assertEquals(HttpStatus.SC_FORBIDDEN, response.getStatusCode());
    }
    @Test
    @Tag("todos")
    @Tag("dia-nao-util")
    @Owner("Kevin Aryel")
    @Epic("Aceitação")
    @Feature("Dia não útil")
    @Story("Deletar dia não útil")
    @Severity(SeverityLevel.MINOR)
    @Description("Deve retornar erro ao tentar deletar um dia não útil com id inválido")
    public void deveFalharDeletarUmDiaNaoUtilComIdInvalido() {
        Response response = DiaNaoUtilClient.deletarDiaNaoUtil("0",true)
                .then()
                .log().all()
                .extract().response();
        Assert.assertEquals(HttpStatus.SC_BAD_REQUEST, response.getStatusCode());
    }
}
