package star.sky.another.dao;

import star.sky.another.model.entity.Administrator;

import java.util.List;

public interface AdministratorMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Administrator record);

    Administrator selectByPrimaryKey(Long id);

    List<Administrator> selectAll();

    int updateByPrimaryKey(Administrator record);
}