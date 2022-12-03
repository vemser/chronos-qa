package br.com.dbccompany.chronos.data.factory;

import br.com.dbccompany.chronos.model.Login;
import br.com.dbccompany.chronos.model.LoginBuilder;
import br.com.dbccompany.chronos.utils.ConfigManipulation;
import br.com.dbccompany.chronos.utils.Utils;

public class LoginDataFactory {

        private LoginDataFactory() {}

        private static String emailInexistente() {
            return Utils.faker.internet().emailAddress();
        }
        private static String senhaInexistente() {
            return Utils.faker.internet().password();
        }

        private static Login novoLogin(){
        return new LoginBuilder()
                .email(emailInexistente())
                .senha(senhaInexistente())
                .build();
        }

        public static Login loginInexistente(){
            return novoLogin();
        }

        public static Login loginSemEmail(){
            Login loginSemEmail = novoLogin();
            loginSemEmail.setEmail(null);
            return  loginSemEmail;
        }

        public static Login loginSemSenha(){
            Login loginSemSenha = novoLogin();
            loginSemSenha.setSenha(null);
            return  loginSemSenha;
        }

        public static Login loginEmailFormatoInvalido(){
            Login loginFormatoInvalido = novoLogin();
            loginFormatoInvalido.setEmail("teste121213");
            return  loginFormatoInvalido;
        }

        public static Login loginEmailValidoSenhaInvalida(){
            Login loginEmailValidoSenhaInvalida = novoLogin();
            loginEmailValidoSenhaInvalida.setEmail(ConfigManipulation.getProp().getProperty("emailAdm"));
            return loginEmailValidoSenhaInvalida;
        }

        public static Login loginValido() {
            return new LoginBuilder()
                .email(ConfigManipulation.getProp().getProperty("emailAdm"))
                .senha(ConfigManipulation.getProp().getProperty("senhaAdm"))
                .build();
    }
}
