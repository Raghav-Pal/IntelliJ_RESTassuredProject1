package soap;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.http.ContentType;
import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class SoapAPITest {

    @Test
    public void soapApiTest() throws Exception {

        File file = new File("./SoapReq/add.xml");

        if(file.exists())
            System.out.println("..Yes! File exists");

        FileInputStream fileInputStream = new FileInputStream(file);
        String reqBody = IOUtils.toString(fileInputStream, "UTF-8");

        baseURI = "http://www.dneonline.com";

        given()
                .contentType("text/xml")
                .accept(ContentType.XML)
                .body(reqBody)
                .when()
                .post("/calculator.asmx")
                .then()
                .statusCode(200)
                .log().all()
                .and()
                .body("//*:AddResult.text()", equalTo("5"));
    }
}
