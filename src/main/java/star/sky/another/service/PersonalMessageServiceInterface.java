package star.sky.another.service;

import star.sky.another.model.entity.PersonalMessage;

/**
 * @Description
 * @Author Another
 * @Date 2020/4/10 14:25
 **/
public interface PersonalMessageServiceInterface {
    /**
     * 插入一条私信消息
     *
     * @param personalMessage
     * @return
     */
    Boolean insertPersonalMessage(PersonalMessage personalMessage);
}
