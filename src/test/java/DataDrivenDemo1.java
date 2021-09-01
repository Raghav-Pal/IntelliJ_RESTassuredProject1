import data.DataForTests;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class DataDrivenDemo1 extends DataForTests {

    @Test(dataProvider = "DataForPost")
    void post_test(String name, int subjectId){

        JSONObject req = new JSONObject();

        req.put("name", name);
        req.put("subjectId", subjectId);

        baseURI = "http://localhost:3000/";

        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(req.toJSONString())
                .when()
                .post("/users")
                .then()
                .statusCode(201)
                .log().all();
    }

    @Test(dataProvider = "DataForDelete")
    void delete_test(int userId){

        baseURI = "http://localhost:3000/";

        given()
                .delete("/users/"+userId)
                .then()
                .statusCode(200)
                .log().all();


    }

}
