package test_data;

import java.util.HashMap;
import java.util.Map;

public class PetStoreTestDataB {



    public Map<String, Object> expectedDataPetStoreB (Integer id, String userName, String firstName, String lastName,
      String email, String password, String phone, Integer userStatus) {
        Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("id", id);
        expectedData.put("userName", userName);
        expectedData.put("firstName", firstName);
        expectedData.put("lastName", lastName);
        expectedData.put("email", email);
        expectedData.put("password", password);
        expectedData.put("phone", phone);
        expectedData.put("userStatus", userStatus);


        return expectedData;
    }
}
