package star.sky.another.dao;

import org.apache.ibatis.annotations.Param;
import star.sky.another.model.entity.User;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    User selectByPrimaryKey(Long id);

    List<User> selectAll();

    int updateByPrimaryKey(User record);

    User selectByEmailPassword(@Param(value = "email") String email,
                               @Param(value = "password") String password);
}