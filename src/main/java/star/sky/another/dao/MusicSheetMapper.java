package star.sky.another.dao;

import star.sky.another.model.MusicSheet;

import java.util.List;

public interface MusicSheetMapper {
    int insert(MusicSheet record);

    List<MusicSheet> selectAll();
}