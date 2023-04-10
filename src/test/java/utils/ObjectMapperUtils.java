package utils;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

public class ObjectMapperUtils {

    //This method will accept json data as String, then convert it any data type
    public static <T> T convertJsonToJavaObject(String json, Class<T> cls) {//Generic Method
        try {
            return new ObjectMapper().readValue(json, cls);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}