package star.sky.another.service.impl;

import org.springframework.stereotype.Service;
import star.sky.another.dao.AlbumMapper;
import star.sky.another.dao.MusicMapper;
import star.sky.another.model.entity.Music;
import star.sky.another.service.MusicServiceInterface;
import star.sky.another.view.MusicView;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author Another
 * @Date 2020/3/1 10:28
 **/
@Service
public class MusicServiceInterfaceImpl implements MusicServiceInterface {
    private final MusicMapper musicMapper;
    private final AlbumMapper albumMapper;

    public MusicServiceInterfaceImpl(MusicMapper musicMapper, AlbumMapper albumMapper) {
        this.musicMapper = musicMapper;
        this.albumMapper = albumMapper;
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

    @Override
    public List<MusicView> searchMusicByKeyWord(String keyWord) {
        List<Music> musicList = musicMapper.searchMusicByKeyWord(keyWord);
        List<MusicView> musicViewList = new ArrayList<>();
        musicList.forEach((music) -> {
            MusicView musicView = new MusicView();
            musicView.setMusic(music);
            musicView.setBelongAlbumImageUrl(albumMapper.selectByPrimaryKey(music.getBelongAlbumId()).getImage());
            musicViewList.add(musicView);
        });
        return musicViewList;
    }
}
