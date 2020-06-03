package star.sky.another.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
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
    @ResponseBody
    public String test() {
        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> paramMap = new HashMap<>();
//        String ip = "192.168.0.107";
//        String ip = "192.168.227.1";
        paramMap.put("ak", "bqk76uFTm5s5OOK6XZ2ahlQj8GFwZOFV");
//        paramMap.put("ip", ip);
//        paramMap.put("ip", "");
        return restTemplate.getForObject("http://api.map.baidu.com/location/ip?ak={ak}&ip={ip}", String.class, paramMap);
    }

    @PostMapping(value = "/upload")
    public List<Map<String, String>> upload(HttpServletRequest request) {
//        map的key为"name", value为文件名称，key为url，value为文件的url
        List<Map<String, String>> mapList = new ArrayList<>();
        List<MultipartFile> multipartFileList = ((MultipartHttpServletRequest) request).getFiles("files");
        multipartFileList.forEach(multipartFile -> {
            Map<String, String> nameUrlMap = new HashMap<>();
            nameUrlMap.put("fileName", multipartFile.getOriginalFilename());
//            nameUrlMap.put("url", FileUploadUtil.uploadFile(multipartFile).replaceAll("\\\\", "/"));
            nameUrlMap.put("url", FileUploadUtil.uploadFile(multipartFile));
            mapList.add(nameUrlMap);
        });
        return mapList;
    }
}
