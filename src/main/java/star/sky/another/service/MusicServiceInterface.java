package star.sky.another.service;

import star.sky.another.model.entity.Music;

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
}
