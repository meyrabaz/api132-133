package get_requests;

import base_urls.HerOkuAppBaseUrl;
import org.junit.Test;

public class Get11 extends HerOkuAppBaseUrl {

    /*
    Given
        https://restful-booker.herokuapp.com/booking/9525
    When
        I send GET Request to the url
    Then
        Response body should be like that;
        {
            "firstname": "Jane",
            "lastname": "Doe",
            "totalprice": 111,
            "depositpaid": true,
            "bookingdates": {
                "checkin": "2018-01-01",
                "checkout": "2019-01-01"
            },
            "additionalneeds": "Extra pillows please"
        }
 */

    @Test
    public void get11 (){


        // Set the Url

        spec.pathParams("first","booking","second",49);

        // Set the expected data



















    }

}
