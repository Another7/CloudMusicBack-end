package star.sky.another.service.impl;

import org.springframework.stereotype.Service;
import star.sky.another.dao.UserMapper;
import star.sky.another.model.entity.User;
import star.sky.another.service.UserServiceInterface;
import star.sky.another.view.EntityView;

@Service
public class UserServiceInterfaceImpl implements UserServiceInterface {
    private final UserMapper userMapper;

    public UserServiceInterfaceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
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
        return null;
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
            // 暂时的默认的头像
            user.setImage("http://www.another.ren:8089/images/another.jpg");
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
}
