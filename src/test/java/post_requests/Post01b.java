package post_requests;

import base_urls.PetStoreBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post01b extends PetStoreBaseUrl {

/*
        Given
            1) https://petstore.swagger.io/v2/user
            2) {
                  "username": "JohnDoe",
                  "firstName": "John",
                  "lastName": "Doe",
                  "email": "john@doe.com",
                  "password": "1234",
                  "phone": "1234",
                  "userStatus": 123
                }
        When
            I send POST Request to the Url
        Then
            Status code is 200
            And response body should be like {
                                                "code": 200,
                                                "type": "unknown",
                                                "message": "6874988058"
                                             }
     */

    @Test
    public void post01b() {

        // Set the URL
        spec.pathParam("first", "user");

        // Set the expected data.

        Map<String, Object> expectedData = new HashMap<>();//You can create payload by using pojo class as well.

        expectedData.put("username", "JohnDoe");
        expectedData.put("firstName", "John");
        expectedData.put("lastName", "Doe");
        expectedData.put("email", "john@doe.com");
        expectedData.put("password", "1234");
        expectedData.put("phone", "1234");
        expectedData.put("userStatus", 123);

      // Send the request and get the response.


        Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().post("/{first}");
        response.prettyPrint();

        // Do assertion.

        Map<String, Object> actualData = response.as(HashMap.class);
        assertEquals(200, response.statusCode());
        assertEquals(200, actualData.get("code"));
        assertEquals("unknown", actualData.get("type"));


    }

}
