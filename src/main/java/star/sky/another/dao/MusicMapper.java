package star.sky.another.dao;

import star.sky.another.model.Music;

import java.util.List;

public interface MusicMapper {
    int insert(Music record);

    List<Music> selectAll();
}