package star.sky.another.dao;

import star.sky.another.model.entity.Follow;

import java.util.List;

public interface FollowMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Follow record);

    Follow selectByPrimaryKey(Long id);

    List<Follow> selectAll();

    int updateByPrimaryKey(Follow record);
}