package br.com.dbccompany.chronos.testes.aceitacao.base;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {
    @BeforeAll
    public static void setup(){
    RestAssured.baseURI = "";
    RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }
}
