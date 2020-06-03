package star.sky.another.service;

import star.sky.another.model.entity.Comments;

import java.util.List;

/**
 * @Description
 * @Author Another
 * @Date 2020/4/25 14:15
 **/
public interface CommentsServiceInterface {
    /**
     * 新增评论
     *
     * @param comments
     * @return
     */
    int insertComments(Comments comments);

    /**
     * 获取歌曲评论
     *
     * @param musicId 歌曲id
     * @return
     */
    List<Comments> selectCommentsByMusicId(Long musicId);
}
