package br.com.dbccompany.chronos.client;

import br.com.dbccompany.chronos.data.changeless.EdicaoData;
import br.com.dbccompany.chronos.specs.RequestSpec;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class EdicaoClient {

    public static Response clonarEdicao(String idEdicao, boolean auth){
        RequestSpecification spec = auth ? RequestSpec.gestao() : RequestSpec.noAuth();
        return given()
                .spec(spec)
                .when()
                .post(EdicaoData.SERVICE_CLONAR+"/"+idEdicao)
                ;
    }

    public static Response listarEdicoes (boolean auth) {
        RequestSpecification spec = auth ? RequestSpec.gestao() : RequestSpec.noAuth();
        return given()
                .spec(spec)
            .when()
                .get(EdicaoData.SERVICE_LISTAR+"?pagina=0&tamanho=10")
            ;
    }

    public static Response deletarEdicao (String id, boolean auth) {
        RequestSpecification spec = auth ? RequestSpec.gestao() : RequestSpec.noAuth();
        return given()
                .spec(spec)
            .when()
                .delete(EdicaoData.SERVICE+"/"+id)
            ;
    }
    public static Response alterarStatusEdicao (String id, boolean auth) {
        RequestSpecification spec = auth ? RequestSpec.gestao() : RequestSpec.noAuth();
        return given()
                .spec(spec)
            .when()
                .put(EdicaoData.SERVICE_ENABLE_DISABLE+"/"+id)
            ;
    }
    public static Response cadastrarEdicao (String json, boolean auth) {
        RequestSpecification spec = auth ? RequestSpec.gestao() : RequestSpec.noAuth();
        return given()
                .log().all()
                .spec(spec)
                .body(json)
            .when()
                .post(EdicaoData.SERVICE)
            ;
    }
    public static Response atualizarEdicao (String json, String id, boolean auth) {
        RequestSpecification spec = auth ? RequestSpec.gestao() : RequestSpec.noAuth();
        return given()
                .spec(spec)
                .body(json)
            .when()
                .put(EdicaoData.SERVICE+"/"+id)
            ;
    }
    public static Response listarCalendarioGeral (boolean auth) {
        RequestSpecification spec = auth ? RequestSpec.gestao() : RequestSpec.noAuth();
        return given()
                .spec(spec)
            .when()
                .get(EdicaoData.SERVICE_CALENDARIO_GERAL)
            ;
    }
    public static Response listarCalendarioEdicao (String id, boolean auth) {
        RequestSpecification spec = auth ? RequestSpec.gestao() : RequestSpec.noAuth();
        return given()
                .spec(spec)
            .when()
                .get(EdicaoData.SERVICE_CALENDARIO_EDICAO+"/"+id)
            ;
    }
}
