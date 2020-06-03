package star.sky.another.dao;

import star.sky.another.model.entity.UserCollectionSheet;

import java.util.List;

public interface UserCollectionSheetMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserCollectionSheet record);

    UserCollectionSheet selectByPrimaryKey(Long id);

    List<UserCollectionSheet> selectAll();

    int updateByPrimaryKey(UserCollectionSheet record);

    List<UserCollectionSheet> selectByUserId(Long userId);
}