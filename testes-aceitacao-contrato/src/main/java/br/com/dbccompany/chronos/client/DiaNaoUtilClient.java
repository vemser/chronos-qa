package br.com.dbccompany.chronos.client;

import br.com.dbccompany.chronos.data.changeless.DiaNaoUtilData;
import br.com.dbccompany.chronos.specs.RequestSpec;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class DiaNaoUtilClient {
    public static Response criarDiaNaoUtil(String json, boolean auth){
        RequestSpecification spec = auth ? RequestSpec.gestao() : RequestSpec.noAuth();
        return given()
                .spec(spec)
                .body(json)
            .when()
                .post(DiaNaoUtilData.SERVICE)
            ;
    }
    public static Response deletarDiaNaoUtil(String id, boolean auth){
        RequestSpecification spec = auth ? RequestSpec.gestao() : RequestSpec.noAuth();
        return given()
                .spec(spec)
            .when()
                .delete(DiaNaoUtilData.SERVICE+"/"+id)
            ;
    }
    public static Response listarDiaNaoUtil(boolean auth){
        RequestSpecification spec = auth ? RequestSpec.gestao() : RequestSpec.noAuth();
        return given()
                .spec(spec)
                .log().all()
            .when()
                .get(DiaNaoUtilData.SERVICE+"?pagina=0&tamanho=10")
            ;
    }
    public static Response editarDiaNaoUtil(String json, String id, boolean auth){
        RequestSpecification spec = auth ? RequestSpec.gestao() : RequestSpec.noAuth();
        return given()
                .spec(spec)
                .log().all()
                .body(json)
            .when()
                .put(DiaNaoUtilData.SERVICE+"/"+id)
            ;
    }
}
