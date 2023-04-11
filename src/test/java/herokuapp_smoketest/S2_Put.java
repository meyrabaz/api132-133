package herokuapp_smoketest;

import base_urls.HerOkuAppBaseUrl;
import org.junit.Test;

public class S2_Put extends HerOkuAppBaseUrl {
    /*
    Given
        https://restful-booker.herokuapp.com/booking/{id}
    And
        {
            "firstname" : "Mark",
            "lastname" : "Twain",
            "totalprice" : 555,
            "depositpaid" : false,
            "bookingdates" : {
                "checkin" : "2023-01-01",
                "checkout" : "2024-01-01"
            },
            "additionalneeds" : "Extra Pillow"
        }
    When
        Send put request
    Then
        Staus code shour be 200
    And
        Body should be :
           {
            "firstname": "Mark",
            "lastname": "Twain",
            "totalprice": 555,
            "depositpaid": false,
            "bookingdates": {
                "checkin": "2023-01-01",
                "checkout": "2024-01-01"
            },
            "additionalneeds": "Extra Pillow"
        }

     */

    @Test
    public void putTest(){
        //Set the url

        //Set the expected data

        //Send the request and get the response

        //Do assertion


    }
}