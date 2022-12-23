package br.com.dbccompany.chronos.testes.aceitacao.usuario;
import br.com.dbccompany.chronos.client.UsuarioClient;
import br.com.dbccompany.chronos.data.factory.CargoDataFactory;
import br.com.dbccompany.chronos.data.factory.UserDataFactory;
import br.com.dbccompany.chronos.dto.ResponseErrorBadDTO;
import br.com.dbccompany.chronos.dto.UsuarioDTO;
import br.com.dbccompany.chronos.model.Cargo;
import br.com.dbccompany.chronos.model.User;
import br.com.dbccompany.chronos.testes.BaseTest;
import br.com.dbccompany.chronos.utils.PreloadData;
import br.com.dbccompany.chronos.utils.Utils;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;

public class UsuarioCargoTest extends BaseTest {

    @Test
    @Tag("todos")
    @Tag("usuario")
    @Owner("Kevin Aryel")
    @Epic("Aceitação")
    @Feature("Usuário")
    @Story("Editar Cargos Usuário")
    @Description("Deve editar o cargo com um item com sucesso")
    public void deveEditarCargoUnicoComSucesso(){
        UsuarioDTO usuario = PreloadData.userAdmin();
        String idUsuario = usuario.getIdUsuario().toString();
        try{
            Cargo[] cargos = CargoDataFactory.cargoUnico();
            UsuarioDTO response = UsuarioClient.atualizarCargo(Utils.converterParaJson(cargos),idUsuario,true)
                    .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_OK).extract().as(UsuarioDTO.class);
        }finally {
            UsuarioClient.deletarUsuario(idUsuario,true);
        }
    }

    @Test
    @Tag("todos")
    @Tag("usuario")
    @Owner("Kevin Aryel")
    @Epic("Aceitação")
    @Feature("Usuário")
    @Story("Editar Cargos Usuário")
    @Description("Deve editar o cargo com dois itens com sucesso")
    public void deveEditarCargoDuploComSucesso(){
        UsuarioDTO usuario = PreloadData.userAdmin();
        String idUsuario = usuario.getIdUsuario().toString();
        try{
            Cargo[] cargos = CargoDataFactory.cargoDuplo();
            UsuarioDTO response = UsuarioClient.atualizarCargo(Utils.converterParaJson(cargos),idUsuario,true)
                    .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_OK).extract().as(UsuarioDTO.class);
        }finally {
            UsuarioClient.deletarUsuario(idUsuario,true);
        }
    }

    @Test
    @Tag("todos")
    @Tag("usuario")
    @Owner("Kevin Aryel")
    @Epic("Aceitação")
    @Feature("Usuário")
    @Story("Editar Cargos Usuário")
    @Description("Deve retornar erro ao editar cargos sem auth")
    public void deveFalharEditarCargosSemAuth(){
        Cargo[] cargos = CargoDataFactory.cargoUnico();
        Response response = UsuarioClient.atualizarCargo(Utils.converterParaJson(cargos),"2",false)
            .then()
                .log().all()
                .statusCode(HttpStatus.SC_FORBIDDEN).extract().response();
        Assert.assertEquals(response.statusCode(), HttpStatus.SC_FORBIDDEN);
    }
    @Test
    @Tag("todos")
    @Tag("usuario")
    @Owner("Kevin Aryel")
    @Epic("Aceitação")
    @Feature("Usuário")
    @Story("Editar Cargos Usuário")
    @Description("Deve retornar erro ao editar cargos com id inválido")
    public void deveFalharEditarCargosComIdInvalido(){
        Cargo[] cargos = CargoDataFactory.cargoUnico();
        ResponseErrorBadDTO response = UsuarioClient.atualizarCargo(Utils.converterParaJson(cargos),"0",true)
            .then()
                .log().all()
                .statusCode(HttpStatus.SC_BAD_REQUEST).extract().as(ResponseErrorBadDTO.class);
        Assert.assertEquals(response.getStatus().intValue(), HttpStatus.SC_BAD_REQUEST);
    }

    @Test
    @Tag("todos")
    @Tag("usuario")
    @Owner("Kevin Aryel")
    @Epic("Aceitação")
    @Feature("Usuário")
    @Story("Editar Cargos Usuário")
    @Description("Deve retornar erro ao editar cargos com cargos inválidos")
    public void deveFalharEditarCargosComCargosInvalido(){
        UsuarioDTO usuario = PreloadData.userAdmin();
        String idUsuario = usuario.getIdUsuario().toString();
        try{
            Cargo[] cargos = CargoDataFactory.cargosInvalido();
            ResponseErrorBadDTO response = UsuarioClient.atualizarCargo(Utils.converterParaJson(cargos),idUsuario,true)
                    .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_BAD_REQUEST).extract().as(ResponseErrorBadDTO.class);
           Assert.assertEquals(response.getStatus().intValue(), HttpStatus.SC_BAD_REQUEST);
        } finally {
            UsuarioClient.deletarUsuario(idUsuario,true);
        }
    }
    @Test
    @Tag("todos")
    @Tag("usuario")
    @Owner("Kevin Aryel")
    @Epic("Aceitação")
    @Feature("Usuário")
    @Story("Editar Cadastro Usuário")
    @Tag("atual")
    @Description("Deve retornar erro ao editar cargos com cargo vazio")
    public void deveFalharEditarCargosComCargosVazio(){
        UsuarioDTO usuario = PreloadData.userAdmin();
        String idUsuario = usuario.getIdUsuario().toString();
        try{
            Cargo[] cargos = CargoDataFactory.cargosVazio();
            ResponseErrorBadDTO response = UsuarioClient.atualizarCargo(Utils.converterParaJson(cargos),idUsuario,true)
                    .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_BAD_REQUEST).extract().as(ResponseErrorBadDTO.class);
            assertAll("response",
                    () ->Assert.assertEquals(response.getStatus().intValue(), HttpStatus.SC_BAD_REQUEST)
            );
        } finally {
            UsuarioClient.deletarUsuario(idUsuario,true);
        }
    }
}
