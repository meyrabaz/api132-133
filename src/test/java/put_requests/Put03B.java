package put_requests;


import base_urls.DummyRestApiBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.DummyRestApiTestData;
import utils.ObjectMapperUtils;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
public class Put03B extends DummyRestApiBaseUrl{
    /*
     Given
         1)https://dummy.restapiexample.com/api/v1/update/21
         2){
              "employee_name": "Tom Hanks",
              "employee_salary": 111111,
              "employee_age": 23,
              "profile_image": "Perfect image"
           }
     When
          Send the PUT request to the URL
     Then
          Status code is 200
     And
          Response body should be like:

                 {
                      "status": "success",
                      "data": {
                          "employee_name": "Tom Hanks",
                          "employee_salary": 111111,
                          "employee_age": 23,
                          "profile_image": "Perfect image"
                      },
                      "message": "Successfully! Record has been added."
                  }

   */
    @Test
    public void put03B(){
        //Set the URL
        spec.pathParams("first","api","second","v1","third","update","fourth",21);
        //Set the expected data
        Map<String,Object> expectedData = new DummyRestApiTestData().expectedDataMethod("Tom Hanks",111111,23,"Perfect image");
        System.out.println("expectedData = " + expectedData);
        //Send the request and get the response
        Response response = given(spec).body(expectedData).put("{first}/{second}/{third}/{fourth}");
        response.prettyPrint();
        //Do Assertion
        HashMap actualData = ObjectMapperUtils.convertJsonToJavaObject(response.asString(), HashMap.class);
        System.out.println("actualData = " + actualData);
        assertEquals(200,response.statusCode());
        assertEquals(expectedData.get("data.employee_name"),actualData.get("data.employee_name"));
        assertEquals(expectedData.get("data.employee_salary"),actualData.get("data.employee_salary"));
        assertEquals(expectedData.get("data.employee_age"),actualData.get("data.employee_age"));
        assertEquals(expectedData.get("data.profile_image"),actualData.get("data.profile_image"));
    }
}

