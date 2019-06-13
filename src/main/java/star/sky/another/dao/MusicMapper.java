package star.sky.another.dao;

import star.sky.another.model.entity.Music;

import java.util.List;

public interface MusicMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Music record);

    Music selectByPrimaryKey(Long id);

    List<Music> selectAll();

    int updateByPrimaryKey(Music record);
}