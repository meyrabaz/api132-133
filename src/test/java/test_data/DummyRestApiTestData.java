package test_data;
import java.util.HashMap;
import java.util.Map;
public class DummyRestApiTestData {
    public Map<String,Object> expectedDataMethod(String employee_name,Integer employee_salary, Integer employee_age,String profile_image){
        Map<String,Object> expectedData = new HashMap<>();
        if (employee_name != null){
            expectedData.put("employee_name",employee_name);
        }
        if (employee_salary != null){
            expectedData.put("employee_salary",employee_salary);
        }
        if (employee_age != null){
            expectedData.put("employee_age", employee_age);
        }
        if (profile_image != null){
            expectedData.put("profile_image",profile_image);
        }
        return expectedData;
    }
}