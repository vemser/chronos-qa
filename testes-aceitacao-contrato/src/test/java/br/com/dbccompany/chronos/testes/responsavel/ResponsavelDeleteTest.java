package br.com.dbccompany.chronos.testes.responsavel;

import br.com.dbccompany.chronos.client.ResponsavelClient;
import br.com.dbccompany.chronos.testes.BaseTest;
import br.com.dbccompany.chronos.utils.PreloadData;
import br.com.dbccompany.chronos.dto.ResponsavelDTO;
import br.com.dbccompany.chronos.dto.ResponseErrorBadDTO;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class ResponsavelDeleteTest extends BaseTest {
    @Test
    @Tag("todos")
    @Tag("responsavel")
    @Description("Deve deletar um responsável com sucesso")
    public void deveDeletarResponsavelComSucesso(){
        ResponsavelDTO responsavel = PreloadData.responsavel();
        String idResponsavel = responsavel.getIdResponsavel().toString();
        Response response = ResponsavelClient.deletarResponsavel(idResponsavel, true)
                .then()
                .log().all()
                .extract().response();
        Assert.assertEquals(HttpStatus.SC_NO_CONTENT,response.getStatusCode());
    }
    @Test
    @Tag("todos")
    @Tag("responsavel")
    @Description("Deve falhar deletar um responsável sem Auth")
    public void deveFalharDeletarResponsavelSemAuth(){
         Response response = ResponsavelClient.deletarResponsavel("0", false)
                .then()
                .log().all()
                .extract().response();
        Assert.assertEquals(HttpStatus.SC_FORBIDDEN,response.getStatusCode());
    }
    @Test
    @Tag("todos")
    @Tag("responsavel")
    @Description("Deve falhar deletar um responsável com id inválido")
    public void deveFalharDeletarResponsavelComIdInvalido(){
        ResponseErrorBadDTO response = ResponsavelClient.deletarResponsavel("0", true)
                .then()
                .log().all()
                .extract().as(ResponseErrorBadDTO.class);
        Assert.assertEquals(HttpStatus.SC_BAD_REQUEST,response.getStatus().intValue());
    }
}
