package star.sky.another.controller;

import org.springframework.web.bind.annotation.*;
import star.sky.another.model.entity.Music;
import star.sky.another.model.entity.MusicSheet;
import star.sky.another.service.RecommendServiceInterface;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description
 * @Author Another
 * @Date 2020/4/30 9:16
 **/
@RestController
@RequestMapping(value = "/recommend")
public class RecommendController {
    private final RecommendServiceInterface recommendServiceInterface;

    public RecommendController(RecommendServiceInterface recommendServiceInterface) {
        this.recommendServiceInterface = recommendServiceInterface;
    }

    @GetMapping(value = "/music")
    @ResponseBody
    public List<Music> recommendMusicEveryDay(@RequestParam("userId") Long userId, HttpServletRequest httpServletRequest) {
        List<Music> recommendMusicList = new ArrayList<>();
        recommendMusicList.addAll(recommendServiceInterface.contextRecommend(userId, httpServletRequest.getRemoteHost()));
        recommendMusicList.addAll(recommendServiceInterface.userCFRecommend(userId));
        recommendMusicList = recommendMusicList.stream().distinct().limit(20).collect(Collectors.toList());
        if (recommendMusicList.size() == 0) {
            return recommendServiceInterface.randRecommend().stream().distinct().limit(20).collect(Collectors.toList());
        }
        return recommendMusicList;
    }

    @GetMapping(value = "/musicSheet")
    @ResponseBody
    public List<MusicSheet> recommendMusicSheet(Long userId) {
        if (userId == null) {
            userId = 1L;
        }
        return recommendServiceInterface.itemCFRecommend(userId);
    }
}
