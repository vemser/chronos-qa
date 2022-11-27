package br.com.dbccompany.chronos.model;

import lombok.Data;

@Data
public class Login {
        private String email;
        private String senha;

        public Login() {
        }

        public Login(String email, String senha) {
            this.email = email;
            this.senha = senha;
        }
}
