package br.com.dbccompany.chronos.client;

import br.com.dbccompany.chronos.data.changeless.ProcessoData;
import br.com.dbccompany.chronos.specs.RequestSpec;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class ProcessoClient {

    public static Response listarProcessos (boolean auth) {
        RequestSpecification spec = auth ? RequestSpec.gestao() : RequestSpec.noAuth();
        return given()
                .spec(spec)
            .when()
                .get(ProcessoData.SERVICE+"?pagina=0&tamanho=10")
            ;
    }
    public static Response deletarProcesso (String idProcesso, boolean auth) {
        RequestSpecification spec = auth ? RequestSpec.gestao() : RequestSpec.noAuth();
        return given()
                .spec(spec)
            .when()
                .delete(ProcessoData.SERVICE+"/"+idProcesso)
            ;
    }
    public static Response listarProcessoPorId (String idProcesso, boolean auth) {
        RequestSpecification spec = auth ? RequestSpec.gestao() : RequestSpec.noAuth();
        return given()
                .spec(spec)
            .when()
                .get(ProcessoData.SERVICE+"/"+idProcesso)
            ;
    }
    public static Response cadastrarProcesso (String json,String idEtapa, boolean auth) {
        RequestSpecification spec = auth ? RequestSpec.gestao() : RequestSpec.noAuth();
        return given()
                .log().all()
                .spec(spec)
                .body(json)
            .when()
                .post(ProcessoData.SERVICE+"/"+idEtapa)
            ;
    }
    public static Response atualizarProcesso (String json, String idProcesso, boolean auth) {
        RequestSpecification spec = auth ? RequestSpec.gestao() : RequestSpec.noAuth();
        return given()
                .spec(spec)
                .body(json)
            .when()
                .put(ProcessoData.SERVICE+"/"+idProcesso)
            ;
    }
}
