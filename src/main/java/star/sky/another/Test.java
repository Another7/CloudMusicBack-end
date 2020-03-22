package star.sky.another;

import java.io.IOException;
import java.util.Properties;

/**
 * @Description
 * @Author Another
 * @Date 2020/2/24 7:59
 **/
public class Test {
    public static void main(String[] args) throws IOException {
        Properties properties = System.getProperties();
        properties.forEach((key, value) -> {
            System.out.println(key + "---" + value);
        });
    }
}
