package br.com.dbccompany.chronos.data.factory;

import br.com.dbccompany.chronos.model.Cargo;
import br.com.dbccompany.chronos.model.CargoBuilder;
import br.com.dbccompany.chronos.model.User;
import br.com.dbccompany.chronos.model.UserBuilder;
import br.com.dbccompany.chronos.utils.ConfigManipulation;
import br.com.dbccompany.chronos.utils.Utils;

public class UserDataFactory {

        private UserDataFactory() {}

        private static Cargo[] cargosVazio = new Cargo[0];
        private static String emailValido() {
            return Utils.faker.internet().emailAddress();
        }
        private static String emailInvalido() {
            return "teste121213";
        }
        private static String nomeValido(){
            return Utils.faker.name().fullName();
        }
        private static Cargo[] cargosInvalidos(){
            return new Cargo[]{new CargoBuilder().idCargo(1).descricao("Cargo 1").nome("Teste").build()};
        }
        private static Cargo[] cargosValidos(){
            return new Cargo[]{new CargoBuilder().idCargo(1).descricao("Admin").nome("ROLE_ADMIN").build()};
        }

        private static User novoUsuario() {
            return new UserBuilder()
                .email(emailValido())
                .nome(nomeValido())
                .cargos(cargosValidos())
                .build();
        }

        private static User novoCadastro(){
            return new UserBuilder()
                    .nome(nomeValido())
                    .cargos(cargosValidos())
                    .build();
        }
        public static User cadastroValido(){
            return novoCadastro();
        }

        public static User cadastroSemNome(){
            User cadastroSemNome = novoCadastro();
            cadastroSemNome.setNome(null);
            return cadastroSemNome;
        }
        public static User cadastroComCargoVazio(){
            User cadastroComCargoVazio = novoCadastro();
            cadastroComCargoVazio.setCargos(cargosVazio);
            return cadastroComCargoVazio;
        }
        public static User cadastroSemCargo(){
            User cadastroSemCargo = novoCadastro();
            cadastroSemCargo.setCargos(null);
            return cadastroSemCargo;
        }
        public static User cadastroComCargoInvalido(){
            User cadastroComCargoInvalido = novoCadastro();
            cadastroComCargoInvalido.setCargos(cargosInvalidos());
            return cadastroComCargoInvalido;
        }

        public static User usuarioValido() {
            return novoUsuario();
        }
        public static User userSemNome() {
            User userSemNome = novoUsuario();
            userSemNome.setNome(null);
            return userSemNome;
        }
        public static User userSemEmail() {
            User userSemEmail = novoUsuario();
            userSemEmail.setEmail(null);
            return userSemEmail;
        }
        public static User userSemCargo(){
            User userSemCargo = novoUsuario();
            userSemCargo.setCargos(null);
            return userSemCargo;
        }
        public static User userComCargoVazio(){
            User userComCargoVazio = novoUsuario();
            userComCargoVazio.setCargos(cargosVazio);
            return userComCargoVazio;
        }
        public static User userComEmailInvalido(){
            User userComEmailInvalido = novoUsuario();
            userComEmailInvalido.setEmail(emailInvalido());
            return userComEmailInvalido;
        }
        public static User userComCargoInvalido(){
            User userComCargoInvalido = novoUsuario();
            userComCargoInvalido.setCargos(cargosInvalidos());
            return userComCargoInvalido;
        }
        public static User userComEmailDuplicado() {
            User userComEmailDuplicado = novoUsuario();
            userComEmailDuplicado.setEmail(ConfigManipulation.getProp().getProperty("emailAdm"));
            return userComEmailDuplicado;
        }
}
