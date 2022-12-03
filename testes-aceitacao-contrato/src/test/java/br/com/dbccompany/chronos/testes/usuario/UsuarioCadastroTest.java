package br.com.dbccompany.chronos.testes.usuario;
import br.com.dbccompany.chronos.client.UsuarioClient;
import br.com.dbccompany.chronos.data.factory.UserDataFactory;
import br.com.dbccompany.chronos.data.preloadAndRestore.UserPreloadData;
import br.com.dbccompany.chronos.dto.ResponseErrorBadDTO;
import br.com.dbccompany.chronos.dto.UsuarioDTO;
import br.com.dbccompany.chronos.model.User;
import br.com.dbccompany.chronos.testes.BaseTest;
import br.com.dbccompany.chronos.utils.Utils;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;

public class UsuarioCadastroTest extends BaseTest {

    @Test
    @Tag("todos")
    @Tag("usuario")
    @Description("Deve atualizar cadastro com sucesso")
    public void deveAtualizarCadastroComSucesso(){
        UsuarioDTO usuario = UserPreloadData.userAdmin();
        String idUsuario = usuario.getIdUsuario().toString();
        try{
            User cadastro = UserDataFactory.cadastroValido();
            UsuarioDTO response = UsuarioClient.atualizarCadastro(Utils.converterParaJson(cadastro),idUsuario,true)
                    .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_OK).extract().as(UsuarioDTO.class);
            assertAll("response",
                    () ->Assert.assertEquals(response.getNome(), cadastro.getNome()),
                    ()->Assert.assertEquals(response.getCargos()[0].getNome(), cadastro.getCargos()[0])
            );
        }finally {
            UsuarioClient.deletarUsuario(idUsuario,true);
        }
    }

    @Test
    @Tag("todos")
    @Tag("usuario")
    @Description("Deve falhar atualizar cadastro sem auth")
    public void deveFalharAtualizarCadastroSemAuth(){
        User cadastro = UserDataFactory.cadastroValido();
        Response response = UsuarioClient.atualizarCadastro(Utils.converterParaJson(cadastro),"2",false)
            .then()
                .log().all()
                .statusCode(HttpStatus.SC_FORBIDDEN).extract().response();
        Assert.assertEquals(response.statusCode(), HttpStatus.SC_FORBIDDEN);
    }
    @Test
    @Tag("todos")
    @Tag("usuario")
    @Description("Deve falhar atualizar cadastro com id inválido")
    public void deveFalharAtualizarCadastroComIdInvalido(){
        User cadastro = UserDataFactory.cadastroValido();
        ResponseErrorBadDTO response = UsuarioClient.atualizarCadastro(Utils.converterParaJson(cadastro),"0",true)
            .then()
                .log().all()
                .statusCode(HttpStatus.SC_BAD_REQUEST).extract().as(ResponseErrorBadDTO.class);
        Assert.assertEquals(response.getStatus().intValue(), HttpStatus.SC_BAD_REQUEST);
    }

    @Test
    @Tag("todos")
    @Tag("usuario")
    @Description("Deve falhar atualizar cadastro com cargos inválidos")
    public void deveFalharAtualizarCadastroComCargosInvalidos(){
        UsuarioDTO usuario = UserPreloadData.userAdmin();
        String idUsuario = usuario.getIdUsuario().toString();
        try{
            User cadastro = UserDataFactory.cadastroComCargoInvalido();
            ResponseErrorBadDTO response = UsuarioClient.atualizarCadastro(Utils.converterParaJson(cadastro),idUsuario,true)
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
    @Test
    @Tag("todos")
    @Tag("usuario")
    @Description("Deve falhar atualizar cadastro com cargo vazio")
    public void deveFalharAtualizarCadastroComCargoVazio(){
        UsuarioDTO usuario = UserPreloadData.userAdmin();
        String idUsuario = usuario.getIdUsuario().toString();
        try{
            User cadastro = UserDataFactory.cadastroComCargoVazio();
            ResponseErrorBadDTO response = UsuarioClient.atualizarCadastro(Utils.converterParaJson(cadastro),idUsuario,true)
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
    @Test
    @Tag("todos")
    @Tag("usuario")
    @Description("Deve falhar atualizar cadastro sem cargos")
    public void deveFalharAtualizarCadastroSemCargos(){
        UsuarioDTO usuario = UserPreloadData.userAdmin();
        String idUsuario = usuario.getIdUsuario().toString();
        try{
            User cadastro = UserDataFactory.cadastroSemCargo();
            ResponseErrorBadDTO response = UsuarioClient.atualizarCadastro(Utils.converterParaJson(cadastro),idUsuario,true)
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
    @Test
    @Tag("todos")
    @Tag("usuario")
    @Description("Deve falhar atualizar cadastro sem nome")
    public void deveFalharAtualizarCadastroSemNome(){
        UsuarioDTO usuario = UserPreloadData.userAdmin();
        String idUsuario = usuario.getIdUsuario().toString();
        try{
            User cadastro = UserDataFactory.cadastroSemNome();
            ResponseErrorBadDTO response = UsuarioClient.atualizarCadastro(Utils.converterParaJson(cadastro),idUsuario,true)
                    .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_BAD_REQUEST).extract().as(ResponseErrorBadDTO.class);
            assertAll("response",
                    () ->Assert.assertEquals(response.getStatus().intValue(), HttpStatus.SC_BAD_REQUEST)
            );
        }finally {
            UsuarioClient.deletarUsuario(idUsuario,true);
        }
    }

}