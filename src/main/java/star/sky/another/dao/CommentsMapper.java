package star.sky.another.dao;

import star.sky.another.model.entity.Comments;

import java.util.List;

public interface CommentsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Comments record);

    Comments selectByPrimaryKey(Long id);

    List<Comments> selectAll();

    int updateByPrimaryKey(Comments record);
}