package br.com.dbccompany.chronos.data.factory;

import br.com.dbccompany.chronos.model.Perfil;
import br.com.dbccompany.chronos.model.PerfilBuilder;
import br.com.dbccompany.chronos.utils.ConfigManipulation;
import br.com.dbccompany.chronos.utils.Utils;

public class PerfilDataFactory {
    private static String nomeValido() {
        return Utils.faker.name().fullName();
    }
    private static String senhaValida() {
        return Utils.faker.internet()
                .password(6,8,true,true,true);
    }

    private static Perfil novoPerfil() {
        String senha = senhaValida();
        return new PerfilBuilder()
                .nome(nomeValido())
                .senhaAtual(ConfigManipulation.getProp().getProperty("senhaTeste"))
                .novaSenha(senha)
                .confirmacaoNovaSenha(senha)
                .build();
    }

    public static Perfil perfilValido() {
        return novoPerfil();
    }

    public static Perfil perfilSemNome() {
        Perfil perfilSemNome = novoPerfil();
        perfilSemNome.setNome(null);
        return perfilSemNome;
    }
    public static Perfil perfilSemSenhaAtual() {
        Perfil perfilSemSenhaAtual = novoPerfil();
        perfilSemSenhaAtual.setSenhaAtual(null);
        return perfilSemSenhaAtual;
    }
    public static Perfil perfilSemNovaSenha() {
        Perfil perfilSemNovaSenha = novoPerfil();
        perfilSemNovaSenha.setNovaSenha(null);
        return perfilSemNovaSenha;
    }
    public static Perfil perfilSemConfirmacaoNovaSenha() {
        Perfil perfilSemConfirmacaoNovaSenha = novoPerfil();
        perfilSemConfirmacaoNovaSenha.setConfirmacaoNovaSenha(null);
        return perfilSemConfirmacaoNovaSenha;
    }
    public static Perfil perfilComSenhasDiferentes(){
        Perfil perfilComSenhasDiferentes = novoPerfil();
        perfilComSenhasDiferentes.setNovaSenha(senhaValida());
        return perfilComSenhasDiferentes;
    }

    public static Perfil perfilRestore(String senhaAtual){
        Perfil perfilRestore = novoPerfil();
        perfilRestore.setNovaSenha(ConfigManipulation.getProp().getProperty("senhaTeste"));
        perfilRestore.setConfirmacaoNovaSenha(ConfigManipulation.getProp().getProperty("senhaTeste"));
        perfilRestore.setNome(ConfigManipulation.getProp().getProperty("nomeTeste"));
        perfilRestore.setSenhaAtual(senhaAtual);
        return perfilRestore;
    }
}
