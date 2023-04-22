package put_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.JsonPlaceHolderPojo;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Put04 extends JsonPlaceHolderBaseUrl {


      /*
        Given
            https://jsonplaceholder.typicode.com/todos/198
        When
            I send DELETE Request to the Url
        Then
            Status code is 200
            And Response body is { }
     */


    @Test
    public void put04(){

        //Set the url
        spec.pathParams("first","todos","second",198);

        //Set the expected data
        String expectedData = "{}";

        //Send the request get the response
        Response response = given(spec).delete("{first}/{second}");
         //  response.prettyPrint();

         //Do assertion
         JsonPlaceHolderPojo actualData = response.as(JsonPlaceHolderPojo.class);
         //   System.out.println("actualData = " + actualData);

        assertEquals(200,response.statusCode());
        assertEquals(expectedData, response.asString());

    }
}