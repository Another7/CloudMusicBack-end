package star.sky.another.service.impl;

import org.springframework.stereotype.Service;
import star.sky.another.dao.FollowMapper;
import star.sky.another.dao.SingerMapper;
import star.sky.another.dao.UserMapper;
import star.sky.another.model.entity.Follow;
import star.sky.another.model.entity.Singer;
import star.sky.another.model.entity.User;
import star.sky.another.service.FollowServiceInterface;

import java.util.List;

/**
 * @Description
 * @Author Another
 * @Date 2020/4/9 22:06
 **/
@Service
public class FollowServiceInterfaceImpl implements FollowServiceInterface {
    private final FollowMapper followMapper;
    private final SingerMapper singerMapper;
    private final UserMapper userMapper;

    public FollowServiceInterfaceImpl(FollowMapper followMapper, SingerMapper singerMapper, UserMapper userMapper) {
        this.followMapper = followMapper;
        this.singerMapper = singerMapper;
        this.userMapper = userMapper;
    }

    @Override
    public Boolean insertFollow(Follow follow) {
        return followMapper.insert(follow) == 1;
    }

    @Override
    public Boolean deleteFollow(Long userId, Long followId) {
        return followMapper.deleteByUserIdAndFollowId(userId, followId) == 1;
    }

    @Override
    public List<Follow> selectFollowBySingerId(Long singerId) {
        // 先查询出改歌手对应的用户信息
        Singer singer = singerMapper.selectByPrimaryKey(singerId);
        User user = new User();
        user.setEmail(singer.getEmail());
        user = userMapper.selectByUserEmail(user);
        return followMapper.selectFollowByUserId(user.getId());
    }

    @Override
    public List<Follow> selectFollowByUserId(Long userId) {
        return followMapper.selectFollowByUserId(userId);
    }
}
