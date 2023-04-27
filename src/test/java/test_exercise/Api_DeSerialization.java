package test_exercise;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Api_DeSerialization extends JsonPlaceHolderBaseUrl {

    @Test

    public void test01(){

        // Set the url

          spec.pathParams("pp1",70);


          //Map oluşturduk, testDataDepota koyabiliriz, burda tekrarlı olmasın diye.
      /*
        Map<String,Object> requestBodyMap = new HashMap<>();

        requestBodyMap.put("title","Ahmet");
        requestBodyMap.put("body","Merhaba");
        requestBodyMap.put("userId",10);
        requestBodyMap.put("id",70);
 */
        //Aşağıda TestDataClassından Obje oluşturuyoruz çünkü extend edemiyoruz.
        // Daha sonra Map oluşturup metodu çağırıyoruz.

        JsonPlaceHolderTestData jsonPlaceHolderTestData = new JsonPlaceHolderTestData();

        Map<String,Object> reqBodyMap = jsonPlaceHolderTestData.expectedDataMapCreate();

        System.out.println(reqBodyMap);


        // Expected Datas oluştur

        Map<String,Object> expectedDataMap = jsonPlaceHolderTestData.expectedDataMapCreate();

        // Get the response

        Response response;
        response = given(spec).
                contentType(ContentType.JSON).
                when().
                body(reqBodyMap).
                put("{pp1}");

        response.prettyPrint();

        // Do Assertion...

        Map<String,Object> respBodyMap = response.as(HashMap.class);
       assertEquals(expectedDataMap.get("title"),respBodyMap.get("title"));
       assertEquals(expectedDataMap.get("body"),respBodyMap.get("body"));
       assertEquals(expectedDataMap.get("userId"),respBodyMap.get("userId"));
       assertEquals(expectedDataMap.get("id"),respBodyMap.get("id"));




    }




}
