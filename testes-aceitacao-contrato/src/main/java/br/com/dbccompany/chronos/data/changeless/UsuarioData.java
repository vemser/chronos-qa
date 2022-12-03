package br.com.dbccompany.chronos.data.changeless;

public class UsuarioData {

        private UsuarioData() {}
        public static final String SERVICE = "/usuario";
        public static final String SERVICE_UPLOAD = String.format("%s/upload-image", SERVICE);
        public static final String SERVICE_UPDATE_PERFIL = String.format("%s/update-perfil", SERVICE);
        public static final String SERVICE_UPDATE_CADASTRO = String.format("%s/update-cadastro", SERVICE);
        public static final String SERVICE_ENABLE_DISABLE = String.format("%s/enable-disable", SERVICE);
        public static final String SERVICE_LOGADO = String.format("%s/logged-user", SERVICE);

}
