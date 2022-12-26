package br.com.dbccompany.chronos.data.factory;

import br.com.dbccompany.chronos.data.changeless.enums.ProcessoCritico;
import br.com.dbccompany.chronos.model.AreaEnvolvida;
import br.com.dbccompany.chronos.model.Processo;
import br.com.dbccompany.chronos.model.ProcessoBuilder;
import br.com.dbccompany.chronos.model.Responsavel;
import br.com.dbccompany.chronos.utils.Utils;

public class ProcessoDataFactory {
    private static String nomeValido(){
        return Utils.faker.company().industry();
    }
    private static String duracaoProcessoValido(){
        return Utils.faker.number().digits(2);
    }
    private static Integer diasUteisValido(){
        return Utils.faker.number().numberBetween(4,10);
    }
    private static Integer ordemExecucaoValido(){
        return Utils.faker.number().numberBetween(1,50);
    }
    private static AreaEnvolvida[] areaEnvolvidaVazia = new AreaEnvolvida[0];
    private static Responsavel[] responsavelVazio = new Responsavel[0];
    private static Responsavel[] responsavelValido(){
        return new Responsavel[]{ResponsavelDataFactory.responsavelTeste()};
    }
    private static AreaEnvolvida[] areaEnvolvidaValida(){
        return new AreaEnvolvida[]{AreaEnvolvidaDataFactory.areaEnvolvidaTeste()};
    }
    private static final String processoCriticoValidoAtivo = ProcessoCritico.Ativo.getNome();
    private static final String processoCriticoValidoInativo = ProcessoCritico.Inativo.getNome();
    private static final String processoCriticoInvalido = "teste1";
    private static Processo novoProcesso(){
     return new ProcessoBuilder()
            .nome(nomeValido())
            .duracaoProcesso(duracaoProcessoValido())
            .diasUteis(diasUteisValido())
            .areasEnvolvidas(areaEnvolvidaValida())
            .responsaveis(responsavelValido())
            .ordemExecucao(ordemExecucaoValido())
            .processoCritico(processoCriticoValidoInativo)
            .build();
    }

    public static Processo processoValido(){
        return novoProcesso();
    }
    public static Processo processoValidoCritico(){
        Processo processoValidoCritico = novoProcesso();
        processoValidoCritico.setProcessoCritico(processoCriticoValidoAtivo);
        return processoValidoCritico;
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
        processoSemResponsavel.setResponsaveis(null);
        return processoSemResponsavel;
    }
    public static Processo processoComResponsavelVazio(){
        Processo processoComResponsavelVazio = novoProcesso();
        processoComResponsavelVazio.setResponsaveis(responsavelVazio);
        return processoComResponsavelVazio;
    }
    public static Processo processoComAreasEnvolvidasVazia(){
        Processo processoComAreasEnvolvidasVazia = novoProcesso();
        processoComAreasEnvolvidasVazia.setAreasEnvolvidas(areaEnvolvidaVazia);
        return processoComAreasEnvolvidasVazia;
    }
    public static Processo processoSemAreaEnvolvida(){
        Processo processoSemAreaEnvolvida = novoProcesso();
        processoSemAreaEnvolvida.setAreasEnvolvidas(null);
        return processoSemAreaEnvolvida;
    }
    public static Processo processoSemProcessoCritico(){
        Processo processoSemProcessoCritico = novoProcesso();
        processoSemProcessoCritico.setProcessoCritico(null);
        return processoSemProcessoCritico;
    }
    public static Processo processoComProcessoCriticoInvalido(){
        Processo processoComProcessoCriticoInvalido = novoProcesso();
        processoComProcessoCriticoInvalido.setProcessoCritico(processoCriticoInvalido);
        return processoComProcessoCriticoInvalido;
    }
}
