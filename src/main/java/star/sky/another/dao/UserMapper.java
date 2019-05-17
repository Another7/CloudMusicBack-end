package star.sky.another.dao;

import star.sky.another.model.User;

import java.util.List;

public interface UserMapper {
    int insert(User record);

    List<User> selectAll();
}