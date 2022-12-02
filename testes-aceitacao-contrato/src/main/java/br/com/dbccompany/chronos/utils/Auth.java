package br.com.dbccompany.chronos.utils;

import br.com.dbccompany.chronos.data.changeless.LoginData;
import br.com.dbccompany.chronos.model.Login;
import com.google.gson.Gson;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class Auth {
    public String autenticacaoAdmin(){
        Login login =  new Login();
        login.setEmail(ConfigManipulation.getProp().getProperty("emailAdm"));
        login.setSenha(ConfigManipulation.getProp().getProperty("senhaAdm"));

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
    public String autenticacaoUserTeste(){
        Login login =  new Login();
        login.setEmail(ConfigManipulation.getProp().getProperty("emailTeste"));
        login.setSenha(ConfigManipulation.getProp().getProperty("senhaTeste"));
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
    public String autenticacaoGestaoDePessoas(){
        Login login = new Login();
        login.setEmail(ConfigManipulation.getProp().getProperty("emailGestao"));
        login.setSenha(ConfigManipulation.getProp().getProperty("senhaGestao"));
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
