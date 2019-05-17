package star.sky.another.dao;

import star.sky.another.model.UserCollectionSheet;

import java.util.List;

public interface UserCollectionSheetMapper {
    int insert(UserCollectionSheet record);

    List<UserCollectionSheet> selectAll();
}