package br.com.dbccompany.chronos.data.factory;

import br.com.dbccompany.chronos.model.Edicao;
import br.com.dbccompany.chronos.model.EdicaoBuilder;
import br.com.dbccompany.chronos.utils.Utils;
import java.util.concurrent.TimeUnit;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EdicaoDataFactory {
    private static String nomeValido = Utils.faker.bossaNova().song();
    private static String dataInicialValida = Utils.faker.date().future(15,5, TimeUnit.DAYS,"2022/12/31");
    private static String dataFinalValida = Utils.faker.date().future(30,20, TimeUnit.DAYS,"2022/12/31");

    private static Edicao novaEdicao(){
        return new EdicaoBuilder()
                .nome(nomeValido)
                .dataInicial(dataInicialValida)
                .dataFinal(dataFinalValida)
                .build();
    }

    public static Edicao edicaoValida(){
        return novaEdicao();
    }
    public static Edicao edicaoSemNome(){
        Edicao edicaoSemNome = novaEdicao();
        edicaoSemNome.setNome(null);
        return edicaoSemNome;
    }
    public static Edicao edicaoSemDataInicial(){
        Edicao edicaoSemDataInicial = novaEdicao();
        edicaoSemDataInicial.setDataInicial(null);
        return edicaoSemDataInicial;
    }
    public static Edicao edicaoSemDataFinal(){
        Edicao edicaoSemDataFinal = novaEdicao();
        edicaoSemDataFinal.setDataFinal(null);
        return edicaoSemDataFinal;
    }

}
