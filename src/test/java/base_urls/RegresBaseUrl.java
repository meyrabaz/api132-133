package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class RegresBaseUrl {


    protected RequestSpecification spec ;

    @Before
    public void setup (){
        spec = new RequestSpecBuilder().setBaseUri("https://reqres.in").setContentType(ContentType.JSON).build();
    }
}