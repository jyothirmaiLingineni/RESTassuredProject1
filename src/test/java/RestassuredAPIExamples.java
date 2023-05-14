import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class RestassuredAPIExamples {


    @Test(priority = 1)
    public void test1_get() {

        baseURI = "http://localhost:3000";
        given().
                get("/users")
                .then()
                .statusCode(200)
                .log().all();

    }

     @Test(priority = 2)
    public void test3_post() {
        //Specify base URI
        RestAssured.baseURI="http://localhost:3000/";

       JSONObject request = new JSONObject();

        request.put("firstName", "Tommy");
        request.put("lastName", "Cooper");
        request.put("subjectId", "1");
        request.put("id", '5');

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


    @Test(priority = 3)
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

    @Test(priority = 4)
    public void test5_get() {

        baseURI = "http://localhost:3000";
        given().
                get("/users")
                .then()
                .statusCode(200)
                .log().all();
    }

//     @Test(priority = 5)
//     public void test5_delete() {

//         baseURI = "http://localhost:3000/";

//         when().
//                 delete("/users/4").
//                 then()
//                 .statusCode(200)
//                 .log().all();
//     }

//    @Test(priority = 6)
//    public void test6_get() {
//
//        baseURI = "http://localhost:3000";
//        given().
//                get("/users")
//                .then()
//                .statusCode(204)
//                .log().all();
//    }

   @Test(priority = 5)
   public void test2_get() {

       baseURI = "http://localhost:3000";
       given().
               param("name", "Automation")
               .get("/subjects")
               .then()
               .statusCode(200)
               .log().all();
   }

}
