package get_requests;

import base_urls.RegresBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.RegresTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Practise07 extends RegresBaseUrl {

    @Test

    public void practice07T() {

        //Set the url
        spec.pathParams("first", "api", "second", "users");

        //Set the expected the data
        Map<String,String> expectedData = new RegresTestData().reqresUsersSetUp("morpheus","leader");

        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
        Response response = given(spec).contentType(ContentType.JSON).body(expectedData).when().post("{first}/{second}");
        response.prettyPrint();

        //Do Assertion
        Map<String, String> actualData = response.as(HashMap.class);
        System.out.println("actualData = " + actualData);

        assertEquals(201, response.statusCode());
        assertEquals(expectedData.get("name"), actualData.get("name"));
        assertEquals(expectedData.get("job"), actualData.get("job"));



            }
        }














