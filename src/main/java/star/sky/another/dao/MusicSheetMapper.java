package star.sky.another.dao;

import star.sky.another.model.entity.MusicSheet;

import java.util.List;


public interface MusicSheetMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MusicSheet record);

    MusicSheet selectByPrimaryKey(Long id);

    List<MusicSheet> selectAll();

    int updateByPrimaryKey(MusicSheet record);
}