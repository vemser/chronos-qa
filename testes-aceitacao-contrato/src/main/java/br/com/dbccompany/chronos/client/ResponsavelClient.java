package br.com.dbccompany.chronos.client;

import br.com.dbccompany.chronos.data.changeless.ResponsavelData;
import br.com.dbccompany.chronos.specs.RequestSpec;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class ResponsavelClient {
    public static Response criarResponsavel(String json, boolean auth){
        RequestSpecification spec = auth ? RequestSpec.gestao() : RequestSpec.noAuth();
        return given()
                .spec(spec)
                .body(json)
            .when()
                .post(ResponsavelData.SERVICE)
            ;
    }
    public static Response deletarResponsavel(String id, boolean auth){
        RequestSpecification spec = auth ? RequestSpec.gestao() : RequestSpec.noAuth();
        return given()
                .spec(spec)
            .when()
                .delete(ResponsavelData.SERVICE+"/"+id)
            ;
    }
}
