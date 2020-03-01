package star.sky.another.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @Description
 * @Author Another
 * @Date 2019/06/29 17:48
 **/
public class FileUploadUtil {
    public static String uploadFile(MultipartFile multipartFile) {
//        String path = System.getProperty("user.home") + File.separator + "cloudMusic" + File.separator + "data"
//                + File.separator + UUID.randomUUID().toString();
        String imagePath = "D:/data/images";
        String audioPath = "D:/data/audios";
        String contentType = multipartFile.getContentType();
        String path = "";
        if (contentType.startsWith("image/")) {
            path = imagePath;
        } else if (contentType.startsWith("audio/")) {
            path = audioPath;
        }
        File pathFile = new File(path);
        if (!pathFile.exists()) {
            pathFile.mkdirs();
        }
        String fileSuffix = multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf("."));
        File file = new File(path + File.separator
                + UUID.randomUUID().toString() + fileSuffix);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            multipartFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file.getAbsolutePath();
    }
}
