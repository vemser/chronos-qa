package br.com.dbccompany.chronos.data.factory;

import br.com.dbccompany.chronos.model.Edicao;
import br.com.dbccompany.chronos.model.EdicaoBuilder;
import br.com.dbccompany.chronos.utils.Utils;
import java.util.concurrent.TimeUnit;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EdicaoDataFactory {
    private static String nomeValido = Utils.faker.bossaNova().song();
    private static String dataInicialValida = Utils.faker.date().future(15,5, TimeUnit.DAYS,"YYYY-MM-dd");
    private static String dataFinalValida = Utils.faker.date().future(30,20, TimeUnit.DAYS,"YYYY-MM-dd");

    private static String dataInicialInvalida = Utils.faker.date().past(15,5, TimeUnit.DAYS,"YYYY-MM-dd");

    private static String dataFinalInvalida = Utils.faker.date().future(4,1, TimeUnit.DAYS,"YYYY-MM-dd");

    private static String dataInicialFormatoInvalido = "05/12/2022";

    private static String dataFinalFormatoInvalido = "01/01/2023";

    private static String dataTipoInvalido = "aaabbbccc";

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

    public static Edicao edicaoComDataFinalMenorQueDataInicial(){
        Edicao edicaoComDataFinalMenorQueDataInicial = novaEdicao();
        edicaoComDataFinalMenorQueDataInicial.setDataFinal(dataFinalInvalida);
        return edicaoComDataFinalMenorQueDataInicial;
    }

    public static Edicao edicaoComDataInicialFormatoInvalido(){
        Edicao edicaoComDataInicialFormatoInvalido = novaEdicao();
        edicaoComDataInicialFormatoInvalido.setDataInicial(dataInicialFormatoInvalido);
        return edicaoComDataInicialFormatoInvalido;
    }

    public static Edicao edicaoComDataFinalFormatoInvalido(){
        Edicao edicaoComDataFinalFormatoInvalido = novaEdicao();
        edicaoComDataFinalFormatoInvalido.setDataFinal(dataFinalFormatoInvalido);
        return edicaoComDataFinalFormatoInvalido;
    }

    public static Edicao edicaoComDataInicialTipoInvalido(){
        Edicao edicaoComDataInicialTipoInvalido = novaEdicao();
        edicaoComDataInicialTipoInvalido.setDataInicial(dataTipoInvalido);
        return edicaoComDataInicialTipoInvalido;
    }

    public static Edicao edicaoComDataFinalTipoInvalido(){
        Edicao edicaoComDataFinalTipoInvalido = novaEdicao();
        edicaoComDataFinalTipoInvalido.setDataFinal(dataTipoInvalido);
        return edicaoComDataFinalTipoInvalido;
    }

    public static Edicao edicaoComDataFinalIgualADataInicial(){
        Edicao edicaoComDataFinalIgualADataInicial = novaEdicao();
        String data = dataInicialValida;
        edicaoComDataFinalIgualADataInicial.setDataFinal(data);
        edicaoComDataFinalIgualADataInicial.setDataInicial(data);
        return edicaoComDataFinalIgualADataInicial;
    }

}
