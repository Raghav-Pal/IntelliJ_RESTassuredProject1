import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

public class JSONSchemaValidation {

    @Test
    void get_demo1(){

        given()
                .header("Content-Type","application/josn")
                .get("https://reqres.in/api/users?page=2")
                .then()
                .assertThat().body(matchesJsonSchemaInClasspath("schema.json"))
                .statusCode(200)
                .log().all();

    }
}
