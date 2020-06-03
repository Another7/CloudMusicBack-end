package star.sky.another.controller;

import org.springframework.web.bind.annotation.*;
import star.sky.another.model.entity.User;
import star.sky.another.service.SingerServiceInterface;
import star.sky.another.service.UserServiceInterface;
import star.sky.another.view.EntityView;
import star.sky.another.view.UserView;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    private final UserServiceInterface userServiceInterface;

    public UserController(UserServiceInterface userServiceInterface, SingerServiceInterface singerServiceInterface) {
        this.userServiceInterface = userServiceInterface;
    }

    @DeleteMapping()
    public Boolean deleteUser(@RequestBody Long userId) {
        return userServiceInterface.deleteUser(userId);
    }

    @PutMapping()
    public Boolean updateUser(@RequestBody User user) {
        return userServiceInterface.updateUser(user);
    }

    @GetMapping()
    public User selectUser(Long userId) {
        return userServiceInterface.selectUserByUserId(userId);
    }

    @GetMapping(value = "/view")
    public UserView selectUserView(Long userId, Long searchUserId) {
        return userServiceInterface.selectUserView(userId, searchUserId);
    }

    @PostMapping()
    public EntityView<User> registerUser(@RequestBody User user) {
        return userServiceInterface.register(user);
    }

    @GetMapping(value = "/login")
    public EntityView<User> login(@RequestParam(value = "email") String email,
                                  @RequestParam(value = "password") String password) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        return userServiceInterface.login(user);
    }

    @GetMapping(value = "/keyWord")
    public List<UserView> searchUser(String keyWord, Long userId) {
        return userServiceInterface.searchUser(keyWord, userId);
    }
}
