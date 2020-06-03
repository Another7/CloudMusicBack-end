package star.sky.another.controller;

import org.springframework.web.bind.annotation.*;
import star.sky.another.model.entity.Follow;
import star.sky.another.service.FollowServiceInterface;

import java.util.List;

/**
 * @Description
 * @Author Another
 * @Date 2020/4/9 11:36
 **/
@RestController
@RequestMapping(value = "/follow")
public class FollowController {
    private final FollowServiceInterface followServiceInterface;

    public FollowController(FollowServiceInterface followServiceInterface) {
        this.followServiceInterface = followServiceInterface;
    }

    @PostMapping
    public Boolean insertFollow(@RequestBody Follow follow) {
        return followServiceInterface.insertFollow(follow);
    }

    @DeleteMapping
    public Boolean deleteFollow(Long userId, Long followId) {
        return followServiceInterface.deleteFollow(userId, followId);
    }

    @GetMapping(value = "/singerId")
    @ResponseBody
    public List<Follow> selectFollowBySingerId(Long singerId) {
        return followServiceInterface.selectFollowBySingerId(singerId);
    }

    @GetMapping(value = "/userId")
    @ResponseBody
    public List<Follow> selectFollowByUserId(Long userId) {
        return followServiceInterface.selectFollowByUserId(userId);
    }
}
