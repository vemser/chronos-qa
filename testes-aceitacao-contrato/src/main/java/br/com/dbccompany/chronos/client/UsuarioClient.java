package br.com.dbccompany.chronos.client;

import br.com.dbccompany.chronos.data.changeless.UsuarioData;
import br.com.dbccompany.chronos.specs.RequestSpec;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class UsuarioClient {

    public static Response listarUsuarios(boolean auth) {
        RequestSpecification spec = auth ? RequestSpec.geral() : RequestSpec.noAuth();
        return given()
                .spec(spec)
            .when()
                .get(UsuarioData.SERVICE+"?pagina=0&tamanho=10")
            ;
    }
    public static Response listarUsuariosComFiltro(boolean auth){
        RequestSpecification spec = auth ? RequestSpec.geral() : RequestSpec.noAuth();
        return given()
                .spec(spec)
            .when()
                .get(UsuarioData.SERVICE_FILTRADO+"?pagina=0&tamanho=10")
            ;
    }
    public static Response listarUsuarioLogado(boolean auth){
        RequestSpecification spec = auth ? RequestSpec.geral() : RequestSpec.noAuth();
        return given()
                .log().all()
                .spec(spec)
            .when()
                .get(UsuarioData.SERVICE_LOGADO)
            ;
    }
    public static Response cadastrarUsuario(String json,boolean auth){
        RequestSpecification spec = auth ? RequestSpec.geral() : RequestSpec.noAuth();
        return given()
                .log().all()
                .spec(spec)
                .body(json)
            .when()
                .post(UsuarioData.SERVICE)
            ;
    }
    public static Response atualizarCargo(String json,String id,boolean auth){
        RequestSpecification spec = auth ? RequestSpec.geral() : RequestSpec.noAuth();
        return given()
                .spec(spec)
                .log().all()
                .body(json)
            .when()
                .put(UsuarioData.SERVICE_UPDATE_CARGO+"/"+id)
            ;
    }
    public static Response deletarUsuario(String id,boolean auth){
        RequestSpecification spec = auth ? RequestSpec.geral() : RequestSpec.noAuth();
        return given()
                .spec(spec)
                .log().all()
            .when()
                .delete(UsuarioData.SERVICE+'/'+id)
            ;
    }
}
