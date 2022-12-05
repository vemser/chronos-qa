package br.com.dbccompany.chronos.data.factory;

import br.com.dbccompany.chronos.model.AreaEnvolvida;
import br.com.dbccompany.chronos.model.Processo;
import br.com.dbccompany.chronos.model.ProcessoBuilder;
import br.com.dbccompany.chronos.model.Responsavel;
import br.com.dbccompany.chronos.utils.Utils;

public class ProcessoDataFactory {
    private static String nomeValido = Utils.faker.company().industry();
    private static String duracaoProcessoValido = Utils.faker.number().digits(2).toString();
    private static Integer diasUteisValido = Utils.faker.number().numberBetween(4,10);
    private static Integer ordemExecucaoValido = Utils.faker.number().numberBetween(1,50);
    private static AreaEnvolvida[] areaEnvolvidaVazia = new AreaEnvolvida[0];
    private static Responsavel[] responsavelVazio = new Responsavel[0];
    private static Processo novoProcesso(){
     return new ProcessoBuilder()
            .nome(nomeValido)
            .duracaoProcesso(duracaoProcessoValido)
            .diasUteis(diasUteisValido)
            .areasEnvolvidas(areaEnvolvidaVazia)
            .responsaveis(responsavelVazio)
            .ordemExecucao(ordemExecucaoValido)
            .build();
    }

    public static Processo processoValido(){
        return novoProcesso();
    }
    public static Processo processoSemNome(){
        Processo processoSemNome = novoProcesso();
        processoSemNome.setNome(null);
        return processoSemNome;
    }
    public static Processo processoSemDuracaoProcesso(){
        Processo processoSemDuracaoProcesso = novoProcesso();
        processoSemDuracaoProcesso.setDuracaoProcesso(null);
        return processoSemDuracaoProcesso;
    }
    public static Processo processoSemDiasUteis(){
        Processo processoSemDiasUteis = novoProcesso();
        processoSemDiasUteis.setDiasUteis(null);
        return processoSemDiasUteis;
    }
    public static Processo processoSemOrdemExecucao(){
        Processo processoSemOrdemExecucao = novoProcesso();
        processoSemOrdemExecucao.setOrdemExecucao(null);
        return processoSemOrdemExecucao;
    }
    public static Processo processoSemResponsavel(){
        Processo processoSemResponsavel = novoProcesso();
        processoSemResponsavel.setResponsaveis(responsavelVazio);
        return processoSemResponsavel;
    }
}
