package star.sky.another.dao;

import org.apache.ibatis.annotations.Param;
import star.sky.another.model.entity.MusicSheet;

import java.util.List;


public interface MusicSheetMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MusicSheet record);

    MusicSheet selectByPrimaryKey(Long id);

    List<MusicSheet> selectAll();

    int updateByPrimaryKey(MusicSheet record);

    List<MusicSheet> selectByCreatorId(Long creatorId);

    /**
     * 查询播放量最高的热门歌单 默认10张歌单
     *
     * @return
     */
    List<MusicSheet> hotMusicSheet();

    /**
     * 根据歌单id列表查询多个歌单
     *
     * @param idList
     * @return
     */
    List<MusicSheet> selectMusicSheetByIdList(@Param("idList") List<Long> idList);

    /**
     * 根据标签推荐歌单
     *
     * @param tagId
     * @return
     */
    List<MusicSheet> selectMusicSheetByTag(Integer tagId);

    List<MusicSheet> randMusicSheet();
}