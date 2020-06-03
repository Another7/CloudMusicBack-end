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

    /**
     * 根据id审核音乐
     *
     * @param idList
     * @return
     */
    int musicVerify(@Param(value = "idList") List<Long> idList);

    /**
     * 根据关键字模糊搜索音乐
     *
     * @param keyWord 关键字
     * @return
     */
    List<Music> searchMusicByKeyWord(String keyWord);

    /**
     * 根据id查询歌曲
     *
     * @param musicIdList
     * @return
     */
    List<Music> selectMusicByIds(@Param("musicIdList") List<Long> musicIdList);

    /**
     * 根据标签推荐歌曲
     *
     * @param tagId 标签id
     * @return
     */
    List<Music> selectMusicByTag(Integer tagId);

    /**
     * 随机查询
     *
     * @return
     */
    List<Music> randMusic();
}