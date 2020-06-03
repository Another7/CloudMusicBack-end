package star.sky.another.dao;

import org.apache.ibatis.annotations.Param;
import star.sky.another.model.entity.Moments;

import java.util.List;
import java.util.Set;

public interface MomentsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Moments record);

    Moments selectByPrimaryKey(Long id);

    List<Moments> selectAll();

    int updateByPrimaryKey(Moments record);

    List<Moments> selectMomentsByCreatorId(@Param("creatorIdSet") Set<Long> creatorIdSet);
}