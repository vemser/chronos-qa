package br.com.dbccompany.chronos.data.changeless;

public class UsuarioData {

        private UsuarioData() {}
        private static final String BaseURI = "http://vemser-dbc.dbccompany.com.br:39000/vemser/usuario-back";
        public static final String SERVICE = String.format("%s/usuario",BaseURI);
        public static final String SERVICE_UPLOAD = String.format("%s/foto/upload-image", BaseURI);
        public static final String SERVICE_UPDATE_CARGO = String.format("%s/update-cargos", SERVICE);
        public static final String SERVICE_LOGADO = String.format("%s/logged-user", SERVICE);
        public static final String SERVICE_FILTRADO = String.format("%s/filtrarLoginCargo",SERVICE);
}
