package star.sky.another.service;

import star.sky.another.model.entity.Follow;

import java.util.List;

/**
 * @Description
 * @Author Another
 * @Date 2020/4/9 17:09
 **/
public interface FollowServiceInterface {
    Boolean insertFollow(Follow follow);

    Boolean deleteFollow(Long userId, Long followId);

    List<Follow> selectFollowBySingerId(Long singerId);

    List<Follow> selectFollowByUserId(Long userId);
}
