package star.sky.another.dao;

import star.sky.another.model.entity.PersonalMessage;

import java.util.List;

public interface PersonalMessageMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PersonalMessage record);

    PersonalMessage selectByPrimaryKey(Long id);

    List<PersonalMessage> selectAll();

    int updateByPrimaryKey(PersonalMessage record);
}