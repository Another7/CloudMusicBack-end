package star.sky.another.dao;

import star.sky.another.model.entity.Singer;

import java.util.List;

public interface SingerMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Singer record);

    Singer selectByPrimaryKey(Long id);

    List<Singer> selectAll();

    int updateByPrimaryKey(Singer record);
}