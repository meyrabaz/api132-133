package test_data;

import java.util.HashMap;
import java.util.Map;

public class JsonPlaceHolderTestData {

    //This method will create a map for payload
    public Map<String, Object> expectedDataMapMethod(Integer userId, String title, Boolean completed) {
        Map<String, Object> expectedData = new HashMap<>();

        if (userId != null) {
            expectedData.put("userId", userId);
        }
        if (title != null) {
            expectedData.put("title", title);
        }
        if (completed != null) {
            expectedData.put("completed", completed);
        }

        return expectedData;
    }

    public Map<String,Object> expectedDataMapCreate (){



    Map<String,Object> requestBodyMap= new HashMap<>();

        requestBodyMap.put("title","Ahmet");
        requestBodyMap.put("body","Merhaba");
        requestBodyMap.put("userId",10);
        requestBodyMap.put("id",70);
        return requestBodyMap;
}

}