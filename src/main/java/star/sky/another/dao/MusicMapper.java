package star.sky.another.dao;

import org.apache.ibatis.annotations.Param;
import star.sky.another.model.entity.Music;

import java.util.List;

public interface MusicMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Music record);

    Music selectByPrimaryKey(Long id);

    List<Music> selectAll();

    int updateByPrimaryKey(Music record);

    int insertList(@Param(value = "musicList") List<Music> musicList);
}