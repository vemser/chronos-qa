package br.com.dbccompany.chronos.data.foto;
//
//import br.com.dbccompany.chronos.client.FotoClient;
//import br.com.dbccompany.chronos.client.UsuarioClient;
//import br.com.dbccompany.chronos.dto.UsuarioDTO;
//import br.com.dbccompany.chronos.testes.BaseTest;
//import br.com.dbccompany.chronos.utils.ConfigManipulation;
//import io.qameta.allure.Description;
//import org.junit.Assert;
//import org.junit.jupiter.api.Tag;
//import org.junit.jupiter.api.Test;
//import java.io.File;
//
//public class FotoEditarPropriaTest extends BaseTest {
////    @Test
////    @Tag("todos")
////    @Tag("foto")
////    @Description("Editar foto do usuário logado")
////    public void editarFotoPropria() {
////        File file = new File("src/test/resources/images/Img.png");
////        UsuarioDTO usuario = FotoClient.uploadFoto(file,true)
////                .then()
////                .log().all()
////                .statusCode(200)
////                .extract().as(UsuarioDTO.class);
////        Assert.assertEquals(ConfigManipulation.getProp().getProperty("emailTeste"),usuario.getEmail());
////    }
//}
