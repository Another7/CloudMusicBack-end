package star.sky.another.service;

import star.sky.another.model.entity.Music;
import star.sky.another.model.entity.MusicSheet;

import java.util.List;

/**
 * @Description
 * @Author Another
 * @Date 2020/4/30 10:21
 **/
public interface RecommendServiceInterface {
    /**
     * 使用基于用户的协同过滤算法推荐
     * 即推荐该用户关注用户喜欢的音乐
     *
     * @param userId 用户id
     * @return 推荐的音乐列表
     */
    List<Music> userCFRecommend(Long userId);

    /**
     * 使用基于物品的协同过滤算法推荐
     * 即推荐该用户喜欢歌单的相似歌单
     *
     * @param userId 用户id
     * @return 推荐的歌单列表
     */
    List<MusicSheet> itemCFRecommend(Long userId);

    /**
     * 根据情境推荐音乐
     * 即加入时间，地点等因素对用户进行推荐
     *
     * @param userId 用户id
     * @return 推荐音乐列表
     */
    List<Music> contextRecommend(Long userId, String ip);

    /**
     * 随机推荐
     *
     * @return
     */
    List<Music> randRecommend();
}
