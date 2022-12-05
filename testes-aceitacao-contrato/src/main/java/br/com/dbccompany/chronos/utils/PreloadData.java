package br.com.dbccompany.chronos.utils;

import br.com.dbccompany.chronos.client.*;
import br.com.dbccompany.chronos.data.factory.*;
import br.com.dbccompany.chronos.dto.*;
import br.com.dbccompany.chronos.model.*;
import io.restassured.response.Response;

public class PreloadData {
    public static UsuarioDTO userAdmin(){
        User usuario = UserDataFactory.usuarioValido();
        UsuarioDTO userAdmin = UsuarioClient.cadastrarUsuario(Utils.converterParaJson(usuario),true)
            .then()
                .log().all()
            .extract().as(UsuarioDTO.class);
        return userAdmin;
    }
    public static ResponsavelDTO responsavel(){
        Responsavel responsavel = ResponsavelDataFactory.responsavelValido();
        return ResponsavelClient.criarResponsavel(Utils.converterParaJson(responsavel), true)
            .then()
            .log().all()
            .extract().as(ResponsavelDTO.class);
    }
    public static AreaEnvolvidaDTO areaEnvolvida(){
        AreaEnvolvida areaEnvolvida = AreaEnvolvidaDataFactory.areaEnvolvidaValida();
        return AreaEnvolvidaClient.criarAreaEnvolvida(Utils.converterParaJson(areaEnvolvida), true)
            .then()
            .log().all()
            .extract().as(AreaEnvolvidaDTO.class);
    }
    public static ProcessoDTO processo(String idEtapa){
        Processo processo = ProcessoDataFactory.processoValido();
        return ProcessoClient.cadastrarProcesso(Utils.converterParaJson(processo), idEtapa, true)
            .then()
            .extract().as(ProcessoDTO.class);
    }
    public static EdicaoDTO edicao(){
        Edicao edicao = EdicaoDataFactory.edicaoValida();
        return EdicaoClient.cadastrarEdicao(Utils.converterParaJson(edicao),true)
            .then()
            .extract().as(EdicaoDTO.class);
    }
    public static EtapaDTO etapa(String idEdicao){
        Etapa etapa = EtapaDataFactory.etapaValida();
        return EtapaClient.criarEtapa(Utils.converterParaJson(etapa),idEdicao,true)
                .then()
                .extract().as(EtapaDTO.class);
    }
    public static DiaNaoUtilDTO diaNaoUtil(){
        DiaNaoUtil diaNaoUtil = DiaNaoUtilDataFactory.diaNaoUtilValido();
        return DiaNaoUtilClient.criarDiaNaoUtil(Utils.converterParaJson(diaNaoUtil),true)
                .then()
                .extract().as(DiaNaoUtilDTO.class);
    }
    public static Response restaurarPerfil(String senhaAtual){
        Perfil perfil = PerfilDataFactory.perfilRestore(senhaAtual);
        return UsuarioClient.atualizarPerfil(Utils.converterParaJson(perfil),true);
    }
}
