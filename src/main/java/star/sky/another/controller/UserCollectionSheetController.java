package star.sky.another.controller;

import org.springframework.web.bind.annotation.*;
import star.sky.another.model.entity.UserCollectionSheet;
import star.sky.another.service.UserCollectionSheetInterface;

import java.util.List;

/**
 * @Description
 * @Author Another
 * @Date 2020/4/24 10:01
 **/
@RestController
@RequestMapping(value = "/UserCollectionSheet")
public class UserCollectionSheetController {
    private final UserCollectionSheetInterface userCollectionSheetInterface;

    public UserCollectionSheetController(UserCollectionSheetInterface userCollectionSheetInterface) {
        this.userCollectionSheetInterface = userCollectionSheetInterface;
    }

    @PostMapping
    @ResponseBody
    public int addUserCollectionSheet(@RequestBody UserCollectionSheet userCollectionSheet) {
        return userCollectionSheetInterface.insertUserCollectionSheet(userCollectionSheet);
    }

    @GetMapping(value = "/userId")
    @ResponseBody
    public List<UserCollectionSheet> selectByUserId(Long userId) {
        return userCollectionSheetInterface.selectUserCollectionSheetByUserId(userId);
    }
}
