package br.com.dbccompany.chronos.data.factory;

import br.com.dbccompany.chronos.model.Login;
import br.com.dbccompany.chronos.model.LoginBuilder;
import br.com.dbccompany.chronos.utils.Utils;
import org.apache.commons.lang3.StringUtils;

public class LoginDataFactory {

        private LoginDataFactory() {}

        public static String emailInexistente() {
            return Utils.faker.internet().emailAddress();
        }
        public static String senhaInexistente() {
            return Utils.faker.internet().password();
        }

        public static Login loginInvalidoCompleto(){
            return novoLogin();
        }

        public static Login loginSemEmail(){
            Login loginSemEmail = novoLogin();
            loginSemEmail.setEmail(StringUtils.EMPTY);
            return  loginSemEmail;
        }

        public static Login loginSemSenha(){
            Login loginSemSenha = novoLogin();
            loginSemSenha.setSenha(StringUtils.EMPTY);
            return  loginSemSenha;
        }

        public static Login novoLogin(){
            return new LoginBuilder()
                .email(Utils.faker.internet().emailAddress())
                .senha(Utils.faker.internet().password())
                .build();
        }
        public static Login loginValido() {
            return new LoginBuilder()
                .email("teste@gmail.com")
                .senha("123456")
                .build();
    }
}
