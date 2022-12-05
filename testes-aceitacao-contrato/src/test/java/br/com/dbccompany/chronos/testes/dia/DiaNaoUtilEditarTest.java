package br.com.dbccompany.chronos.testes.dia;

import br.com.dbccompany.chronos.client.DiaNaoUtilClient;
import br.com.dbccompany.chronos.data.factory.DiaNaoUtilDataFactory;
import br.com.dbccompany.chronos.dto.DiaNaoUtilDTO;
import br.com.dbccompany.chronos.model.DiaNaoUtil;
import br.com.dbccompany.chronos.testes.BaseTest;
import br.com.dbccompany.chronos.utils.PreloadData;
import br.com.dbccompany.chronos.utils.Utils;
import io.qameta.allure.*;
import org.junit.Assert;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class DiaNaoUtilEditarTest extends BaseTest {
    @Test
    @Tag("todos")
    @Tag("dia-nao-util")
    @Owner("Kevin Aryel")
    @Epic("Backend")
    @Feature("Dia não útil")
    @Story("Editar dia não útil")
    @Description("Deve editar um dia não útil com sucesso")
    public void deveEditarUmDiaNaoUtilComSucesso() {
        DiaNaoUtilDTO diaNaoUtil = PreloadData.diaNaoUtil();
        String idDiaNaoUtil = diaNaoUtil.getIdDiaNaoUtil().toString();
        try{
            DiaNaoUtil diaNaoUtilEditado = DiaNaoUtilDataFactory.diaNaoUtilValido();
            DiaNaoUtilDTO response = DiaNaoUtilClient.editarDiaNaoUtil(Utils.converterParaJson(diaNaoUtilEditado),idDiaNaoUtil,true)
                    .then()
                    .log().all()
                    .extract().as(DiaNaoUtilDTO.class);
            Assert.assertEquals(diaNaoUtilEditado.getDataFinal(), response.getDataFinal());
        } finally {
            DiaNaoUtilClient.deletarDiaNaoUtil(idDiaNaoUtil,true);
        }
    }
    @Test
    @Tag("todos")
    @Tag("dia-nao-util")
    @Owner("Kevin Aryel")
    @Epic("Backend")
    @Feature("Dia não útil")
    @Story("Editar dia não útil")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Deve editar um dia não útil com data inicial igual a data final com sucesso")
    public void deveEditarUmDiaNaoUtilComDataInicialIgualADataFinalComSucesso() {
        DiaNaoUtilDTO diaNaoUtil = PreloadData.diaNaoUtil();
        String idDiaNaoUtil = diaNaoUtil.getIdDiaNaoUtil().toString();
        try{
            DiaNaoUtil diaNaoUtilEditado = DiaNaoUtilDataFactory.diaNaoUtilComDataIncialIgualDataFinal();
            DiaNaoUtilDTO response = DiaNaoUtilClient.editarDiaNaoUtil(Utils.converterParaJson(diaNaoUtilEditado),idDiaNaoUtil,true)
                    .then()
                    .log().all()
                    .extract().as(DiaNaoUtilDTO.class);
            Assert.assertEquals(diaNaoUtilEditado.getDataFinal(), response.getDataFinal());
        } finally {
            DiaNaoUtilClient.deletarDiaNaoUtil(idDiaNaoUtil,true);
        }
    }

    @Test
    @Tag("todos")
    @Tag("dia-nao-util")
    @Owner("Kevin Aryel")
    @Epic("Backend")
    @Feature("Dia não útil")
    @Story("Editar dia não útil")
    @Severity(SeverityLevel.MINOR)
    @Description("Deve retornar erro ao tentar editar um dia não útil sem data inicial")
    public void deveFalharEditarUmDiaNaoUtilSemDataInicial() {
        DiaNaoUtilDTO diaNaoUtil = PreloadData.diaNaoUtil();
        String idDiaNaoUtil = diaNaoUtil.getIdDiaNaoUtil().toString();
        try{
            DiaNaoUtil diaNaoUtilEditado = DiaNaoUtilDataFactory.diaNaoUtilSemDataInicial();
            DiaNaoUtilClient.editarDiaNaoUtil(Utils.converterParaJson(diaNaoUtilEditado),idDiaNaoUtil,true)
                    .then()
                    .log().all()
                    .statusCode(400);
        } finally {
            DiaNaoUtilClient.deletarDiaNaoUtil(idDiaNaoUtil,true);
        }
    }
    @Test
    @Tag("todos")
    @Tag("dia-nao-util")
    @Owner("Kevin Aryel")
    @Epic("Backend")
    @Feature("Dia não útil")
    @Story("Editar dia não útil")
    @Severity(SeverityLevel.MINOR)
    @Description("Deve retornar erro ao tentar editar um dia não útil com sem descrição")
    public void deveFalharEditarUmDiaNaoUtilSemDescricao() {
        DiaNaoUtilDTO diaNaoUtil = PreloadData.diaNaoUtil();
        String idDiaNaoUtil = diaNaoUtil.getIdDiaNaoUtil().toString();
        try{
            DiaNaoUtil diaNaoUtilEditado = DiaNaoUtilDataFactory.diaNaoUtilSemDescricao();
            DiaNaoUtilClient.editarDiaNaoUtil(Utils.converterParaJson(diaNaoUtilEditado),idDiaNaoUtil,true)
                    .then()
                    .log().all()
                    .statusCode(400);
        } finally {
            DiaNaoUtilClient.deletarDiaNaoUtil(idDiaNaoUtil,true);
        }
    }
    @Test
    @Tag("todos")
    @Tag("dia-nao-util")
    @Owner("Kevin Aryel")
    @Epic("Backend")
    @Feature("Dia não útil")
    @Story("Editar dia não útil")
    @Severity(SeverityLevel.MINOR)
    @Description("Deve retornar erro ao tentar editar um dia não útil com id inválido")
    public void deveFalharEditarUmDiaNaoUtilComIdInvalido() {
            DiaNaoUtil diaNaoUtilEditado = DiaNaoUtilDataFactory.diaNaoUtilValido();
            DiaNaoUtilClient.editarDiaNaoUtil(Utils.converterParaJson(diaNaoUtilEditado),"0",true)
                    .then()
                    .log().all()
                    .statusCode(400)
            ;
    }

}
