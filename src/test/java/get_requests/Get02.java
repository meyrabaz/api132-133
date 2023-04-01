package get_requests;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class Get02 {


    /*
        Given
            https://restful-booker.herokuapp.com/booking/0
        When
            User send a GET Request to the url
        Then
            HTTP Status code should be 404
        And
            Status Line should be HTTP/1.1 404 Not Found
        And
            Response body contains "Not Found"
        And
            Response body does not contain "TechProEd"
        And
            Server is "Cowboy"
     */

    @Test
    public void get02(){
//        i) Set the URL
        String url = "https://restful-booker.herokuapp.com/booking/0";

//        ii) Set the expected data

//        iii) Send the request and get the response
        Response response = given().when().get(url);
        response.prettyPrint();

//        iv) Do assertion
        response.
                then().
                assertThat().
                statusCode(404).//HTTP Status Code should be 404 for negative testing
                statusLine("HTTP/1.1 404 Not Found");//Status Line should be HTTP/1.1 404 Not Found


        // How to Assert If response body contains any data.
        //Responce body contains "not found".
        assertEquals("NotFound",response.asString());  // And Response body contains "Not Found"

        // AssertEquals is to Check the expected data and actual data matches.


        assertFalse(response.asString().contains(("TechProEd")));
        //  Response body does not contain "TechProEd




        //Server is "Cowboy"

        assertTrue(response.header("Server").contains("Cowboy"));

        //assertTrue passes if value between parenthesis is TRUE.
        assertEquals("Cowboy", response.header("Server"));//2nd way==> Recommended





    }
}
