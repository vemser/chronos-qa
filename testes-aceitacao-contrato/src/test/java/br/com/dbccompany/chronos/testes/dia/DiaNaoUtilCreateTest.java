package br.com.dbccompany.chronos.testes.dia;

import br.com.dbccompany.chronos.client.DiaNaoUtilClient;
import br.com.dbccompany.chronos.data.factory.DiaNaoUtilDataFactory;
import br.com.dbccompany.chronos.dto.DiaNaoUtilDTO;
import br.com.dbccompany.chronos.dto.ResponseErrorBadDTO;
import br.com.dbccompany.chronos.model.DiaNaoUtil;
import br.com.dbccompany.chronos.testes.BaseTest;
import br.com.dbccompany.chronos.utils.Utils;
import io.qameta.allure.*;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class DiaNaoUtilCreateTest extends BaseTest {

    @Test
    @Tag("todos")
    @Tag("dia-nao-util")
    @Owner("Kevin Aryel")
    @Epic("Backend")
    @Story("Dia não útil")
    @Feature("Criar dia não útil")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Deve criar um dia não útil com sucesso")
    public void deveCriarUmDiaNaoUtilComSucesso() {
        DiaNaoUtil diaNaoUtil = DiaNaoUtilDataFactory.diaNaoUtilValido();
        DiaNaoUtilDTO response = DiaNaoUtilClient.criarDiaNaoUtil(Utils.converterParaJson(diaNaoUtil),true)
                .then()
                .log().all()
                .extract().as(DiaNaoUtilDTO.class);
        Assert.assertEquals(diaNaoUtil.getDescricao(), response.getDescricao());
    }

    @Test
    @Tag("todos")
    @Tag("dia-nao-util")
    @Owner("Kevin Aryel")
    @Epic("Backend")
    @Story("Dia não útil")
    @Feature("Criar dia não útil")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Deve criar um dia não útil com data inicial igual a data final com sucesso")
    public void deveCriarUmDiaNaoUtilComDataInicialIgualADataFinalComSucesso() {
        DiaNaoUtil diaNaoUtil = DiaNaoUtilDataFactory.diaNaoUtilComDataIncialIgualDataFinal();
        DiaNaoUtilDTO response = DiaNaoUtilClient.criarDiaNaoUtil(Utils.converterParaJson(diaNaoUtil),true)
                .then()
                .log().all()
                .extract().as(DiaNaoUtilDTO.class);
        Assert.assertEquals(diaNaoUtil.getDescricao(), response.getDescricao());
    }

    @Test
    @Tag("todos")
    @Tag("dia-nao-util")
    @Owner("Kevin Aryel")
    @Epic("Backend")
    @Story("Dia não útil")
    @Feature("Criar dia não útil")
    @Severity(SeverityLevel.MINOR)
    @Description("Deve falhar criar um dia não útil sem descrição")
    public void deveFalharCriarUmDiaNaoUtilSemDescricao() {
        DiaNaoUtil diaNaoUtil = DiaNaoUtilDataFactory.diaNaoUtilSemDescricao();
        ResponseErrorBadDTO response = DiaNaoUtilClient.criarDiaNaoUtil(Utils.converterParaJson(diaNaoUtil),true)
                .then()
                .log().all()
                .extract().as(ResponseErrorBadDTO.class);
        Assert.assertEquals(HttpStatus.SC_BAD_REQUEST, response.getStatus().intValue());
    }
    @Test
    @Tag("todos")
    @Tag("dia-nao-util")
    @Owner("Kevin Aryel")
    @Epic("Backend")
    @Story("Dia não útil")
    @Feature("Criar dia não útil")
    @Severity(SeverityLevel.MINOR)
    @Description("Deve falhar criar um dia não útil sem data inicial")
    public void deveFalharCriarUmDiaNaoUtilSemDataInicial() {
        DiaNaoUtil diaNaoUtil = DiaNaoUtilDataFactory.diaNaoUtilSemDataInicial();
        ResponseErrorBadDTO response = DiaNaoUtilClient.criarDiaNaoUtil(Utils.converterParaJson(diaNaoUtil),true)
                .then()
                .log().all()
                .extract().as(ResponseErrorBadDTO.class);
        Assert.assertEquals(HttpStatus.SC_BAD_REQUEST, response.getStatus().intValue());
    }

    @Test
    @Tag("todos")
    @Tag("dia-nao-util")
    @Owner("Kevin Aryel")
    @Epic("Backend")
    @Story("Dia não útil")
    @Feature("Criar dia não útil")
    @Severity(SeverityLevel.MINOR)
    @Description("Deve falhar criar um dia não útil sem repeticao anual")
    public void deveFalharCriarUmDiaNaoUtilSemRepeticaoAnual() {
        DiaNaoUtil diaNaoUtil = DiaNaoUtilDataFactory.diaNaoUtilSemRepeticaoAnual();
        ResponseErrorBadDTO response = DiaNaoUtilClient.criarDiaNaoUtil(Utils.converterParaJson(diaNaoUtil),true)
                .then()
                .log().all()
                .extract().as(ResponseErrorBadDTO.class);
        Assert.assertEquals(HttpStatus.SC_BAD_REQUEST, response.getStatus().intValue());
    }

    @Test
    @Tag("todos")
    @Tag("dia-nao-util")
    @Owner("Kevin Aryel")
    @Epic("Backend")
    @Story("Dia não útil")
    @Feature("Criar dia não útil")
    @Severity(SeverityLevel.MINOR)
    @Description("Deve falhar criar um dia não útil sem data final")
    public void deveFalharCriarUmDiaNaoUtilSemDataFinal() {
        DiaNaoUtil diaNaoUtil = DiaNaoUtilDataFactory.diaNaoUtilSemDataFinal();
        ResponseErrorBadDTO response = DiaNaoUtilClient.criarDiaNaoUtil(Utils.converterParaJson(diaNaoUtil),true)
                .then()
                .log().all()
                .extract().as(ResponseErrorBadDTO.class);
        Assert.assertEquals(HttpStatus.SC_BAD_REQUEST, response.getStatus().intValue());
    }
}
