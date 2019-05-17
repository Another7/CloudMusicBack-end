package star.sky.another.dao;

import star.sky.another.model.Follow;

import java.util.List;

public interface FollowMapper {
    int insert(Follow record);

    List<Follow> selectAll();
}