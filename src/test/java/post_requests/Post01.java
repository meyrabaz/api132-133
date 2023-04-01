package post_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;
import test_data.JsonPlaceOrderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;


public class Post01 {


    public class post01 extends JsonPlaceHolderBaseUrl {
     /*
         Given
           1) https://jsonplaceholder.typicode.com/todos
           2)  {
                 "userId": 55,
                 "title": "Tidy your room",
                 "completed": false
              }
        When
            I send POST Request to the Url

        Then
            Status code is 201
        And
            response body is like {
                                    "userId": 55,
                                    "title": "Tidy your room",
                                    "completed": false,
                                    "id": 201
                                    }
     */



        @Test
        public void post01 () {
            //Set the url
            spec.pathParam("first", "todos");

            //Set the expected data
            Map<String, Object> expectedData = new JsonPlaceOrderTestData().expectedDataMapMethod(55,"Tidy your room",false);//Recommended way



            System.out.println("expectedData = " + expectedData);

            //Send the request and get the response
            Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().post("{first}");
           // response.prettyPrint();

            //Do Assertion
            Map<String, Object> actualData = response.as(HashMap.class);//De-Serialization
            System.out.println("actualData = " + actualData);

            assertEquals(201, response.statusCode());
            assertEquals(expectedData.get("userId"), actualData.get("userId"));
            assertEquals(expectedData.get("title"), actualData.get("title"));
            assertEquals(expectedData.get("completed"), actualData.get("completed"));    }

        @Test
        public void post01b() {
            //Set the url
            spec.pathParam("first", "todos");

            //Set the expected data
            //Create an object from JsonPlaceHolderTestData class and use the expectedDataMapMethod to create "expectedData".
            Map<String, Object> expectedData = new JsonPlaceHolderTestData().expectedDataMapMethod(55, "Tidy your room", false);//Recommended way
            System.out.println("expectedData = " + expectedData);

            //Send the request and get the response
            Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().post("{first}");
            response.prettyPrint();

            //Do Assertion
            Map<String, Object> actualData = response.as(HashMap.class);//De-Serialization
            System.out.println("actualData = " + actualData);

            assertEquals(201, response.statusCode());
            assertEquals(expectedData.get("userId"), actualData.get("userId"));
            assertEquals(expectedData.get("title"), actualData.get("title"));
            assertEquals(expectedData.get("completed"), actualData.get("completed"));

        }
 } }








