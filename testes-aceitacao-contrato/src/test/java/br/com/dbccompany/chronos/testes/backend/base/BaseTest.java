package br.com.dbccompany.chronos.testes.backend.base;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {
    @BeforeAll
    public static void setup(){
        System.out.println("Iniciando os testes");
        RestAssured.defaultParser = Parser.JSON;
        RestAssured.baseURI = "http://vemser-dbc.dbccompany.com.br:39000/vemser/chronos-back";
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }
}
