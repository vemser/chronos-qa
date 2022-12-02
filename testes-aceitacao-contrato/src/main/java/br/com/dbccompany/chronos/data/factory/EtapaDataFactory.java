package br.com.dbccompany.chronos.data.factory;

import br.com.dbccompany.chronos.model.Etapa;
import br.com.dbccompany.chronos.model.EtapaBuilder;
import br.com.dbccompany.chronos.utils.Utils;

public class EtapaDataFactory {
    private static String nomeValido = "Etapa 1";
    private static Integer ordemExecucaoValida = Utils.faker.number().numberBetween(1,50);

    private static Etapa novaEtapa(){
        return new EtapaBuilder()
                .nome(nomeValido)
                .ordemExecucao(ordemExecucaoValida)
                .build();
    }

    public static Etapa etapaValida(){
        return novaEtapa();
    }

    public static Etapa etapaSemNome(){
        Etapa etapaSemNome = novaEtapa();
        etapaSemNome.setNome(null);
        return etapaSemNome;
    }

    public static Etapa etapaSemOrdemExecucao(){
        Etapa etapaSemOrdemExecucao = novaEtapa();
        etapaSemOrdemExecucao.setOrdemExecucao(null);
        return etapaSemOrdemExecucao;
    }

}
