package br.com.dbccompany.chronos.data.changeless;

public class EdicaoData {
    private EdicaoData() {}
    public static final String SERVICE = "/edicao";
    public static final String SERVICE_ENABLE_DISABLE = String.format("%s/enable-disable", SERVICE);

    public static final String SERVICE_LISTAR = String.format("%s/listar", SERVICE);

    public static final String SERVICE_CLONAR = String.format("%s/clone", SERVICE);
}
