package star.sky.another.service;

import star.sky.another.model.entity.UserCollectionSheet;

import java.util.List;

/**
 * @Description
 * @Author Another
 * @Date 2020/4/24 10:02
 **/
public interface UserCollectionSheetInterface {
    /**
     * 新增用户收藏歌单记录
     *
     * @param userCollectionSheet 用户收藏歌单
     * @return
     */
    int insertUserCollectionSheet(UserCollectionSheet userCollectionSheet);

    /**
     * 查询用户收藏歌单
     *
     * @param userId 用户id
     * @return
     */
    List<UserCollectionSheet> selectUserCollectionSheetByUserId(Long userId);
}
