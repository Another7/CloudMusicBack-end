package star.sky.another.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import star.sky.another.util.FileUploadUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author Another
 * @Date 2020/2/16 10:10
 **/
@RestController
@RequestMapping(value = "/test")
public class TestController {

    @GetMapping
    public String test() {
        return "OK";
    }

    @PostMapping(value = "/upload")
    public List<Map<String, String>> upload(HttpServletRequest request) {
//        map的key为"name", value为文件名称，key为url，value为文件的url
        List<Map<String, String>> mapList = new ArrayList<>();
        List<MultipartFile> multipartFileList = ((MultipartHttpServletRequest) request).getFiles("files");
        multipartFileList.forEach(multipartFile -> {
            Map<String, String> nameUrlMap = new HashMap<>();
            nameUrlMap.put("fileName", multipartFile.getOriginalFilename());
            nameUrlMap.put("url", FileUploadUtil.uploadFile(multipartFile).replaceAll("\\\\", "/"));
            mapList.add(nameUrlMap);
        });
        return mapList;
    }
}
