package br.com.dbccompany.chronos.utils;

import br.com.dbccompany.chronos.data.changeless.LoginData;
import br.com.dbccompany.chronos.data.factory.LoginDataFactory;
import br.com.dbccompany.chronos.model.Login;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class Auth {
    public String autenticacaoQa(){
        Login login = LoginDataFactory.loginValidoComEmail();
        return
            given()
                .contentType(ContentType.JSON)
                .body(Utils.converterParaJson(login))
            .when()
                .post(LoginData.SERVICE)
            .then()
                .extract().asString()
            ;
    }
}
