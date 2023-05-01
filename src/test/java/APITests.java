import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.json.simple.JSONObject;
import java.util.HashMap;
import java.util.Map;

public class APITests {

    int id;
    @Test
    void test1_get() {
        Response response = get("https://reqres.in/api/users?page=2");
        System.out.println("Status Code :" + response.asString());
        System.out.println("Status Code :" + response.getStatusCode());
        System.out.println("Status Code :" + response.getBody().asString());
        System.out.println("Status Code :" + response.getTime());
        System.out.println("Status Code :" + response.getHeader("content-type"));

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }

    @Test
    void test2_get() {
        get("https://reqres.in/api/users?page=2").
                then().
                statusCode(200);
    }

    @Test
    void test3_post() {
        Map<String ,Object> map =new HashMap<String,Object>();
//        map.put("name","Jyothi");
//        map.put("job","IT");
//        System.out.println(map);

       JSONObject request=new JSONObject(map);

        request.put("first_name","Jyothi1");
        request.put("last_name","L1");
        request.put("subjectId","10");

        System.out.println(request.toJSONString());

      id= given().
                contentType("application/json").
                body(request.toJSONString()).

                when().
                post("https://reqres.in/api/users/2").jsonPath().getInt("id");


//                then().
//                statusCode(201).
//                log().all();

    }

    @Test
    void test4_Delete() {

        when().delete("https://reqres.in/api/users/2").
                then().
                statusCode(204).log().all();
    }
}
