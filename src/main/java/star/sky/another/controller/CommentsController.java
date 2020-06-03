package star.sky.another.controller;

import org.springframework.web.bind.annotation.*;
import star.sky.another.model.entity.Comments;
import star.sky.another.service.CommentsServiceInterface;

import java.util.List;

/**
 * @Description
 * @Author Another
 * @Date 2020/4/25 14:13
 **/
@RestController
@RequestMapping(value = "/comments")
public class CommentsController {
    private final CommentsServiceInterface commentsServiceInterface;

    public CommentsController(CommentsServiceInterface commentsServiceInterface) {
        this.commentsServiceInterface = commentsServiceInterface;
    }

    @PostMapping
    @ResponseBody
    public int publishComments(@RequestBody Comments comments) {
        return commentsServiceInterface.insertComments(comments);
    }

    @GetMapping
    @ResponseBody
    public List<Comments> selectCommentsByMusicId(Long musicId) {
        return commentsServiceInterface.selectCommentsByMusicId(musicId);
    }
}
