package br.com.dbccompany.chronos.model;

import lombok.Data;

@Data
public class Login {
        private String username;
        private String password;

        public Login() {
        }

        public Login(String username, String password) {
            this.username = username;
            this.password = password;
        }
}
