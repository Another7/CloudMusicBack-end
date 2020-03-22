package star.sky.another.service;

import star.sky.another.model.entity.Singer;
import star.sky.another.view.EntityView;

import java.util.List;

/**
 * @Description 歌手服务接口
 * @Author Another
 * @Date 2020/2/13 8:19
 **/
public interface SingerServiceInterface {
    /**
     * 歌手注册
     *
     * @param singer
     * @return 0 注册失败
     * 1 注册成功
     * 2 已经注册
     */
    EntityView<Singer> register(Singer singer);

    /**
     * 歌手登录
     *
     * @param singer
     * @return 0 未注册
     * 1 账号密码匹配，登录成功
     * 2 账号密码不匹配，登录失败
     */
    EntityView<Singer> login(Singer singer);

    /**
     * 根据歌手邮箱查询歌手
     *
     * @param email 邮箱
     * @return 歌手
     */
    Singer selectByEmail(String email);

    /**
     * 查询所有歌手信息
     *
     * @return
     */
    List<Singer> selectAll();

    /**
     * 更新歌手信息
     *
     * @param singer
     * @return
     */
    Boolean updateSinger(Singer singer);

    /**
     * 根据id删除歌手
     *
     * @param id
     * @return
     */
    Boolean deleteSinger(Long id);
}
