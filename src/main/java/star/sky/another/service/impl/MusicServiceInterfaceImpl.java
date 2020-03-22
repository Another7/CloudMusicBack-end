package star.sky.another.service.impl;

import org.springframework.stereotype.Service;
import star.sky.another.dao.MusicMapper;
import star.sky.another.model.entity.Music;
import star.sky.another.service.MusicServiceInterface;

import java.util.List;

/**
 * @Description
 * @Author Another
 * @Date 2020/3/1 10:28
 **/
@Service
public class MusicServiceInterfaceImpl implements MusicServiceInterface {
    private final MusicMapper musicMapper;

    public MusicServiceInterfaceImpl(MusicMapper musicMapper) {
        this.musicMapper = musicMapper;
    }

    @Override
    public Integer insertMusicList(List<Music> musicList) {
        return musicMapper.insertList(musicList);
    }

    @Override
    public List<Music> selectAll() {
        return musicMapper.selectAll();
    }

    @Override
    public Integer musicVerify(List<Long> idList) {
        return musicMapper.musicVerify(idList);
    }
}
