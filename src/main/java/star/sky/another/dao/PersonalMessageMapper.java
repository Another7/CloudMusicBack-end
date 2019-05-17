package star.sky.another.dao;

import star.sky.another.model.PersonalMessage;

import java.util.List;

public interface PersonalMessageMapper {
    int insert(PersonalMessage record);

    List<PersonalMessage> selectAll();
}