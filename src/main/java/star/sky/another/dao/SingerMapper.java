package star.sky.another.dao;

import star.sky.another.model.Singer;

import java.util.List;

public interface SingerMapper {
    int insert(Singer record);

    List<Singer> selectAll();
}