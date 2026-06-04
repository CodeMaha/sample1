package utils;

import java.io.InputStream;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

public class JsonUtil {

    public static Object[][] getLoginData(String filePath) {

        Object[][] data;

        InputStream is = JsonUtil.class
                .getClassLoader()
                .getResourceAsStream(filePath);

        if (is == null) {
            throw new RuntimeException("File not found: " + filePath);
        }

        JSONTokener tokener = new JSONTokener(is);
        JSONObject jsonObject = new JSONObject(tokener);

        JSONArray array = jsonObject.getJSONArray("loginData");
        data = new Object[array.length()][3];

        for (int i = 0; i < array.length(); i++) {
            data[i][0] = array.getJSONObject(i).getString("username");
            data[i][1] = array.getJSONObject(i).getString("password");
            data[i][2] = array.getJSONObject(i).getString("expected");
        }

        return data;
    }
}