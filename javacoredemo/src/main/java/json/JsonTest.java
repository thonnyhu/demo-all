package json;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by Mirana on 2017/8/23.
 */
public class JsonTest {

    private static ObjectMapper objectMapper = new ObjectMapper();


    public static boolean checkJson(String jsonStr){
        boolean valid = true;
        try {
            objectMapper.readTree(jsonStr);
        } catch (IOException e) {
            valid = false;
        }
        return valid;
    }

    @Test
    public void checjJson(){
        String json = "{\"orderid\":\"178981\",\"list\":\"null\",\"app_type\":\"0\"},\"isLogin\":false,\"time\":1503469800}";
        JSONObject dataJson = new JSONObject(json);
        String mobileStr = dataJson.getString("list");
        System.out.println(mobileStr);
        boolean b = checkJson(mobileStr);
        System.out.println(b);

        String wrongJson = "{1112312}";
        boolean b1 = checkJson(wrongJson);
        System.out.println(b1);

    }
}
