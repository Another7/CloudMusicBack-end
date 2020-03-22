package star.sky.another.service.impl;

import org.springframework.stereotype.Service;
import star.sky.another.dao.SingerMapper;
import star.sky.another.model.entity.Singer;
import star.sky.another.service.SingerServiceInterface;
import star.sky.another.view.EntityView;

import java.util.List;

/**
 * @Description 歌手服务实现类
 * @Author Another
 * @Date 2020/2/13 15:00
 **/
@Service
public class SingerServiceInterfaceImpl implements SingerServiceInterface {
    private final SingerMapper singerMapper;

    public SingerServiceInterfaceImpl(SingerMapper singerMapper) {
        this.singerMapper = singerMapper;
    }

    @Override
    public EntityView<Singer> register(Singer singer) {
        EntityView<Singer> entityView = new EntityView<>();
        // 先判断邮箱是否已注册
        Singer singerResult = singerMapper.selectBySingerEmail(singer);
        // 未注册
        if (singerResult == null) {
            //TODO 添加邮箱链接确认才能注册的功能
            int result = singerMapper.insert(singer);
            if (result == 1) {
                entityView.setCode("1");
                entityView.setEntity(singerMapper.selectBySingerEmail(singer));
            } else {
                entityView.setCode("0");
            }
            return entityView;
        }
        // 注册过了
        entityView.setCode("2");
        return entityView;
    }

    @Override
    public EntityView<Singer> login(Singer singer) {
        // 先判断账号是否已注册
        EntityView<Singer> entityView = new EntityView<>();
        Singer singerResult = singerMapper.selectBySingerEmail(singer);
        // 未注册
        if (singerResult == null) {
            entityView.setCode("0");
        } else {
            singerResult = singerMapper.selectByEmailAndPassword(singer);
            if (singerResult == null) {
                entityView.setCode("2");
            } else {
                entityView.setCode("1");
                entityView.setEntity(singerResult);
            }
        }
        return entityView;
    }

    @Override
    public Singer selectByEmail(String email) {
        Singer singer = new Singer();
        singer.setEmail(email);
        return singerMapper.selectBySingerEmail(singer);
    }

    @Override
    public List<Singer> selectAll() {
        return singerMapper.selectAll();
    }

    @Override
    public Boolean updateSinger(Singer singer) {
        return singerMapper.updateSinger(singer);
    }

    @Override
    public Boolean deleteSinger(Long id) {
        return singerMapper.deleteByPrimaryKey(id) == 1;
    }
}
