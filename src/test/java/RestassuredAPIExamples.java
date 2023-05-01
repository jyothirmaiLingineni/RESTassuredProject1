import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class RestassuredAPIExamples {


    @Test
    public void test1_get() {

        baseURI = "http://localhost:3000";
        given().
                get("/users")
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void test2_get() {

        baseURI = "http://localhost:3000";
        given().
                param("name", "Automation")
                .get("/subjects")
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void test3_post() {

        JSONObject request = new JSONObject();

        request.put("firstName", "Tommy");
        request.put("lastName", "Cooper");
        request.put("subjectId", "1");
        request.put("id", '4');

        baseURI = "http://localhost:3000/";
        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                header("Content-Type", "application/json").
                body(request.toJSONString()).
                when().
                post("/users").
                then()
                .statusCode(201)
                .log().all();
    }
    @Test
    public void test4_patch() {

        JSONObject request = new JSONObject();

        request.put("lastName", "Casper");

        baseURI = "http://localhost:3000/";
        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                header("Content-Type", "application/json").
                body(request.toJSONString()).
                when().
                patch("/users/4").
                then()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void test5_delete() {

        baseURI = "http://localhost:3000/";

                when().
                delete("/users/4").
                then()
                .statusCode(200)
                .log().all();
    }

}
