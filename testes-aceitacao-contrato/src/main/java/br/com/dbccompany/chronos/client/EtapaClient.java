package br.com.dbccompany.chronos.client;

import br.com.dbccompany.chronos.data.changeless.EtapaData;
import br.com.dbccompany.chronos.specs.RequestSpec;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class EtapaClient {

    public static Response listarEtapa(boolean auth){
        RequestSpecification spec = auth ? RequestSpec.gestao() : RequestSpec.noAuth();
        return given()
                .spec(spec)
            .when()
                .get(EtapaData.SERVICE+"?pagina=0&tamanho=10")
            ;
    }

    public static Response deletarEtapa (String id, boolean auth){
        RequestSpecification spec = auth ? RequestSpec.gestao() : RequestSpec.noAuth();
        return given()
                .spec(spec)
            .when()
                .delete(EtapaData.SERVICE+"/"+id)
            ;
    }

    public static Response criarEtapa (String json,String idEdicao, boolean auth){
        RequestSpecification spec = auth ? RequestSpec.gestao() : RequestSpec.noAuth();
        return given()
                .spec(spec)
                .body(json)
            .when()
                .post(EtapaData.SERVICE+"/"+idEdicao)
            ;
    }
    public static Response atualizarEtapa (String json,String id, boolean auth){
        RequestSpecification spec = auth ? RequestSpec.gestao() : RequestSpec.noAuth();
        return given()
                .spec(spec)
                .body(json)
            .when()
                .put(EtapaData.SERVICE+"/"+id)
            ;
    }

    public static Response listarEtapaPorId(String idEtapa, boolean auth){
        RequestSpecification spec = auth ? RequestSpec.gestao() : RequestSpec.noAuth();
        return given()
                .spec(spec)
            .when()
                .get(EtapaData.SERVICE+"/"+idEtapa)
            ;
    }
}
