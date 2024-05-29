package zwg.org.json;

import cn.hutool.json.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

public class JSONObjectTest {

    @Test
    public void test() {
        String jsonString = "{name:第一个, num:1, age:18, sex:男}";

        // 格式化为符合JSON格式的字符串
//        jsonString = jsonString.replaceAll("([\\{\\}\\[\\],])", "\"$1\"");
        System.out.printf("jsonString:%s\n", jsonString);
        JSONObject jsonObject = new JSONObject(jsonString);
        System.out.printf("jsonObject:%s\n", jsonObject);
        System.out.printf(jsonObject.values().toString());
    }

}
