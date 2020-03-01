package star.sky.another.dao;

import star.sky.another.model.entity.Singer;

import java.util.List;

public interface SingerMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Singer singer);

    Singer selectByPrimaryKey(Long id);

    List<Singer> selectAll();

    int updateByPrimaryKey(Singer singer);

    /**
     * 根据邮箱查询歌手是否存在
     *
     * @param singer
     * @return
     */
    Singer selectBySingerEmail(Singer singer);

    /**
     * 根据邮箱账号和密码进行查询
     *
     * @param singer
     * @return
     */
    Singer selectByEmailAndPassword(Singer singer);
}