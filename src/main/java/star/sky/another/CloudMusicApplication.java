package star.sky.another;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "star.sky.another.dao")
public class CloudMusicApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudMusicApplication.class, args);
    }

}
