package br.com.dbccompany.chronos.data.factory;

import br.com.dbccompany.chronos.model.User;
import br.com.dbccompany.chronos.model.UserBuilder;
import br.com.dbccompany.chronos.utils.ConfigManipulation;
import br.com.dbccompany.chronos.utils.Utils;


public class UserDataFactory {

    private UserDataFactory() {}
    private static String nomeValido(){
        return Utils.faker.name().firstName().toLowerCase().replaceAll("[^a-z]", "");
    }
    private static String usernameValido(){
        return "teste."+nomeValido();
    }

    private static String loginEmailValido() {
        return usernameValido()+"@dbccompany.com.br";
    }
    private static String loginEmailInvalido() {
        return Utils.faker.internet().emailAddress();
    }

    private static User novoUsuario() {
        return new UserBuilder()
            .login(loginEmailValido())
            .cargos(CargoDataFactory.cargoUnico())
            .build();
    }
    public static User usuarioValidoComEmail() {
        return novoUsuario();
    }
    public static User usuarioValidoComUsername() {
        User usuarioValidoComUsername = novoUsuario();
        usuarioValidoComUsername.setLogin(usernameValido());
        return usuarioValidoComUsername;
    }
    public static User usuarioValidoComCargoDuplo(){
        User usuarioValidoComCargoDuplo = novoUsuario();
        usuarioValidoComCargoDuplo.setCargos(CargoDataFactory.cargoDuplo());
        return usuarioValidoComCargoDuplo;
    }

    public static User userSemLogin() {
        User userSemLogin = novoUsuario();
        userSemLogin.setLogin(null);
        return userSemLogin;
    }
    public static User userSemCargo(){
        User userSemCargo = novoUsuario();
        userSemCargo.setCargos(null);
        return userSemCargo;
    }
    public static User userComCargoVazio(){
        User userComCargoVazio = novoUsuario();
        userComCargoVazio.setCargos(CargoDataFactory.cargosVazio());
        return userComCargoVazio;
    }
    public static User userComLoginInvalido(){
        User userComLoginInvalido = novoUsuario();
        userComLoginInvalido.setLogin(loginEmailInvalido());
        return userComLoginInvalido;
    }
    public static User userComCargoInvalido(){
        User userComCargoInvalido = novoUsuario();
        userComCargoInvalido.setCargos(CargoDataFactory.cargosInvalido());
        return userComCargoInvalido;
    }
    public static User userComLoginDuplicado() {
        User userComLoginDuplicado = novoUsuario();
        userComLoginDuplicado.setLogin(ConfigManipulation.getProp().getProperty("emailAdm"));
        return userComLoginDuplicado;
    }
}
