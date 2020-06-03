package star.sky.another.dao;

import org.apache.ibatis.annotations.Param;
import star.sky.another.model.entity.User;

import java.util.List;
import java.util.Set;

public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    User selectByPrimaryKey(Long id);

    List<User> selectAll();

    int updateByPrimaryKey(User record);

    User selectByUserEmail(User user);

    User selectByEmailPassword(User user);

    List<User> searchUser(String keyWord);

    List<User> selectSimilarUserByTag(Integer tagId);

    List<User> selectUserByIds(@Param("idSet") Set<Long> idSet);
}