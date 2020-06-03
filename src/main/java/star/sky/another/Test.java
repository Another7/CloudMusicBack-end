package star.sky.another;

import java.util.Random;

/**
 * @Description
 * @Author Another
 * @Date 2020/2/24 7:59
 **/
public class Test {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(new Random(1).nextInt(10));
        }
    }
}
