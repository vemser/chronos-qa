package br.com.dbccompany.chronos.specs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class LoginSpecs {
public static RequestSpecification requestSpec() {
        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .build();
    }
}
