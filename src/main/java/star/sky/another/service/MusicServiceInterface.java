package star.sky.another.service;

import star.sky.another.model.entity.Music;
import star.sky.another.view.MusicView;

import java.util.List;

/**
 * @Description
 * @Author Another
 * @Date 2020/3/1 10:22
 **/
public interface MusicServiceInterface {
    /**
     * 批量插入歌曲
     *
     * @param musicList
     * @return 影响的行数
     */
    Integer insertMusicList(List<Music> musicList);

    /**
     * 查询全部歌曲
     *
     * @return 歌曲列表
     */
    List<Music> selectAll();

    /**
     * 根据id审核音乐
     *
     * @param idList
     * @return
     */
    Integer musicVerify(List<Long> idList);

    /**
     * 根据关键字模糊搜索音乐
     *
     * @param keyWord 关键字
     * @return 音乐视图
     */
    List<MusicView> searchMusicByKeyWord(String keyWord);
}
