package get_requests;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertTrue;

public class Get05 extends HerOkuAppBaseUrl {

    /*
       Given
           https://restful-booker.herokuapp.com/booking
       When
           User sends get request to the URL
       Then
           Status code is 200
         And
             Among the data there should be someone whose firstname is "Jane" and lastname is "Doe"
    */

  @Test
    public void get05(){

      // SET The URL

      //https://restful-booker.herokuapp.com/    booking   /?    firstname  =   Jane   &     lastname   =   Doe
      //https://restful-booker.herokuapp.com/booking/?firstname=Jane&lastname=Doe

      spec.pathParam("first","booking").queryParam("firstname","John","lastname","Smith");


      // SEt the expected Data

      // Send the request get the response


      Response response = given().spec(spec).when().get("{first}");
      response.prettyPrint();


      //Do assertion
     // response.then().statusCode(200).body("",hasSize(greaterThan()));

     // Second way do assertion


      assertTrue(response.asString().contains("bookingid"));


  }




}
