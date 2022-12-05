package br.com.dbccompany.chronos.data.factory;

import br.com.dbccompany.chronos.model.DiaNaoUtil;
import br.com.dbccompany.chronos.model.DiaNaoUtilBuilder;
import br.com.dbccompany.chronos.utils.Utils;

import java.util.concurrent.TimeUnit;

public class DiaNaoUtilDataFactory {
    private static String descricaoValida = Utils.faker.lorem().fixedString(10);
    private static String dataInicialValida = Utils.faker.date().future(15,5, TimeUnit.DAYS,"YYYY-MM-dd");
    private static String dataFinalValida = Utils.faker.date().future(30,20, TimeUnit.DAYS,"YYYY-MM-dd");
    private static String repeticaoAnualValida = "INATIVO";

    private static DiaNaoUtil novoDiaNaoUtil(){
        return new DiaNaoUtilBuilder()
                .descricao(descricaoValida)
                .dataInicial(dataInicialValida)
                .dataFinal(dataFinalValida)
                .repeticaoAnual(repeticaoAnualValida)
                .build();
    }

    public static DiaNaoUtil diaNaoUtilValido(){
        return novoDiaNaoUtil();
    }

    public static DiaNaoUtil diaNaoUtilSemDescricao(){
        DiaNaoUtil diaNaoUtilSemDescricao = novoDiaNaoUtil();
        diaNaoUtilSemDescricao.setDescricao(null);
        return diaNaoUtilSemDescricao;
    }
    public static DiaNaoUtil diaNaoUtilSemDataInicial(){
        DiaNaoUtil diaNaoUtilSemDataInicial = novoDiaNaoUtil();
        diaNaoUtilSemDataInicial.setDataInicial(null);
        return diaNaoUtilSemDataInicial;
    }
    public static DiaNaoUtil diaNaoUtilComDataIncialIgualDataFinal(){
        DiaNaoUtil diaNaoUtilComDataIncialIgualDataFinal = novoDiaNaoUtil();
        String data = dataInicialValida;
        diaNaoUtilComDataIncialIgualDataFinal.setDataInicial(data);
        diaNaoUtilComDataIncialIgualDataFinal.setDataFinal(data);
        return diaNaoUtilComDataIncialIgualDataFinal;
    }
}
