package star.sky.another.service.impl;

import org.springframework.stereotype.Service;
import star.sky.another.dao.PersonalMessageMapper;
import star.sky.another.model.entity.PersonalMessage;
import star.sky.another.service.PersonalMessageServiceInterface;

/**
 * @Description
 * @Author Another
 * @Date 2020/4/10 14:26
 **/
@Service
public class PersonalMessageServiceInterfaceImpl implements PersonalMessageServiceInterface {
    private final PersonalMessageMapper personalMessageMapper;

    public PersonalMessageServiceInterfaceImpl(PersonalMessageMapper personalMessageMapper) {
        this.personalMessageMapper = personalMessageMapper;
    }

    @Override
    public Boolean insertPersonalMessage(PersonalMessage personalMessage) {
        return personalMessageMapper.insert(personalMessage) == 1;
    }
}
