package br.com.dbccompany.chronos.data.factory;

import br.com.dbccompany.chronos.model.Login;
import br.com.dbccompany.chronos.model.LoginBuilder;
import br.com.dbccompany.chronos.utils.ConfigManipulation;
import br.com.dbccompany.chronos.utils.Utils;

public class LoginDataFactory {

        private LoginDataFactory() {}

        private static String emailInexistente(){
            return Utils.faker.name().fullName().replaceAll("[^a-z]", "").toLowerCase().replaceAll("[^a-z]", "")+"@dbccompany.com.br";
        }
        private static String emailInvalido() {
            return Utils.faker.internet().emailAddress();
        }
        private static String senhaInexistente() {
            return Utils.faker.internet().password();
        }

        private static Login novoLogin(){
        return new LoginBuilder()
                .username(emailInexistente())
                .password(senhaInexistente())
                .build();
        }

        public static Login loginInexistente(){
            return novoLogin();
        }

        public static Login loginSemEmail(){
            Login loginSemEmail = novoLogin();
            loginSemEmail.setUsername(null);
            return  loginSemEmail;
        }

        public static Login loginSemSenha(){
            Login loginSemSenha = novoLogin();
            loginSemSenha.setPassword(null);
            return  loginSemSenha;
        }

        public static Login loginEmailFormatoInvalido(){
            Login loginFormatoInvalido = novoLogin();
            loginFormatoInvalido.setUsername(emailInvalido());
            return  loginFormatoInvalido;
        }

        public static Login loginEmailValidoSenhaInvalida(){
            Login loginEmailValidoSenhaInvalida = novoLogin();
            loginEmailValidoSenhaInvalida.setUsername(ConfigManipulation.getProp().getProperty("emailQa"));
            return loginEmailValidoSenhaInvalida;
        }
        public static Login loginValidoComUsername(){
            return new LoginBuilder()
                .username(ConfigManipulation.getProp().getProperty("userQa"))
                .password(ConfigManipulation.getProp().getProperty("senhaQa"))
                .build();
        }

        public static Login loginValidoComEmail() {
            return new LoginBuilder()
                .username(ConfigManipulation.getProp().getProperty("emailQa"))
                .password(ConfigManipulation.getProp().getProperty("senhaQa"))
                .build();
    }
}
