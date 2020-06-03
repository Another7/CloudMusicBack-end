package star.sky.another.service.impl;

import org.springframework.stereotype.Service;
import star.sky.another.dao.FollowMapper;
import star.sky.another.dao.SingerMapper;
import star.sky.another.dao.UserMapper;
import star.sky.another.model.entity.Singer;
import star.sky.another.model.entity.User;
import star.sky.another.service.UserServiceInterface;
import star.sky.another.view.EntityView;
import star.sky.another.view.UserView;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceInterfaceImpl implements UserServiceInterface {
    private final UserMapper userMapper;
    private final FollowMapper followMapper;
    private final SingerMapper singerMapper;

    public UserServiceInterfaceImpl(UserMapper userMapper, FollowMapper followMapper, SingerMapper singerMapper) {
        this.userMapper = userMapper;
        this.followMapper = followMapper;
        this.singerMapper = singerMapper;
    }

    @Override
    public Boolean insertUser(User user) {
        return userMapper.insert(user) == 1;
    }

    @Override
    public Boolean deleteUser(Long userId) {
        return null;
    }

    @Override
    public Boolean updateUser(User user) {
        return userMapper.updateByPrimaryKey(user) == 1;
    }

    @Override
    public User selectUserByUserId(Long userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public EntityView<User> register(User user) {
        EntityView<User> entityView = new EntityView<>();
        // 判断是否已经注册
        User userResult = userMapper.selectByUserEmail(user);
        // 未注册
        if (userResult == null) {
            user.setMomentNumber(0);
            user.setFollowNumber(0);
            user.setFollowerNumber(0);
            user.setTag("[]");
            // 暂时的默认的头像
            user.setImage("another.jpg");
            int result = userMapper.insert(user);
            if (result == 1) {
                entityView.setCode("1");
                entityView.setEntity(userMapper.selectByUserEmail(user));
            } else {
                entityView.setCode("0");
            }
            return entityView;
        }
        // 注册过了
        entityView.setCode("2");
        return entityView;
    }

    @Override
    public EntityView<User> login(User user) {
        EntityView<User> entityView = new EntityView<>();
        User userResult = userMapper.selectByUserEmail(user);
        if (userResult == null) {
            entityView.setCode("0");
        } else {
            userResult = userMapper.selectByEmailPassword(user);
            if (userResult == null) {
                entityView.setCode("2");
            } else {
                entityView.setCode("1");
                entityView.setEntity(userResult);
            }
        }
        return entityView;
    }

    @Override
    public List<UserView> searchUser(String keyWord, Long userId) {
        List<User> userList = userMapper.searchUser(keyWord);
        List<UserView> userViewList = new ArrayList<>();
        Set<Long> followerIdSet = followMapper.selectFollower(userId);
        userList.forEach((user) -> {
            UserView userView = new UserView();
            userView.setUser(user);
            userView.setFollowed(followerIdSet.contains(user.getId()));
            userViewList.add(userView);
        });
        return userViewList;
    }

    @Override
    public UserView selectUserView(Long userId, Long searchUserId) {
        UserView userView = new UserView();
        User user = selectUserByUserId(searchUserId);
        userView.setUser(user);
        Singer singer = new Singer();
        singer.setEmail(user.getEmail());
        singer = singerMapper.selectBySingerEmail(singer);
        // 搜索用户是否是歌手
        userView.setSinger(singer != null);
        Set<Long> followerIdSet = followMapper.selectFollower(userId);
        // 该用户是否已关注搜索用户
        userView.setFollowed(followerIdSet.contains(searchUserId));
        return userView;
    }
}
