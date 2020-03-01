package star.sky.another.service;

import star.sky.another.model.entity.Singer;
import star.sky.another.view.EntityView;

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
}
