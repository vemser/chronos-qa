package br.com.dbccompany.chronos.testes.aceitacao.edicao;

import br.com.dbccompany.chronos.client.EdicaoClient;
import br.com.dbccompany.chronos.dto.CalendarioEdicaoItemDTO;
import br.com.dbccompany.chronos.dto.EdicaoDTO;
import br.com.dbccompany.chronos.utils.PreloadData;
import io.qameta.allure.*;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class EdicaoCalendarioEdicaoTest {

    @Test
    @Tag("todos")
    @Tag("edicao")
    @Owner("Kevin Aryel")
    @Epic("Backend")
    @Feature("Calendário")
    @Story("Listar Calendario Geral Edição")
    @Description("Deve listar calendario da edição com sucesso")
    public void deveFalharListarCalendarioDaEdicaoSemAuth(){
        EdicaoDTO edicao = PreloadData.edicao();
        String idEdicao = edicao.getIdEdicao().toString();
        try{
            CalendarioEdicaoItemDTO[] response = EdicaoClient.listarCalendarioEdicao(idEdicao,true)
                .then()
                    .log().all()
                    .statusCode(200)
                    .extract().as(CalendarioEdicaoItemDTO[].class)
                ;
        } finally {
            EdicaoClient.deletarEdicao(idEdicao,true);
        }
    }

}
