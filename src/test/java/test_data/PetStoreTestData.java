package test_data;

import java.util.HashMap;
import java.util.Map;

public class PetStoreTestData {

    public Map<String,Object> petStoreMapMethod(String username, String firstName, String lastName, String email, String password, String phone, Integer userStatus ){

        Map<String, Object> petStoreMap = new HashMap<>();
        petStoreMap.put("username", username);
        petStoreMap.put("firstName", firstName);
        petStoreMap.put("lastName", lastName);
        petStoreMap.put("email", email);
        petStoreMap.put("password", password);
        petStoreMap.put("phone", phone);
        petStoreMap.put("userStatus", userStatus);

        return petStoreMap;

    }
}

/*
{
                  "username": "JohnDoe",
                  "firstName": "John",
                  "lastName": "Doe",
                  "email": "john@doe.com",
                  "password": "1234",
                  "phone": "1234",
                  "userStatus": 123
                }
 */
