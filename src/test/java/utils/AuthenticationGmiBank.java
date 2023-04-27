package utils;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class AuthenticationGmiBank {

    public static String gmiBankToken() {

        Map<String, Object> postBody = new HashMap<>();
        postBody.put("password", "Mark.123");
        postBody.put("rememberMe", true);
        postBody.put("username", "mark_twain");
        Response response = given().body(postBody).contentType(ContentType.JSON).post("https://gmibank.com/api/authenticate");

        return response.jsonPath().getString("id_token");
    }

}

       // It will return Token but i just want to value of token.
       /* {
            "id_token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtYXJrX3R3YWluIiwiYXV0aCI6IlJPTEVfQURNSU4sUk9MRV9NQU5BR0VSIiwiZXhwIjoxNjgzOTkwNTE0fQ.6y_N938LP9xh6rJlD2JCEXsNuk4jp6QBWXHTuI9p2tIMMGBNJzZ_bQenaNcEq2fYVgwnBkd1o6WQDjiV0zVb-w"
        }     not like this > just value
        So we use jsonpath and string method */

