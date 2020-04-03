package star.sky.another.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;
import star.sky.another.model.entity.Music;
import star.sky.another.service.MusicServiceInterface;
import star.sky.another.view.MusicView;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description
 * @Author Another
 * @Date 2020/3/12 15:45
 **/
@RestController
@RequestMapping(value = "/musics")
public class MusicController {
    private final MusicServiceInterface musicServiceInterface;

    public MusicController(MusicServiceInterface musicServiceInterface) {
        this.musicServiceInterface = musicServiceInterface;
    }

    /**
     * 查询未审核的音乐
     *
     * @return
     */
    @GetMapping
    @ResponseBody
    public List<Music> selectAll() {
        List<Music> musicList = musicServiceInterface.selectAll();
        // 过滤掉已经通过审核的歌曲
        return musicList.stream().filter(music -> music.getStatus() == 0).collect(Collectors.toList());
    }

    @PutMapping(value = "/verify")
    @ResponseBody
    public Integer musicVerify(@RequestBody String ids) {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = null;
        try {
            jsonNode = objectMapper.readTree(ids);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] strings = jsonNode.get("ids").asText().split(",");
        Long[] idList = new Long[strings.length];
        for (int i = 0; i < strings.length; i++) {
            idList[i] = Long.parseLong(strings[i]);
        }
        return musicServiceInterface.musicVerify(Arrays.asList(idList));
    }

    @GetMapping(value = "/keyWord")
    @ResponseBody
    public List<MusicView> searchMusicByKeyWord(String keyWord) {
        return musicServiceInterface.searchMusicByKeyWord(keyWord);
    }
}
