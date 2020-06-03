package star.sky.another.dao;

import org.apache.ibatis.annotations.Param;
import star.sky.another.model.entity.Follow;

import java.util.List;
import java.util.Set;

public interface FollowMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Follow record);

    Follow selectByPrimaryKey(Long id);

    List<Follow> selectAll();

    int updateByPrimaryKey(Follow record);

    /**
     * 根据用户id查询关注的用户id
     *
     * @param userId 用户id
     * @return 该用户关注的用户id集合
     */
    Set<Long> selectFollower(Long userId);

    /**
     * 根据用户id和关注者的id删除关注记录
     *
     * @param userId
     * @param followId
     * @return
     */
    int deleteByUserIdAndFollowId(@Param(value = "userId") Long userId,
                                  @Param(value = "followId") Long followId);

    List<Follow> selectFollowByUserId(Long userId);
}