package practice;

import base_urls.RegresBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.anEmptyMap;

public class Practice02 extends RegresBaseUrl {

    /*
        Given
            https://reqres.in/api/users/23
        When
            User send a GET Request to the url
        Then
            HTTP Status code should be 404
        And
            Status Line should be HTTP/1.1 404 Not Found
        And
            Server is "cloudflare"
        And
            Response body should be empty

     */
    @Test
    public void get02() throws IOException {
        //Set the url
        spec.pathParams("first","users","second",23);

        //Set the expected data

        //Send the request and get the response
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();


        response.
                then().
                statusCode(404).
                statusLine("HTTP/1.1 404 Not Found").
                header("Server","cloudflare").
                body("", anEmptyMap());//This is no key value pair in the response body. So it is an empty map.



    }
}