package star.sky.another.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @Description
 * @Author Another
 * @Date 2020/5/19 16:04
 **/
public class CityCoverTagUtil {
    public static List<Integer> toTag(String cityId) {
        Properties properties = new Properties();
        try {
            properties.load(CityCoverTagUtil.class.getClassLoader().getResourceAsStream("config/citycode-tag.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String tags = properties.getProperty(cityId);
        String[] tagArray = new String[10];
        List<Integer> tagList = new ArrayList();
        if (tags != null) {
            tagArray = tags.split(",");
            for (String s : tagArray) {
                tagList.add(Integer.parseInt(s));
            }
        } else {
            tagList.add(12);
            tagList.add(23);
            tagList.add(34);
            tagList.add(45);
            tagList.add(62);
        }
        return tagList;
    }
}
