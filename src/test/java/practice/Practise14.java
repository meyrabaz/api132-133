package practice;

import base_urls.JsonPlaceHolderBaseUrl;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import java.util.Map;

public class Practise14 extends JsonPlaceHolderBaseUrl {


//Homework14:
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

    public void practiseDel14 (){



    // Set the url

        spec.pathParams("first","todos","second",198);



    // Set the expected data


        Map<String, Object> expectedData = new JsonPlaceHolderTestData().expectedDataMapMethod(10, "quis eius est sint explicabo", true);
        System.out.println("expectedData = " + expectedData);







    }
}
