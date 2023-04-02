package post_requests;

import base_urls.PetStoreBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.PetStoreTestDataB;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post01b extends PetStoreBaseUrl {


      /*
    Type automation code to create a 'user' by using "https://petstore.swagger.io/"" documantation.
POST User/ Create user


When
            I send POST Request to the Url

        Then
            Status code is 201
        And
            response body is like
                   {
                       "id": 232145,
                       "username": "laris",
                       "firstName": "lariya",
                       "lastName": "danaz",
                       "email": "lariya@gmail.com",
                       "password": "lariya01",
                       "phone": "5454540990",
                       "userStatus": 201     }





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


   */

    @Test
    public void post01b() {
        //Set the url
        spec.pathParam("first", "todos");

        //Set the expected data
        //Create an object from JsonPlaceHolderTestData class and use the expectedDataMapMethod to create "expectedData".
        Map<String, Object> expectedData = new PetStoreTestDataB().expectedDataPetStoreB(232145, "laris", "lariya","danaz", "lariya@gmail.com","lariya01", "5454540990", 201);//Recommended way
        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
        Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().post("{first}");
        response.prettyPrint();

        //Do Assertion
        Map<String, Object> actualData = response.as(HashMap.class);//De-Serialization
        System.out.println("actualData = " + actualData);

        assertEquals(201, response.statusCode());
        assertEquals(expectedData.get("id"), actualData.get("id"));
        assertEquals(expectedData.get("userName"), actualData.get("userName"));
        assertEquals(expectedData.get("firstName"), actualData.get("firstName"));
        assertEquals(expectedData.get("lastName"), actualData.get("lastName"));

    }










}