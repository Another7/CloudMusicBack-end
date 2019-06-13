package star.sky.another.dao;

import star.sky.another.model.entity.Album;

import java.util.List;


public interface AlbumMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Album record);

    Album selectByPrimaryKey(Long id);

    List<Album> selectAll();

    int updateByPrimaryKey(Album record);
}