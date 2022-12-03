package br.com.dbccompany.chronos.client;

import br.com.dbccompany.chronos.data.changeless.FotoData;
import br.com.dbccompany.chronos.specs.RequestSpec;
import io.restassured.builder.MultiPartSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.MultiPartSpecification;
import io.restassured.specification.RequestSpecification;

import java.io.File;

import static io.restassured.RestAssured.given;

public class FotoClient {
    public static Response uploadFoto(File file, boolean auth) {
        RequestSpecification spec = auth ? RequestSpec.testeMultipart() : RequestSpec.noAuth();
//        MultiPartSpecification multipart = new MultiPartSpecBuilder(file)
//                .mimeType("image/png")
//                .fileName(file.getName())
//                .controlName("file")
//                .build();
        return given()
            .spec(spec)
            .multiPart(new File("./src/test/resources/images/Img.png"))
            .log().all()
        .when()
            .put(FotoData.SERVICE_UPLOAD_SELF)
            ;
    }
}
