package star.sky.another.controller;

import org.springframework.web.bind.annotation.*;
import star.sky.another.model.entity.Moments;
import star.sky.another.service.MomentsServiceInterface;

import java.util.List;

/**
 * @Description
 * @Author Another
 * @Date 2020/4/25 20:58
 **/
@RestController
@RequestMapping(value = "/moments")
public class MomentsController {
    private final MomentsServiceInterface momentsServiceInterface;

    public MomentsController(MomentsServiceInterface momentsServiceInterface) {
        this.momentsServiceInterface = momentsServiceInterface;
    }

    @PostMapping
    @ResponseBody
    public int publishMoments(@RequestBody Moments moments) {
        return momentsServiceInterface.insertMoments(moments);
    }

    @GetMapping(value = "/follow")
    @ResponseBody
    public List<Moments> selectMomentsByUserId(Long userId) {
        return momentsServiceInterface.selectMomentsByUserId(userId);
    }
}
