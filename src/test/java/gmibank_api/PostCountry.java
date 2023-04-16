package gmibank_api;

import base_urls.GmiBankBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.Country;
import pojos.States;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class PostCountry extends GmiBankBaseUrl {

    //Type an automation test that creates a "country" which includes at least 3 "states" using the document
   // https://app.swaggerhub.com/apis/yasinaniltechpro/GmiBank/0.0.1  (The Documentation)


   /*
    Given
        https://gmibank.com/api/tp-countries
    And
        {
          "name": "My Country",
          "states": [
            {
              "id": 0,
              "name": "My State"
            },
            {
              "id": 1,
              "name": "Your State"
            },
            {
              "id": 2,
              "name": "Her State"
            }
          ]
        }

    When
    Send post request
            Then
    Status code should be 201

    And
    Response body should be like:
    {
        "id": 181971,
            "name": "My Country",
            "states": [
        {
            "id": 0,
                "name": "My State",
                "tpcountry": null
        },
        {
            "id": 1,
                "name": "Your State",
                "tpcountry": null
        },
        {
            "id": 2,
                "name": "Her State",
                "tpcountry": null
        }
            ]
    }

*/
     @Test
    public void postCountry (){
         // Set the url

         spec.pathParams("first","api","second","tp-countries");

         // In states pojo, we made we got ignore properties and remove "tpcountries" variable bcs there is an error 400 (bad request,it is null )
         //In countries pojo, we remove "id" variable bcs we are creating new one from the system.
         // Set the expected data.

         States state1 =  new States(0, "My State");
         States state2 =  new States(1, "Your State");
         States state3 =  new States(2, "Her State");

         List<States> statesList = new ArrayList<>();
         statesList.add(state1);
         statesList.add(state2);
         statesList.add(state3);

         Country expectedData = new Country("Mey Country",statesList);

         System.out.println("expectedData = " + expectedData);

         // Send the request and get the response.

       Response response = given(spec).body(expectedData).post("{first}/{second}");

       response.prettyPrint();

        // Do assertion part.

        // 1. Validation
         //1st Validation:
         response.
                 then().
                 statusCode(201).
                 body("name",equalTo(expectedData.getName()),
                         "states.id[0]", equalTo(expectedData.getStates().get(0).getId()),
                         "states.name[0]", equalTo(expectedData.getStates().get(0).getName()),
                         "states.id[1]", equalTo(expectedData.getStates().get(1).getId()),
                         "states.name[1]", equalTo(expectedData.getStates().get(1).getName()),
                         "states.id[2]", equalTo(expectedData.getStates().get(2).getId()),
                         "states.name[2]", equalTo(expectedData.getStates().get(2).getName())

                 );


         // Here if we write for states id 1 states.id[1] actual data is zero so test will not pass.

        // 2. Validation
       /*  Country actualData = ObjectMapperUtils.convertJsonToJavaObject(response.asString(),Country.class);
         System.out.println("actualData = " + actualData);
         assertEquals(201,response.statusCode());
         assertEquals(expectedData.getName(), actualData.getName());

*/







     }
}
