package br.com.dbccompany.chronos.utils;

import br.com.dbccompany.chronos.data.changeless.LoginData;
import br.com.dbccompany.chronos.model.Login;
import com.google.gson.Gson;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class Auth {
    public String autenticacaoAdmin(){
        Login login =  new Login();
        login.setEmail(ConfigManipulation.getProp().getProperty("email"));
        login.setSenha(ConfigManipulation.getProp().getProperty("senha"));

        return
            given()
                .contentType(ContentType.JSON)
                .body(new Gson().toJson(login))
            .when()
                .post(LoginData.SERVICE)
            .then()
                .extract().asString()
            ;
    }
}
