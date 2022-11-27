package br.com.dbccompany.chronos.client;

import br.com.dbccompany.chronos.data.changeless.LoginData;
import br.com.dbccompany.chronos.specs.LoginSpecs;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class LoginClient {
    public static Response fazerLogin(String json) {
          return given()
                  .spec(LoginSpecs.requestSpec())
                  .when()
                  .post(LoginData.SERVICE,json);
    }
}
