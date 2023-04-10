package practice;

import base_urls.PetStoreBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.PetStoreTestData;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class Practice08 extends PetStoreBaseUrl {
    /*
    Type automation code to create a 'user' by using "https://petstore.swagger.io/"" documantation.
    */
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

    public void practice08(){
        //Set the url
        spec.pathParams("first","v2","second","user");

        //Set the expected data
        Map<String,Object> expectedData = new PetStoreTestData().petStoreMapMethod("JohnDoe", "John", "Doe","john@doe.com","1234","1234",123);
        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
        Response response = given(spec).contentType(ContentType.JSON).body(expectedData).when().post("{first}/{second}");
        response.prettyPrint();

        //Do assertion






   /* @Test

    public void practice08P(){
        //Set the url
        spec.pathParams("first","v2","second","user");

        //Set the expected data
        PetStorePojo expectedData = new PetStorePojo("JohnDoe","John","Doe","john@doe.com","1234","1234",123);
        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
        Response response = given(spec).body(expectedData).post("{first}/{second}");
        response.prettyPrint();

        //Do assertion
        PetStorePojo actualData = response.as(PetStorePojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(200,response.getStatusCode());

*/
    }


}









