package star.sky.another.service.impl;

import org.springframework.stereotype.Service;
import star.sky.another.dao.FollowMapper;
import star.sky.another.dao.MomentsMapper;
import star.sky.another.model.entity.Moments;
import star.sky.another.service.MomentsServiceInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @Description
 * @Author Another
 * @Date 2020/4/25 20:59
 **/
@Service
public class MomentsServiceInterfaceImpl implements MomentsServiceInterface {
    private final MomentsMapper momentsMapper;
    private final FollowMapper followMapper;

    public MomentsServiceInterfaceImpl(MomentsMapper momentsMapper, FollowMapper followMapper) {
        this.momentsMapper = momentsMapper;
        this.followMapper = followMapper;
    }

    @Override
    public int insertMoments(Moments moments) {
        return momentsMapper.insert(moments);
    }

    @Override
    public List<Moments> selectMomentsByUserId(Long userId) {
        // 1.查询用户关注的其他用户
        // 2.查询其他用户的动态
        Set<Long> followerIdSet = followMapper.selectFollower(userId);
        if (followerIdSet.size() > 0) {
            return momentsMapper.selectMomentsByCreatorId(followerIdSet);
        }
        return new ArrayList<>();
    }
}
