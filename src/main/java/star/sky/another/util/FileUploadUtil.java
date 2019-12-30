package star.sky.another.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.time.LocalDate;

/**
 * @Description
 * @Author Another
 * @Date 2019/06/29 17:48
 **/
public class FileUploadUtil {
    public static String uploadFile(MultipartFile multipartFile){
        String relativePath = "";
        File file = new File("/" + LocalDate.now().toString() + File.separator + multipartFile.getOriginalFilename());
        try {
            multipartFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return relativePath;
    }
}
