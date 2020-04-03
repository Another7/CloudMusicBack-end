package star.sky.another.controller;

import org.springframework.web.bind.annotation.*;
import star.sky.another.model.entity.User;
import star.sky.another.service.UserServiceInterface;
import star.sky.another.view.EntityView;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    private final UserServiceInterface userServiceInterface;

    public UserController(UserServiceInterface userServiceInterface) {
        this.userServiceInterface = userServiceInterface;
    }

    @DeleteMapping()
    public Boolean deleteUser(@RequestBody Long userId) {
        return userServiceInterface.deleteUser(userId);
    }

    @PutMapping()
    public Boolean updateUser(@RequestBody User user) {
        System.out.println(user);
        return userServiceInterface.updateUser(user);
    }

    @GetMapping()
    public User selectUser(Long userId) {
        return userServiceInterface.selectUserByUserId(userId);
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
}
