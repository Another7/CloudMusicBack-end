package star.sky.another.service;

import star.sky.another.model.entity.User;
import star.sky.another.view.EntityView;
import star.sky.another.view.UserView;

import java.util.List;

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

    /**
     * 根据用户昵称模糊搜索用户
     *
     * @param keyWord 关键词
     * @return 用户列表
     */
    List<UserView> searchUser(String keyWord, Long userId);

    /**
     * 根据用户id查询用户视图
     *
     * @param userId       用户id
     * @param searchUserId 搜索的用户id
     * @return
     */
    UserView selectUserView(Long userId, Long searchUserId);
}
