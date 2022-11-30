package br.com.dbccompany.chronos.testes.backend.tests;
import br.com.dbccompany.chronos.client.UsuarioClient;
import br.com.dbccompany.chronos.data.factory.UserDataFactory;
import br.com.dbccompany.chronos.dto.ResponseErrorBadDTO;
import br.com.dbccompany.chronos.dto.ResponseListUserDTO;
import br.com.dbccompany.chronos.dto.UsuarioDTO;
import br.com.dbccompany.chronos.model.User;
import br.com.dbccompany.chronos.model.UserBuilder;
import br.com.dbccompany.chronos.testes.backend.base.BaseTest;
import br.com.dbccompany.chronos.utils.Utils;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertAll;

public class UsuarioTest extends BaseTest {

    @Test
    @Tag("todos")
    @Tag("usuario")
    @Description("Deve listar todos usuarios com auth de  sem dados")
    public void deveListarUsuarioComSucesso() {
        ResponseListUserDTO response = UsuarioClient.listarUsuarios(true)
                .then()
                .extract().as(ResponseListUserDTO.class);
        assertAll("response",
                () -> Assert.assertEquals(0, response.getPagina().intValue()),
                () -> Assert.assertTrue(response.getTotalElementos().intValue() > 3)
        );
    }

    @Test
    @Tag("todos")
    @Tag("usuario")
    @Description("Deve falhar listar todos usuarios sem auth")
    public void deveFalharListarUsuarioSemAuth() {
        Response response = UsuarioClient.listarUsuarios(false)
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_FORBIDDEN).extract().response();
        Assert.assertEquals(response.statusCode(), HttpStatus.SC_FORBIDDEN);
    }

    @Test
    @Tag("todos")
    @Tag("usuario")
    @Description("Deve falhar criar usuario sem auth")
    public void deveFalharCriarUsuarioSemAuth() {
        User user = UserDataFactory.usuarioValido();
        Response response = UsuarioClient.cadastrarUsuario(Utils.converterParaJson(user),false)
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_FORBIDDEN).extract().response();
        Assert.assertEquals(response.statusCode(), HttpStatus.SC_FORBIDDEN);
    }

    @Test
    @Tag("todos")
    @Tag("usuario")
    @Description("Deve falhar criar usuario com email invalido")
    public void deveFalharCriarUsuarioEmailInvalido(){
        User user = UserDataFactory.userComEmailInvalido();
        ResponseErrorBadDTO response = UsuarioClient.cadastrarUsuario(Utils.converterParaJson(user),true)
            .then()
            .log().all()
            .statusCode(HttpStatus.SC_BAD_REQUEST).extract().as(ResponseErrorBadDTO.class);
        Assert.assertEquals(response.getStatus().intValue(), HttpStatus.SC_BAD_REQUEST);
        Assert.assertTrue(response.getErrors()[0].contains("email:"));
    }

    @Test
    @Tag("todos")
    @Tag("usuario")
    @Description("Deve falhar criar usuario com nome invalido")
    public void deveFalharCriarUsuarioNomeInvalido(){
        User user = UserDataFactory.userComNomeInvalido();
        ResponseErrorBadDTO response = UsuarioClient.cadastrarUsuario(Utils.converterParaJson(user),true)
            .then()
            .log().all()
            .statusCode(HttpStatus.SC_BAD_REQUEST).extract().as(ResponseErrorBadDTO.class);
        Assert.assertEquals(response.getStatus().intValue(), HttpStatus.SC_BAD_REQUEST);
        Assert.assertTrue(response.getErrors()[0].contains("nome:"));
    }
    @Test
    @Tag("todos")
    @Tag("usuario")
    @Description("Deve falhar criar usuario com cargo invalido")
    public void deveFalharCriarUsuarioCargosInvalido(){
        User user = UserDataFactory.userComCargoInvalido();
        ResponseErrorBadDTO response = UsuarioClient.cadastrarUsuario(Utils.converterParaJson(user),true)
            .then()
            .log().all()
            .statusCode(HttpStatus.SC_BAD_REQUEST).extract().as(ResponseErrorBadDTO.class);
        Assert.assertEquals(response.getStatus().intValue(), HttpStatus.SC_BAD_REQUEST);
        Assert.assertTrue(response.getErrors()[0].contains("cargos:"));
    }
    @Test
    @Tag("todos")
    @Tag("usuario")
    @Description("Deve falhar criar usuario sem nome")
    public void deveFalharCriarUsuarioSemNome(){
        User user = UserDataFactory.userSemNome();
        ResponseErrorBadDTO response = UsuarioClient.cadastrarUsuario(Utils.converterParaJson(user),true)
            .then()
            .log().all()
            .statusCode(HttpStatus.SC_BAD_REQUEST).extract().as(ResponseErrorBadDTO.class);
        Assert.assertEquals(response.getStatus().intValue(), HttpStatus.SC_BAD_REQUEST);
        Assert.assertTrue(response.getErrors()[0].contains("nome:"));
    }

    @Test
    @Tag("todos")
    @Tag("usuario")
    @Description("Deve falhar criar usuario sem email")
    public void deveFalharCriarUsuarioSemEmail(){
        User user = UserDataFactory.userSemEmail();
        ResponseErrorBadDTO response = UsuarioClient.cadastrarUsuario(Utils.converterParaJson(user),true)
            .then()
            .log().all()
            .statusCode(HttpStatus.SC_BAD_REQUEST).extract().as(ResponseErrorBadDTO.class);
        Assert.assertEquals(response.getStatus().intValue(), HttpStatus.SC_BAD_REQUEST);
        Assert.assertTrue(response.getErrors()[0].contains("email:"));
    }
    @Test
    @Tag("todos")
    @Tag("usuario")
    @Description("Deve falhar criar usuario sem cargo")
    public void deveFalharCriarUsuarioSemCargo(){
        User user = UserDataFactory.userSemCargo();
        ResponseErrorBadDTO response = UsuarioClient.cadastrarUsuario(Utils.converterParaJson(user),true)
            .then()
            .log().all()
            .statusCode(HttpStatus.SC_BAD_REQUEST).extract().as(ResponseErrorBadDTO.class);
        Assert.assertEquals(response.getStatus().intValue(), HttpStatus.SC_BAD_REQUEST);
        Assert.assertTrue(response.getErrors()[0].contains("cargos:"));
    }

    @Test
    @Tag("todos")
    @Tag("usuario")
    @Description("Deve falhar criar usuario com email duplicado")
    public void deveFalharCriarUsuarioEmailDuplicado(){
        User user = UserDataFactory.userComEmailDuplicado();
        ResponseErrorBadDTO response = UsuarioClient.cadastrarUsuario(Utils.converterParaJson(user),true)
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_BAD_REQUEST).extract().as(ResponseErrorBadDTO.class);
        Assert.assertEquals(response.getStatus().intValue(), HttpStatus.SC_BAD_REQUEST);
        Assert.assertTrue(response.getErrors()[0].contains("email:"));
    }

    @Test
    @Tag("todos")
    @Tag("usuario")
    @Description("Deve criar usuario com sucesso")
    public void deveCriarUsuarioComSucesso(){
        User user = UserDataFactory.usuarioValido();
         UsuarioDTO response = UsuarioClient.cadastrarUsuario(Utils.converterParaJson(user),true)
            .then()
                .log().all()
                .statusCode(HttpStatus.SC_OK).extract().as(UsuarioDTO.class)
            ;
         assertAll("Usuario",
             () -> Assert.assertEquals(response.getStatus(), "ATIVO"),
             () -> Assert.assertEquals(response.getNome(), user.getNome())
         );
         UsuarioClient.deletarUsuario(response.getIdUsuario().toString(),true);
    }

    @Test
    @Tag("todos")
    @Tag("usuario")
    @Description("Deve falhar deletar usuario sem auth")
    public void deveFalharDeletarUsuarioSemAuth(){
        Response response = UsuarioClient.deletarUsuario("1",false)
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_FORBIDDEN).extract().response();
        Assert.assertEquals(response.statusCode(), HttpStatus.SC_FORBIDDEN);
    }

    @Test
    @Tag("todos")
    @Tag("usuario")
    @Description("Deve falhar deletar usuario com id inválido")
    public void deveFalharDeletarUsuarioComIdInvalido(){
        ResponseErrorBadDTO response = UsuarioClient.deletarUsuario("0",true)
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_BAD_REQUEST).extract().as(ResponseErrorBadDTO.class);
        Assert.assertEquals(response.getStatus().intValue(), HttpStatus.SC_NOT_FOUND);
        Assert.assertTrue(response.getErrors()[0].contains("id:"));
    }

    @Test
    @Tag("todos")
    @Tag("usuario")
    @Description("Deve deletar usuario com sucesso")
    public void deveDeletarUsuarioComSucesso(){
        User user = UserDataFactory.usuarioValido();
        UsuarioDTO usuario = UsuarioClient.cadastrarUsuario(Utils.converterParaJson(user),true)
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_OK).extract().as(UsuarioDTO.class);
        Response response = UsuarioClient.deletarUsuario(usuario.getIdUsuario().toString(),true)
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_NO_CONTENT).extract().response();
        Assert.assertEquals(response.statusCode(), HttpStatus.SC_NO_CONTENT);
    }

    @Test
    @Tag("todos")
    @Tag("usuario")
    @Description("Deve falhar mudar status sem auth")
    public void deveFalharMudarStatusSemAuth(){
        Response response = UsuarioClient.mudarStatusUsuario("1",false)
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_FORBIDDEN).extract().response();
        Assert.assertEquals(response.statusCode(), HttpStatus.SC_FORBIDDEN);
    }

    @Test
    @Tag("todos")
    @Tag("usuario")
    @Description("Deve falhar mudar status com id inválido")
    public void deveFalharMudarStatusComIdInvalido(){
        ResponseErrorBadDTO response = UsuarioClient.mudarStatusUsuario("0",true)
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_BAD_REQUEST).extract().as(ResponseErrorBadDTO.class);
        Assert.assertEquals(response.getStatus().intValue(), HttpStatus.SC_NOT_FOUND);
        Assert.assertTrue(response.getErrors()[0].contains("id:"));
    }

    @Test
    @Tag("todos")
    @Tag("usuario")
    @Description("Deve mudar status com sucesso")
    public void deveMudarStatusComSucesso(){
        User user = UserDataFactory.usuarioValido();
        UsuarioDTO usuario = UsuarioClient.cadastrarUsuario(Utils.converterParaJson(user),true)
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_OK).extract().as(UsuarioDTO.class);
        String idUsuario = usuario.getIdUsuario().toString();
        Response response = UsuarioClient.mudarStatusUsuario(idUsuario,true)
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_NO_CONTENT).extract().response();
        Assert.assertEquals(response.statusCode(), HttpStatus.SC_NO_CONTENT);
        UsuarioClient.deletarUsuario(idUsuario,true);
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
        Assert.assertTrue(response.getErrors()[0].contains("id:"));
    }

    @Test
    @Tag("todos")
    @Tag("usuario")
    @Description("Deve falhar atualizar cadastro com nome inválido")
    public void deveFalharAtualizarCadastroComNomeInvalido(){
        User user = UserDataFactory.usuarioValido();
        UsuarioDTO usuario = UsuarioClient.cadastrarUsuario(Utils.converterParaJson(user),true)
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_OK).extract().as(UsuarioDTO.class);
        String idUsuario = usuario.getIdUsuario().toString();
        User cadastro = UserDataFactory.cadastroComNomeInvalido();
        ResponseErrorBadDTO response = UsuarioClient.atualizarCadastro(Utils.converterParaJson(cadastro),id,true)
            .then()
                .log().all()
                .statusCode(HttpStatus.SC_BAD_REQUEST).extract().as(ResponseErrorBadDTO.class);
        assertAll("response",
                () ->Assert.assertEquals(response.getStatus().intValue(), HttpStatus.SC_BAD_REQUEST),
                ()->Assert.assertTrue(response.getErrors()[0].contains("nome:"))
        );
        UsuarioClient.deletarUsuario(idUsuario,true);
    }

    @Test
    @Tag("todos")
    @Tag("usuario")
    @Description("Deve falhar atualizar cadastro com cargos inválidos")
    public void deveFalharAtualizarCadastroComCargosInvalidos(){
        User user = UserDataFactory.usuarioValido();
        UsuarioDTO usuario = UsuarioClient.cadastrarUsuario(Utils.converterParaJson(user),true)
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_OK).extract().as(UsuarioDTO.class);
        String idUsuario = usuario.getIdUsuario().toString();
        User cadastro = UserDataFactory.cadastroComCargoInvalido();
        ResponseErrorBadDTO response = UsuarioClient.atualizarCadastro(Utils.converterParaJson(cadastro),id,true)
            .then()
                .log().all()
                .statusCode(HttpStatus.SC_BAD_REQUEST).extract().as(ResponseErrorBadDTO.class);
        assertAll("response",
                () ->Assert.assertEquals(response.getStatus().intValue(), HttpStatus.SC_BAD_REQUEST),
                ()->Assert.assertTrue(response.getErrors()[0].contains("cargos:"))
        );
        UsuarioClient.deletarUsuario(idUsuario,true);
    }
    @Test
    @Tag("todos")
    @Tag("usuario")
    @Description("Deve falhar atualizar cadastro sem nome")
    public void deveFalharAtualizarCadastroSemNome(){
        User user = UserDataFactory.usuarioValido();
        UsuarioDTO usuario = UsuarioClient.cadastrarUsuario(Utils.converterParaJson(user),true)
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_OK).extract().as(UsuarioDTO.class);
        String idUsuario = usuario.getIdUsuario().toString();
        User cadastro = UserDataFactory.cadastroSemNome();
        ResponseErrorBadDTO response = UsuarioClient.atualizarCadastro(Utils.converterParaJson(cadastro),idUsuario,true)
            .then()
                .log().all()
                .statusCode(HttpStatus.SC_BAD_REQUEST).extract().as(ResponseErrorBadDTO.class);
        assertAll("response",
                () ->Assert.assertEquals(response.getStatus().intValue(), HttpStatus.SC_BAD_REQUEST),
                ()->Assert.assertTrue(response.getErrors()[0].contains("nome:"))
        );
    }
    @Test
    @Tag("todos")
    @Tag("usuario")
    @Description("Deve falhar atualizar cadastro sem cargos")
    public void deveFalharAtualizarCadastroSemCargos(){
        User user = UserDataFactory.usuarioValido();
        UsuarioDTO usuario = UsuarioClient.cadastrarUsuario(Utils.converterParaJson(user),true)
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_OK).extract().as(UsuarioDTO.class);
        String idUsuario = usuario.getIdUsuario().toString();
        User cadastro = UserDataFactory.cadastroSemCargo();
        ResponseErrorBadDTO response = UsuarioClient.atualizarCadastro(Utils.converterParaJson(cadastro),idUsuario,true)
            .then()
                .log().all()
                .statusCode(HttpStatus.SC_BAD_REQUEST).extract().as(ResponseErrorBadDTO.class);
        assertAll("response",
                () ->Assert.assertEquals(response.getStatus().intValue(), HttpStatus.SC_BAD_REQUEST),
                ()->Assert.assertTrue(response.getErrors()[0].contains("cargos:"))
        );
        UsuarioClient.deletarUsuario(idUsuario,true);
    }

    @Test
    @Tag("todos")
    @Tag("usuario")
    @Description("Deve atualizar cadastro com sucesso")
    public void deveAtualizarCadastroComSucesso(){
        User user = UserDataFactory.usuarioValido();
        UsuarioDTO usuario = UsuarioClient.cadastrarUsuario(Utils.converterParaJson(user),true)
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_OK).extract().as(UsuarioDTO.class);
        String idUsuario = usuario.getIdUsuario().toString();
        User cadastro = UserDataFactory.cadastroValido();
        UsuarioDTO response = UsuarioClient.atualizarCadastro(Utils.converterParaJson(cadastro),idUsuario,true)
            .then()
                .log().all()
                .statusCode(HttpStatus.SC_OK).extract().as(UsuarioDTO.class);
        assertAll("response",
                () ->Assert.assertEquals(response.getNome(), cadastro.getNome()),
                ()->Assert.assertEquals(response.getCargos()[0], cadastro.getCargos()[0])
        );
        UsuarioClient.deletarUsuario(idUsuario,true);
    }
}
