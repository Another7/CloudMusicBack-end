package star.sky.another.service;

import star.sky.another.model.entity.User;
import star.sky.another.view.EntityView;

/**
 * @Description 用户服务接口
 * @Author Another
 * @Date 2020/2/18/ 20:03
 */
public interface UserServiceInterface {
    Boolean insertUser(User user);

    Boolean deleteUser(Long userId);

    Boolean updateUser(User user);

    User selectUserByUserId(Long userId);

    /**
     * 用户注册
     *
     * @param user
     * @return 0 注册失败
     * 1 注册成功
     * 2 已经注册
     */
    EntityView<User> register(User user);

    /**
     * 用户登录
     *
     * @param user
     * @return 0 未注册
     * 1 账号密码匹配，登录成功
     * 2 账号密码不匹配，登录失败
     */
    EntityView<User> login(User user);
}
