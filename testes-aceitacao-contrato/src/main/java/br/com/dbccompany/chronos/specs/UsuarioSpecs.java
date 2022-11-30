package br.com.dbccompany.chronos.specs;

import br.com.dbccompany.chronos.utils.Auth;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class UsuarioSpecs {
    public static String token = new Auth().autenticacaoAdmin();

    public static RequestSpecification requestSpec() {
        return new RequestSpecBuilder()
            .addHeader("Authorization", token)
            .setContentType(ContentType.JSON)
            .build();
    }
    public static RequestSpecification requestSpecNoAuth() {
        return new RequestSpecBuilder()
            .setContentType(ContentType.JSON)
            .build();
    }
}
