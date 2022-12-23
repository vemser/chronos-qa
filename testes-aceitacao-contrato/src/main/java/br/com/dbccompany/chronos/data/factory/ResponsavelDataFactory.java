package br.com.dbccompany.chronos.data.factory;

import br.com.dbccompany.chronos.model.Responsavel;
import br.com.dbccompany.chronos.utils.Utils;
import br.com.dbccompany.chronos.model.ResponsavelBuilder;
public class ResponsavelDataFactory {
    private static String nomeValido = Utils.faker.name().fullName();
    private static Responsavel novoResponsavel(){
        return new ResponsavelBuilder()
                .nome( nomeValido )
                .build();
    }

    public static Responsavel responsavelValido(){
        return novoResponsavel();
    }
    public static Responsavel responsavelTeste(){
        return new ResponsavelBuilder()
                .nome("teste")
                .build();
    }

    public static Responsavel responsavelSemNome(){
        Responsavel responsavelSemNome = novoResponsavel();
        responsavelSemNome.setNome(null);
        return responsavelSemNome;
    }
}
