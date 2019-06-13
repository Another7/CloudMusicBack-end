package star.sky.another.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import star.sky.another.dao.UserMapper;
import star.sky.another.model.entity.User;
import star.sky.another.service.UserServiceInterface;

@Service
public class UserServiceInterfaceImpl implements UserServiceInterface {
    @Autowired
    private UserMapper userMapper;

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
    public Boolean login(String email, String password) {
        return userMapper.selectByEmailPassword(email, password) == null;
    }
}
