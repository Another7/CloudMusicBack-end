package star.sky.another.dao;

import star.sky.another.model.Moments;

import java.util.List;

public interface MomentsMapper {
    int insert(Moments record);

    List<Moments> selectAll();
}