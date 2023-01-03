package br.com.dbccompany.chronos.data.factory;

import br.com.dbccompany.chronos.model.Edicao;
import br.com.dbccompany.chronos.model.EdicaoBuilder;
import br.com.dbccompany.chronos.utils.Utils;
import java.util.concurrent.TimeUnit;

public class EdicaoDataFactory {
    private static String nomeValido = Utils.faker.bossaNova().song();
    private static String dataInicialValida = Utils.faker.date().future(15,5, TimeUnit.DAYS,"YYYY-MM-dd");

    private static String dataInicialInvalida = Utils.faker.date().past(15,5, TimeUnit.DAYS,"YYYY-MM-dd");

    private static String dataFinalInvalida = Utils.faker.date().future(4,1, TimeUnit.DAYS,"YYYY-MM-dd");

    private static String dataInicialFormatoInvalido = "05/12/2022";

    private static String dataTipoInvalido = "aaabbbccc";

    private static Edicao novaEdicao(){
        return new EdicaoBuilder()
                .nome(nomeValido)
                .dataInicial(dataInicialValida)
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

    public static Edicao edicaoComDataInicialFormatoInvalido(){
        Edicao edicaoComDataInicialFormatoInvalido = novaEdicao();
        edicaoComDataInicialFormatoInvalido.setDataInicial(dataInicialFormatoInvalido);
        return edicaoComDataInicialFormatoInvalido;
    }

    public static Edicao edicaoComDataInicialTipoInvalido(){
        Edicao edicaoComDataInicialTipoInvalido = novaEdicao();
        edicaoComDataInicialTipoInvalido.setDataInicial(dataTipoInvalido);
        return edicaoComDataInicialTipoInvalido;
    }

}
