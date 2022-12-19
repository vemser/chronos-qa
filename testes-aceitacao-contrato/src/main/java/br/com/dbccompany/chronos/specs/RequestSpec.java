package br.com.dbccompany.chronos.specs;

import br.com.dbccompany.chronos.utils.Auth;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RequestSpec {
    private static String tokenAdm = new Auth().autenticacaoAdmin();
    private static String tokenTeste = new Auth().autenticacaoUserTeste();
    private static String tokenGestao = new Auth().autenticacaoGestaoDePessoas();
    public static RequestSpecification noAuth() {
        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .build();
    }
    public static RequestSpecification adm() {
        return new RequestSpecBuilder()
                .addHeader("Authorization", tokenAdm)
                .setContentType(ContentType.JSON)
                .build();
    }
    public static  RequestSpecification teste(){
        return new RequestSpecBuilder()
            .addHeader("Authorization", tokenTeste)
            .setContentType(ContentType.JSON)
            .build();
    }
    public static RequestSpecification gestao(){
        return new RequestSpecBuilder()
            .addHeader("Authorization",tokenGestao)
            .setContentType(ContentType.JSON)
            .build();
    }
}
