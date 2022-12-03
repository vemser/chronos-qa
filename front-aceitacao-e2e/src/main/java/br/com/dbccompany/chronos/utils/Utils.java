package br.com.dbccompany.chronos.utils;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import java.util.Locale;


public class Utils {
    public static Faker faker = new Faker(new Locale("pt-BR"));
    private static final String endpointLogin = "http://vemser-dbc.dbccompany.com.br:39000/vemser/chronos-back/login";
    public static String converterParaJson(Object object) {
        return new Gson().toJson(object);
    }


}
