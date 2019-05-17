package star.sky.another.dao;

import star.sky.another.model.Comments;

import java.util.List;

public interface CommentsMapper {
    int insert(Comments record);

    List<Comments> selectAll();
}