package star.sky.another.service;

import star.sky.another.model.entity.MusicSheet;
import star.sky.another.view.MusicSheetView;

import java.util.List;

/**
 * @Description
 * @Author Another
 * @Date 2020/4/18 15:11
 **/
public interface MusicSheetServiceInterface {
    /**
     * 根据创建者id查询创建的歌单
     *
     * @param creatorId 创建者id
     * @return 歌单列表
     */
    List<MusicSheet> selectByCreatorId(Long creatorId);

    /**
     * 新增歌单
     *
     * @param musicSheet
     * @return
     */
    int insertMusicSheet(MusicSheet musicSheet);

    /**
     * 根据歌单id查询歌单信息
     *
     * @param sheetId 歌单id
     * @return 歌单信息
     */
    MusicSheetView selectSheetViewBySheetId(Long sheetId);

    /**
     * 添加音乐到歌单
     *
     * @param sheetId 歌单id
     * @param musicId 音乐id
     * @return 是否添加成功
     */
    int addMusicToSheet(Long sheetId, Long musicId);

    /**
     * 更新歌单信息
     *
     * @param musicSheet
     * @return
     */
    int updateMusicSheet(MusicSheet musicSheet);

    /**
     * 根据歌单id删除歌单
     *
     * @param sheetId
     * @return
     */
    int deleteMusicSheet(Long sheetId);

    /**
     * 首页热门推荐
     *
     * @param userId 用户id
     * @return
     */
    List<MusicSheet> selectMusicSheetRecommend(Long userId);
}
