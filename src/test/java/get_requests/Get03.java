package get_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;


import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class Get03 extends JsonPlaceHolderBaseUrl {
  /*
        Given
            https://jsonplaceholder.typicode.com/todos/23
        When
            User send GET Request to the URL
        Then
            HTTP Status Code should be 200
      And
          Response format should be "application/json"
      And
          "title" is "et itaque necessitatibus maxime molestiae qui quas velit",
      And
          "completed" is false
      And
          "userId" is 2
     */

    @Test
    public void get03() {
        //Set the Url
        // String url = "https://jsonplaceholder.typicode.com/todos/23"; ==> This is not recommended way --> We will create base_urls package
        spec.pathParams("first", "todos", "second", 23);

        //Set the expected data


        //Send the request and get the response
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //Do assertion
        //1st way.
        response.
                then().
                statusCode(200).
                contentType("application/json").
                body("title", equalTo("et itaque necessitatibus maxime molestiae qui quas velit")).
                body("userId", equalTo(2)).
                body("completed", equalTo(false));

        //2nd Way:
        response.
                then().
                statusCode(200).
                contentType(ContentType.JSON).
                body("title", equalTo("et itaque necessitatibus maxime molestiae qui quas velit"),
                        "userId", equalTo(2),
                        "completed", equalTo(false));

        /*
        Note 1: When you run the code, Java stops execution after the first failure.
                So, assertion after the failure will not be excuted.
                But the assertions before failure will pass because there executed and there were no failure.
        Note 2: If you type your code as execution will stop in the first failure. This is called "Hard Assertion"
        Note 3: If you type your code as execution will NOT stop in failures. This is called "Soft Assertion"
        Note 4: If you use multiple body() method, it will work like  "Hard Assertion".
        Note 5: If you do multiple assertion in a single body() method, it will work like  "Soft Assertion".


         */
    }

}