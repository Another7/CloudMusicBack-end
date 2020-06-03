package star.sky.another.service;

import star.sky.another.model.entity.Moments;

import java.util.List;

/**
 * @Description
 * @Author Another
 * @Date 2020/4/25 20:59
 **/
public interface MomentsServiceInterface {
    /**
     * 插入一条动态记录
     *
     * @param moments
     * @return
     */
    int insertMoments(Moments moments);

    /**
     * 根据用户id查询其关注用户的动态
     *
     * @param userId
     * @return
     */
    List<Moments> selectMomentsByUserId(Long userId);
}
