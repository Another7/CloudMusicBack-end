package star.sky.another.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import star.sky.another.model.entity.User;
import star.sky.another.service.UserServiceInterface;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    private final UserServiceInterface userServiceInterface;

    @Autowired
    public UserController(UserServiceInterface userServiceInterface) {
        this.userServiceInterface = userServiceInterface;
    }

    @PostMapping()
    public Boolean registerUser(@RequestBody User user) {
        return userServiceInterface.insertUser(user);
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

    @GetMapping(value = "/login")
    public Boolean login(@RequestParam(value = "email") String email,
                         @RequestParam(value = "password") String password) {
        return userServiceInterface.login(email, password);
    }
}
