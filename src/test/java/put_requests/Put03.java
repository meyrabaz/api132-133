package put_requests;

import base_urls.DummyRestApiBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.DummyResponsePojo;
import pojos.DummyRestApiPojo;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Put03 extends DummyRestApiBaseUrl {
    /*
    Given
           1) URL: https://dummy.restapiexample.com/api/v1/update/21
           2)            {
                            "employee_name": "Tom Hanks",
                            "employee_salary": 111111,
                            "employee_age": 23,
                            "profile_image": "Perfect image"
                         }

     When

        I send PUT Request to the Url

     Then
                i) Status code is 200

     And

                ii) Response body should be like the following
                    {
                        "status": "success",

                        "data": {

                            "employee_name": "Tom Hanks",
                            "employee_salary": 111111,
                            "employee_age": 23,
                            "profile_image": "Perfect image"
                        }

                        message": "Successfully! Record has been added."
                    }

     */

    @Test
    public void put02() {

        //Set the url
        spec.pathParams("first","update","second","21");

        //Set the expected data

        DummyRestApiPojo expectedData = new DummyRestApiPojo("Tom Hanks",111111,23,"Perfect image");
        System.out.println("expectedData = " + expectedData);

        //Send the request get the response
        Response response = given(spec).body(expectedData).put("{first}/{second}");
        response.prettyPrint();

        //Do assertion
        DummyResponsePojo actualData = response.as(DummyResponsePojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(200,response.statusCode());
        assertEquals(expectedData.getEmployee_name(),actualData.getData().getEmployee_name());
        assertEquals(expectedData.getEmployee_salary(),actualData.getData().getEmployee_salary());
        assertEquals(expectedData.getEmployee_age(),actualData.getData().getEmployee_age());
        assertEquals(expectedData.getProfile_image(),actualData.getData().getProfile_image());



    }



}



















