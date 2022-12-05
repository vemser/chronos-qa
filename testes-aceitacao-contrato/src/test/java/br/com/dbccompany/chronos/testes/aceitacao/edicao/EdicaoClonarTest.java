package br.com.dbccompany.chronos.testes.aceitacao.edicao;

import br.com.dbccompany.chronos.client.EdicaoClient;
import br.com.dbccompany.chronos.dto.EdicaoDTO;
import br.com.dbccompany.chronos.testes.BaseTest;
import br.com.dbccompany.chronos.utils.PreloadData;
import io.qameta.allure.*;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class EdicaoClonarTest extends BaseTest {
    @Test
    @Tag("todos")
    @Tag("edicao")
    @Owner("Kevin Aryel")
    @Epic("Aceitação")
    @Feature("Edição")
    @Story("Clonar Edição")
    @Description("Deve clonar uma edição com sucesso")
    public void deveClonarUmaEdicaoComSucesso() {
        EdicaoDTO edicao = PreloadData.edicao();
        String idEdicao = edicao.getIdEdicao().toString();
        try {
            EdicaoDTO edicaoClonada = EdicaoClient.clonarEdicao(idEdicao,true)
                    .then()
                    .log().all()
                    .extract().as(EdicaoDTO.class)
                    ;
            EdicaoClient.deletarEdicao(edicaoClonada.getIdEdicao().toString(),true);
            Assert.assertTrue(edicaoClonada.getNome().contains(edicao.getNome()));
        } finally {
            EdicaoClient.deletarEdicao(idEdicao,true);
        }
    }
    @Test
    @Tag("todos")
    @Tag("edicao")
    @Owner("Kevin Aryel")
    @Epic("Aceitação")
    @Feature("Edição")
    @Story("Clonar Edição")
    @Description("Deve retornar erro ao tentar clonar uma edição com id inexistente")
    public void deveFalharClonarUmaEdicaoComIdInvalido() {
        EdicaoClient.clonarEdicao("0",true)
            .then()
                .log().all()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
        ;
    }
    @Test
    @Tag("todos")
    @Tag("edicao")
    @Owner("Kevin Aryel")
    @Epic("Aceitação")
    @Feature("Edição")
    @Story("Clonar Edição")
    @Description("Deve retornar erro ao tentar clonar uma edição sem auth")
    public void deveFalharClonarUmaEdicaoSemAuth(){
        EdicaoClient.clonarEdicao("0",false)
            .then()
                .log().all()
                .statusCode(HttpStatus.SC_FORBIDDEN)
        ;
    }

}
