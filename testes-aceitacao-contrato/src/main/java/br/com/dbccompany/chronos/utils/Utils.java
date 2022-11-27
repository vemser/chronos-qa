package br.com.dbccompany.chronos.utils;

import com.google.gson.Gson;
import net.datafaker.Faker;

import java.util.Locale;

public class Utils {
    public static String converterParaJson(Object object) {
        return new Gson().toJson(object);
    }

    public static Faker faker = new Faker(new Locale("pt-BR"));
}
