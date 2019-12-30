package star.sky.another.dao;

import star.sky.another.model.entity.Moments;

import java.util.List;

public interface MomentsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Moments record);

    Moments selectByPrimaryKey(Long id);

    List<Moments> selectAll();

    int updateByPrimaryKey(Moments record);
}