package br.com.dbccompany.chronos.specs;

import br.com.dbccompany.chronos.utils.Auth;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RequestSpec {
    private static String tokenGeral = new Auth().autenticacaoQa();
    public static RequestSpecification noAuth() {
        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .build();
    }
    public static RequestSpecification geral() {
        return new RequestSpecBuilder()
                .addHeader("Authorization", tokenGeral)
                .setContentType(ContentType.JSON)
                .build();
    }
}
