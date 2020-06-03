package star.sky.another.dao;

import star.sky.another.model.entity.Tag;

import java.util.List;

/**
 * @Description
 * @Author Another
 * @Date 2020/4/28 9:32
 **/
public interface TagMapper {
    List<Tag> selectAll();

    Tag selectTagById(Integer id);
}
