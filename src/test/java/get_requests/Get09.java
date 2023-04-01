package get_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceOrderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get09 extends JsonPlaceHolderBaseUrl {

    /*
    Given
       https://jsonplaceholder.typicode.com/todos/2
   When
       I send GET Request to the URL
   Then
       Status code is 200
       And "completed" is false
       And "userId" is 1
       And "title" is "quis ut nam facilis et officia qui"
       And header "Via" is "1.1 vegur"
       And header "Server" is "cloudflare"
       {
           "userId": 1,
           "id": 2,
           "title": "quis ut nam facilis et officia qui",
           "completed": false

       }
*/


    @Test
    public void get09 (){
    // Set the url

        spec.pathParams("first","todos", "second",2);


                // Set the expected data

                Map<String, Object> expectedData = new JsonPlaceOrderTestData().expectedDataMapMethod(1,"quis ut nam facilis et officia qui",false);

        System.out.println("expected data is : " + expectedData);

        //Send the request and get the response
        Response response = given(spec).get("{first}/{second}");
        response.prettyPrint();

        //Do assertion
        Map<String, Object> actualData = response.as(HashMap.class);//De-Serialization
        System.out.println("actualData = " + actualData);

        assertEquals(200, response.statusCode());
        assertEquals(expectedData.get("userId"), actualData.get("userId"));
        assertEquals(expectedData.get("title"), actualData.get("title"));
        assertEquals(expectedData.get("completed"), actualData.get("completed"));

        assertEquals(expectedData.get("Via"), response.header("Via"));
        assertEquals(expectedData.get("Server"), response.header("Server"));
    }

    public static class Get01 {

     /*
       Given
           https://restful-booker.herokuapp.com/booking/10
       When
           User sends a GET Request to the url
       Then
           HTTP Status Code should be 200
       And
           Content Type should be JSON
       And
           Status Line should be HTTP/1.1 200 OK

    */


        @Test

        public void get01(){


            // 1.Set the url

            String url = " https://restful-booker.herokuapp.com/booking/10";

            // 2.Set the expected data

            // 3.Send request and get response

            Response response = given().when().get(url);
            response.prettyPrint();

            //4.Do assertion

            response.
                    then().
                    assertThat().     // without assertThat it will be work again
                    statusCode(200).  //HTTP Status Code should be 200
                    contentType("application/json").  //Content Type should be JSON
                    statusLine("HTTP/1.1 200 OK");    //Status Line should be HTTP/1.1 200 OK

        }

    }
}














