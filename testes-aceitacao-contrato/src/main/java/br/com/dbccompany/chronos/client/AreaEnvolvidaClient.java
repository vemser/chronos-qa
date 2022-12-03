package br.com.dbccompany.chronos.client;

import br.com.dbccompany.chronos.data.changeless.AreaEnvolvidaData;
import br.com.dbccompany.chronos.specs.RequestSpec;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class AreaEnvolvidaClient {
    public static Response listarAreaEnvolvida(boolean auth){
        RequestSpecification spec = auth? RequestSpec.gestao() : RequestSpec.noAuth();
        return given()
                .spec(spec)
            .when()
                .get(AreaEnvolvidaData.SERVICE)
            ;
    }

    public static Response criarAreaEnvolvida(String json, boolean auth){
        RequestSpecification spec = auth ? RequestSpec.gestao() : RequestSpec.noAuth();
        return given()
                .spec(spec)
                .body(json)
            .when()
                .post(AreaEnvolvidaData.SERVICE)
            ;
    }
    public static Response deletarAreaEnvolvida(String id, boolean auth){
        RequestSpecification spec = auth ? RequestSpec.gestao() : RequestSpec.noAuth();
        return given()
                .spec(spec)
            .when()
                .delete(AreaEnvolvidaData.SERVICE+"/"+id)
            ;
    }
}
