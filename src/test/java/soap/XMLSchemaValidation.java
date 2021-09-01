package soap;

import io.restassured.http.ContentType;
import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.matcher.RestAssuredMatchers.matchesXsdInClasspath;
import static org.hamcrest.Matchers.equalTo;

public class XMLSchemaValidation {

    @Test
    public void validateXmlAgainstSchema() throws Exception {


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
                .body("//*:AddResult.text()", equalTo("7"))
                .and()
                .assertThat().body(matchesXsdInClasspath("calculator.xsd"));

    }

}
