package star.sky.another.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import star.sky.another.dao.AdministratorMapper;
import star.sky.another.model.entity.Administrator;

/**
 * @Description
 * @Author Another
 * @Date 2020/3/7 10:24
 **/
@RestController
@RequestMapping(value = "/administrator")
public class AdministratorController {
    private final AdministratorMapper administratorMapper;

    public AdministratorController(AdministratorMapper administratorMapper) {
        this.administratorMapper = administratorMapper;
    }

    @GetMapping
    public Administrator login(String account, String password) {
        return administratorMapper.selectByEmailPassword(account, password);
    }
}
