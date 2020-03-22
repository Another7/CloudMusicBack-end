package star.sky.another.dao;

import org.apache.ibatis.annotations.Param;
import star.sky.another.model.entity.Administrator;

import java.util.List;

public interface AdministratorMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Administrator record);

    Administrator selectByPrimaryKey(Long id);

    List<Administrator> selectAll();

    int updateByPrimaryKey(Administrator record);

    Administrator selectByEmailPassword(@Param("account") String account,
                                        @Param("password") String password);
}