package star.sky.another.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import star.sky.another.model.entity.PersonalMessage;
import star.sky.another.service.PersonalMessageServiceInterface;

/**
 * @Description
 * @Author Another
 * @Date 2020/4/10 14:17
 **/
@RestController
@RequestMapping(value = "/messages")
public class PersonalMessageController {
    private final PersonalMessageServiceInterface personalMessageServiceInterface;

    public PersonalMessageController(PersonalMessageServiceInterface personalMessageServiceInterface) {
        this.personalMessageServiceInterface = personalMessageServiceInterface;
    }

    @PostMapping
    public Boolean sendMessage(@RequestBody PersonalMessage personalMessage) {
        return personalMessageServiceInterface.insertPersonalMessage(personalMessage);
    }
}
