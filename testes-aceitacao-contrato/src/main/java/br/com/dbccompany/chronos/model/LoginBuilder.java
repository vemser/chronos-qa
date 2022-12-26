package br.com.dbccompany.chronos.model;

public class LoginBuilder {

        private String username;
        private String password;

        public LoginBuilder username(String username) {
            this.username = username;
            return this;
        }

        public LoginBuilder password(String password) {
            this.password = password;
            return this;
        }

        public Login build() {
            return new Login(username, password);
        }
}
