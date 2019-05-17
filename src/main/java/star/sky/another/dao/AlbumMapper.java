package star.sky.another.dao;

import star.sky.another.model.Album;

import java.util.List;

public interface AlbumMapper {
    int insert(Album record);

    List<Album> selectAll();
}