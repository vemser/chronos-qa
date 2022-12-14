package br.com.dbccompany.chronos.steps;

public class TestePerfilSteps{
//    public static void entrarNaPaginaDeEditarPerfil() {
//        GestorPage.clicarBotaoEditarPerfil();
//    }
//    private static String novaSenhaValida(){
//        return Utils.faker.internet()
//                .password(8, 10, true, true, true);
//    }
//
//    @Test
//    @Owner("Kevin Aryel")
//    @Epic("Frontend")
//    @Feature("Perfil")
//    @Story("Editar Perfil")
//    @Description("Deve retornar erro ao tentar editar Perfil sem senha atual")
//    public void testarEditarPerfilSemSenhaAtual() {
//        BaseSteps.fazerLoginGestor();
//        entrarNaPaginaDeEditarPerfil();
//        EditarPerfilPage.preencherNome(Utils.faker.lorem().characters(10));
//        String novaSenha = novaSenhaValida();
//        EditarPerfilPage.preencherNovaSenha(novaSenha);
//        EditarPerfilPage.preencherConfirmarNovaSenha(novaSenha);
//        EditarPerfilPage.clicarBotaoSubmit();
//        EditarPerfilPage.validarErroSenhaAtual();
//    }
//
//    @Test
//    @Owner("Kevin Aryel")
//    @Epic("Frontend")
//    @Feature("Perfil")
//    @Story("Editar Perfil")
//    @Description("Deve retornar erro ao tentar editar Perfil com nova senha inválida")
//    public void testarEditarPerfilComNovaSenhaInvalida() {
//        BaseSteps.fazerLoginGestor();
//        entrarNaPaginaDeEditarPerfil();
//        EditarPerfilPage.preencherNome(Utils.faker.lorem().characters(10));
//        EditarPerfilPage.preencherSenhaAtual(ConfigManipulation.getProp().getProperty("senhaGestao"));
//        String novaSenha = Utils.faker.internet().password(8,10,false);
//        EditarPerfilPage.preencherNovaSenha(novaSenha);
//        EditarPerfilPage.preencherConfirmarNovaSenha(novaSenha);
//        EditarPerfilPage.clicarBotaoSubmit();
//        EditarPerfilPage.validarErroNovaSenha();
//    }
//
//    @Test
//    @Owner("Kevin Aryel")
//    @Epic("Frontend")
//    @Feature("Perfil")
//    @Story("Editar Perfil")
//    @Description("Deve retornar erro ao tentar editar Perfil sem nova senha")
//    public void testarEditarPerfilSemNovaSenha() {
//        BaseSteps.fazerLoginGestor();
//        entrarNaPaginaDeEditarPerfil();
//        EditarPerfilPage.preencherNome(Utils.faker.lorem().characters(10));
//        EditarPerfilPage.preencherSenhaAtual(ConfigManipulation.getProp().getProperty("senhaGestao"));
//        EditarPerfilPage.preencherConfirmarNovaSenha(novaSenhaValida());
//        EditarPerfilPage.clicarBotaoSubmit();
//        EditarPerfilPage.validarErroNovaSenha();
//    }
//
//    @Test
//    @Owner("Kevin Aryel")
//    @Epic("Frontend")
//    @Feature("Perfil")
//    @Story("Editar Perfil")
//    @Description("Deve retornar erro ao tentar editar Perfil sem confirmar nova senha")
//    public void testarEditarPerfilSemConfirmarNovaSenha() {
//        BaseSteps.fazerLoginGestor();
//        entrarNaPaginaDeEditarPerfil();
//        EditarPerfilPage.preencherNome(Utils.faker.lorem().characters(10));
//        EditarPerfilPage.preencherSenhaAtual(ConfigManipulation.getProp().getProperty("senhaGestao"));
//        EditarPerfilPage.preencherNovaSenha(novaSenhaValida());
//        EditarPerfilPage.clicarBotaoSubmit();
//        EditarPerfilPage.validarErroConfirmarNovaSenha();
//    }
//    @Test
//    @Owner("Kevin Aryel")
//    @Epic("Frontend")
//    @Feature("Perfil")
//    @Story("Editar Perfil")
//    @Description("Deve retornar erro ao tentar editar Perfil com nova senha diferente da confirmada")
//    public void testarEditarPerfilComNovaSenhaDiferenteDaConfirmada() {
//        BaseSteps.fazerLoginGestor();
//        entrarNaPaginaDeEditarPerfil();
//        EditarPerfilPage.preencherNome(Utils.faker.lorem().characters(10));
//        EditarPerfilPage.preencherSenhaAtual(ConfigManipulation.getProp().getProperty("senhaGestao"));
//        EditarPerfilPage.preencherNovaSenha(novaSenhaValida());
//        EditarPerfilPage.preencherConfirmarNovaSenha(novaSenhaValida());
//        EditarPerfilPage.clicarBotaoSubmit();
//        EditarPerfilPage.validarErroConfirmarNovaSenha();
//    }
//    @Test
//    @Owner("Kevin Aryel")
//    @Epic("Frontend")
//    @Feature("Perfil")
//    @Story("Editar Perfil")
//    @Description("Deve retornar erro ao tentar editar Perfil com senha atual inválida")
//    public void testarEditarPerfilComSenhaAtualInvalida() {
//        BaseSteps.fazerLoginGestor();
//        entrarNaPaginaDeEditarPerfil();
//        EditarPerfilPage.preencherNome(Utils.faker.lorem().characters(10));
//        EditarPerfilPage.preencherSenhaAtual(novaSenhaValida());
//        String novaSenha = novaSenhaValida();
//        EditarPerfilPage.preencherNovaSenha(novaSenha);
//        EditarPerfilPage.preencherConfirmarNovaSenha(novaSenha);
//        EditarPerfilPage.clicarBotaoSubmit();
//        EditarPerfilPage.validarToast("Senha atual inválida");
//    }

}
