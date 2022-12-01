package br.com.dbccompany.chronos.client;

import br.com.dbccompany.chronos.data.changeless.LoginData;
import br.com.dbccompany.chronos.specs.RequestSpec;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class LoginClient {
    public static Response fazerLogin(String json) {
          return given()
                .log().all()
                .spec(RequestSpec.noAuth())
                .body(json)
            .when()
              .post(LoginData.SERVICE)
            ;
    }
}
