package br.com.dbccompany.chronos.testes.usuario;

import br.com.dbccompany.chronos.client.UsuarioClient;
import br.com.dbccompany.chronos.data.factory.PerfilDataFactory;
import br.com.dbccompany.chronos.dto.ResponseErrorBadDTO;
import br.com.dbccompany.chronos.dto.UsuarioDTO;
import br.com.dbccompany.chronos.model.Perfil;
import br.com.dbccompany.chronos.testes.BaseTest;
import br.com.dbccompany.chronos.utils.PreloadData;
import br.com.dbccompany.chronos.utils.Utils;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class UsuarioPerfilTest extends BaseTest {

    @Test
    @Tag("todos")
    @Tag("usuario")
    @Owner("Kevin Aryel")
    @Epic("Backend")
    @Feature("Usuário")
    @Story("Editar Perfil Usuário")
    @Description("Deve atualizar perfil com sucesso")
    public void deveAtualizarPerfilComSucesso(){
        Perfil perfil = PerfilDataFactory.perfilValido();
        try{
            UsuarioDTO response = UsuarioClient.atualizarPerfil(Utils.converterParaJson(perfil),true)
                    .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_OK).extract().as(UsuarioDTO.class);
            Assert.assertEquals(perfil.getNome(), response.getNome());

        }finally {
            PreloadData.restaurarPerfil(perfil.getNovaSenha());
        }
    }

    @Test
    @Tag("todos")
    @Tag("usuario")
    @Owner("Kevin Aryel")
    @Epic("Backend")
    @Feature("Usuário")
    @Story("Editar Perfil Usuário")
    @Description("Deve retornar erro ao tentar mudar perfil sem auth")
    public void deveFalharAtualizarPerfilSemAuth(){
        Perfil perfil = PerfilDataFactory.perfilValido();
        Response response = UsuarioClient.atualizarPerfil(Utils.converterParaJson(perfil),false)
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_FORBIDDEN).extract().response();
        Assert.assertEquals(response.statusCode(), HttpStatus.SC_FORBIDDEN);
    }
    @Test
    @Tag("todos")
    @Tag("usuario")
    @Owner("Kevin Aryel")
    @Epic("Backend")
    @Feature("Usuário")
    @Story("Editar Perfil Usuário")
    @Description("Deve retornar erro ao tentar atualizar perfil sem nome")
    public void deveFalharAtualizarPerfilSemNome(){
        Perfil perfil = PerfilDataFactory.perfilSemNome();
        ResponseErrorBadDTO response = UsuarioClient.atualizarPerfil(Utils.converterParaJson(perfil),true)
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_BAD_REQUEST).extract().as(ResponseErrorBadDTO.class);
        Assert.assertEquals(response.getStatus().intValue(), HttpStatus.SC_BAD_REQUEST);
    }
    @Test
    @Tag("todos")
    @Tag("usuario")
    @Owner("Kevin Aryel")
    @Epic("Backend")
    @Feature("Usuário")
    @Story("Editar Perfil Usuário")
    @Description("Deve retornar erro ao tentar atualizar perfil sem senhaAtual")
    public void deveFalharAtualizarPerfilSemSenhaAtual(){
        Perfil perfil = PerfilDataFactory.perfilSemSenhaAtual();
        ResponseErrorBadDTO response = UsuarioClient.atualizarPerfil(Utils.converterParaJson(perfil),true)
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_BAD_REQUEST).extract().as(ResponseErrorBadDTO.class);
        Assert.assertEquals(response.getStatus().intValue(), HttpStatus.SC_BAD_REQUEST);
    }
    @Test
    @Tag("todos")
    @Tag("usuario")
    @Owner("Kevin Aryel")
    @Epic("Backend")
    @Feature("Usuário")
    @Story("Editar Perfil Usuário")
    @Description("Deve retornar erro ao tentar atualizar perfil sem novaSenha")
    public void deveFalharAtualizarPerfilSemNovaSenha(){
        Perfil perfil = PerfilDataFactory.perfilSemNovaSenha();
        ResponseErrorBadDTO response = UsuarioClient.atualizarPerfil(Utils.converterParaJson(perfil),true)
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_BAD_REQUEST).extract().as(ResponseErrorBadDTO.class);
        Assert.assertEquals(response.getStatus().intValue(), HttpStatus.SC_BAD_REQUEST);
    }
    @Test
    @Tag("todos")
    @Tag("usuario")
    @Owner("Kevin Aryel")
    @Epic("Backend")
    @Feature("Usuário")
    @Story("Editar Perfil Usuário")
    @Description("Deve retornar erro ao tentar atualizar perfil sem confirmacaoNovaSenha")
    public void deveFalharAtualizarPerfilSemConfirmacaoNovaSenha(){
        Perfil perfil = PerfilDataFactory.perfilSemConfirmacaoNovaSenha();
        ResponseErrorBadDTO response = UsuarioClient.atualizarPerfil(Utils.converterParaJson(perfil),true)
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_BAD_REQUEST).extract().as(ResponseErrorBadDTO.class);
        Assert.assertEquals(response.getStatus().intValue(), HttpStatus.SC_BAD_REQUEST);
    }
    @Test
    @Tag("todos")
    @Tag("usuario")
    @Owner("Kevin Aryel")
    @Epic("Backend")
    @Feature("Usuário")
    @Story("Editar Perfil Usuário")
    @Description("Deve retornar erro ao tentar atualizar perfil com senhas diferentes")
    public void deveFalharAtualizarPerfilComSenhasDiferentes(){
        Perfil perfil = PerfilDataFactory.perfilComSenhasDiferentes();
        ResponseErrorBadDTO response = UsuarioClient.atualizarPerfil(Utils.converterParaJson(perfil),true)
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_BAD_REQUEST).extract().as(ResponseErrorBadDTO.class);
        Assert.assertEquals(response.getStatus().intValue(), HttpStatus.SC_BAD_REQUEST);
    }

}
