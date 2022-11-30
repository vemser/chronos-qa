package br.com.dbccompany.chronos.client;

import br.com.dbccompany.chronos.data.changeless.UsuarioData;
import br.com.dbccompany.chronos.specs.UsuarioSpecs;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class UsuarioClient {

    public static Response listarUsuarios(boolean auth) {
        RequestSpecification spec = auth ? UsuarioSpecs.requestSpec() : UsuarioSpecs.requestSpecNoAuth();
        return given()
                .spec(spec)
            .when()
                .get(UsuarioData.SERVICE+"?pagina=0&tamanho=10")
            ;
        }

    public static Response cadastrarUsuario(String json,boolean auth){
        RequestSpecification spec = auth ? UsuarioSpecs.requestSpec() : UsuarioSpecs.requestSpecNoAuth();
        return given()
                .spec(spec)
                .body(json)
            .when()
                .post(UsuarioData.SERVICE)
            ;
    }
    public static Response atualizarPerfil(String json,boolean auth){
        RequestSpecification spec = auth ? UsuarioSpecs.requestSpec() : UsuarioSpecs.requestSpecNoAuth();
        return given()
                .spec(spec)
                .body(json)
            .when()
                .put(UsuarioData.SERVICE_UPDATE_PERFIL)
            ;
    }
    public static Response atualizarCadastro(String json,String id,boolean auth){
        RequestSpecification spec = auth ? UsuarioSpecs.requestSpec() : UsuarioSpecs.requestSpecNoAuth();
        return given()
                .spec(spec)
                .body(json)
            .when()
                .put(UsuarioData.SERVICE_UPDATE_CADASTRO+"/"+id)
            ;
    }
    public static Response mudarStatusUsuario(String id,boolean auth){
        RequestSpecification spec = auth ? UsuarioSpecs.requestSpec() : UsuarioSpecs.requestSpecNoAuth();
        return given()
                .spec(spec)
            .when()
                .put(UsuarioData.SERVICE_ENABLE_DISABLE+"/"+id)
            ;
    }
    public static Response uploadImagem(String json,String id,boolean auth){
        RequestSpecification spec = auth ? UsuarioSpecs.requestSpec() : UsuarioSpecs.requestSpecNoAuth();
        return given()
                .spec(spec)
                .body(json)
            .when()
                .post(UsuarioData.SERVICE_UPLOAD+'/'+id)
            ;
    }
    public static Response deletarUsuario(String id,boolean auth){
        RequestSpecification spec = auth ? UsuarioSpecs.requestSpec() : UsuarioSpecs.requestSpecNoAuth();
        return given()
                .spec(spec)
            .when()
                .delete(UsuarioData.SERVICE+'/'+id)
            ;
    }
}
