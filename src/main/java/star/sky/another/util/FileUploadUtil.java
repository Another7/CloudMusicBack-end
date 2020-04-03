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
    private static String platform = System.getProperty("os.name");
    private static String basePath;

    static {
        basePath = platform.contains("Windows") ? "D:/data" : "/home/nginx/data";
    }

    public static String uploadFile(MultipartFile multipartFile) {
        String contentType = multipartFile.getContentType();
        System.out.println("contentType = " + contentType);
        String path = "";
        if (contentType.startsWith("image/")) {
            path = basePath + "/images/";
        } else if (contentType.startsWith("audio/")) {
            path += basePath + "/audios/";
        }
//        File pathFile = new File(path);
//        if (!pathFile.exists()) {
//            pathFile.mkdirs();
//        }
//        System.out.println("path = " + path);
        String fileSuffix = multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf("."));
        File file = new File(path + File.separator
                + UUID.randomUUID().toString() + fileSuffix);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        System.out.println("file = " + file.getPath());
        // linux 上的权限问题，可以解决windows上的可以上传文件，而linux上失败的问题
//        boolean writeAble = file.setWritable(true, false);
//        System.out.println("file.setWritable" + writeAble);
//        if (!file.exists()) {
//            try {
//                boolean flag = file.createNewFile();
//                System.out.println("createNewFile() = " + flag);
//            } catch (IOException e) {
//                e.printStackTrace();
//                System.out.println("targetFile create failed");
//            }
//        }
        try {
            multipartFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("multipartFile.transferTo failed");
        }
        return file.getName();
    }
}
