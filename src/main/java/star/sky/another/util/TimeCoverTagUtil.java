package star.sky.another.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author Another
 * @Date 2020/5/19 15:52
 **/
public class TimeCoverTagUtil {
    public static List<Integer> toTag(int hour) {
        List<Integer> tagList = new ArrayList<>();
        if (hour < 6) {
            tagList.add(12);
            tagList.add(16);
            tagList.add(21);
            tagList.add(29);
            tagList.add(30);
            tagList.add(42);
        } else if (hour < 12) {
            tagList.add(1);
            tagList.add(14);
            tagList.add(26);
            tagList.add(23);
            tagList.add(35);
        } else if (hour < 16) {
            tagList.add(24);
            tagList.add(56);
            tagList.add(39);
            tagList.add(19);
            tagList.add(20);
        } else {
            tagList.add(33);
            tagList.add(35);
            tagList.add(37);
            tagList.add(57);
            tagList.add(58);
        }
        return tagList;
    }
}
