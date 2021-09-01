import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class LocalAPITesting {

    @Test
    void get_test(){

        baseURI = "http://localhost:3000/";

        given()
                .param("name", "Raghav")
                .get("/users")
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    void post_test(){

        JSONObject req = new JSONObject();

        req.put("name", "Alan");
        req.put("subjectId", 2);

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

    @Test
    void put_test(){

        JSONObject req = new JSONObject();

        req.put("name", "Einstein");
        req.put("subjectId", 2);

        baseURI = "http://localhost:3000/";

        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(req.toJSONString())
                .when()
                .put("/users/2")
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    void delete_test(){

        baseURI = "http://localhost:3000/";

        given()
                .delete("/users/4")
                .then()
                .statusCode(200)
                .log().all();


    }


}











