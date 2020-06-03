package star.sky.another.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import star.sky.another.dao.TagMapper;
import star.sky.another.model.entity.Tag;

import java.util.List;

/**
 * @Description
 * @Author Another
 * @Date 2020/4/28 15:23
 **/
@RestController
@RequestMapping(value = "/tags")
public class TagController {
    private final TagMapper tagMapper;

    public TagController(TagMapper tagMapper) {
        this.tagMapper = tagMapper;
    }

    @GetMapping(value = "/all")
    @ResponseBody
    public List<Tag> selectAll() {
        return tagMapper.selectAll();
    }

    @GetMapping
    public Tag selectTagById(Integer tagId) {
        return tagMapper.selectTagById(tagId);
    }
}
