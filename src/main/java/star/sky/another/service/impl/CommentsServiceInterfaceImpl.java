package star.sky.another.service.impl;

import org.springframework.stereotype.Service;
import star.sky.another.dao.CommentsMapper;
import star.sky.another.model.entity.Comments;
import star.sky.another.service.CommentsServiceInterface;

import java.util.List;

/**
 * @Description
 * @Author Another
 * @Date 2020/4/25 14:15
 **/
@Service
public class CommentsServiceInterfaceImpl implements CommentsServiceInterface {
    private final CommentsMapper commentsMapper;

    public CommentsServiceInterfaceImpl(CommentsMapper commentsMapper) {
        this.commentsMapper = commentsMapper;
    }

    @Override
    public int insertComments(Comments comments) {
        return commentsMapper.insert(comments);
    }

    @Override
    public List<Comments> selectCommentsByMusicId(Long musicId) {
        return commentsMapper.selectMusicComments(musicId);
    }
}
