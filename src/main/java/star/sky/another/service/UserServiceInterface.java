package star.sky.another.service;

import star.sky.another.model.entity.User;

public interface UserServiceInterface {
    Boolean insertUser(User user);

    Boolean deleteUser(Long userId);

    Boolean updateUser(User user);

    User selectUserByUserId(Long userId);

    Boolean login(String email, String password);
}
