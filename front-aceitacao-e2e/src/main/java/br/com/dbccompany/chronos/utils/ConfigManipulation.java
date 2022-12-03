package br.com.dbccompany.chronos.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigManipulation {
    public static Properties getProp() {
        Properties props = new Properties();
        try {
            FileInputStream file = new FileInputStream("src/properties/dados.properties");
            props.load(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return props;
    }
}
