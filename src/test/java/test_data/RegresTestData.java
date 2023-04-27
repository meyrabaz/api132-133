package test_data;

import java.util.HashMap;
import java.util.Map;


public class RegresTestData {


    public Map<String,String> reqresUsersSetUp(String name, String job){

        Map<String,String> expectedData = new HashMap<>();
        expectedData.put("name", name);
        expectedData.put("job", job);

        return expectedData;

    }
}
