package star.sky.another.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.springframework.stereotype.Service;
import star.sky.another.dao.MusicMapper;
import star.sky.another.dao.MusicSheetMapper;
import star.sky.another.dao.UserMapper;
import star.sky.another.model.entity.Music;
import star.sky.another.model.entity.MusicSheet;
import star.sky.another.model.entity.User;
import star.sky.another.service.MusicSheetServiceInterface;
import star.sky.another.view.MusicSheetView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author Another
 * @Date 2020/4/18 15:15
 **/
@Service
public class MusicSheetServiceInterfaceImpl implements MusicSheetServiceInterface {
    private final MusicSheetMapper musicSheetMapper;
    private final UserMapper userMapper;
    private final MusicMapper musicMapper;

    public MusicSheetServiceInterfaceImpl(MusicSheetMapper musicSheetMapper, UserMapper userMapper, MusicMapper musicMapper) {
        this.musicSheetMapper = musicSheetMapper;
        this.userMapper = userMapper;
        this.musicMapper = musicMapper;
    }

    @Override
    public List<MusicSheet> selectByCreatorId(Long creatorId) {
        return musicSheetMapper.selectByCreatorId(creatorId);
    }

    @Override
    public int insertMusicSheet(MusicSheet musicSheet) {
        musicSheet.setTag("[]");
        return musicSheetMapper.insert(musicSheet);
    }

    @Override
    public MusicSheetView selectSheetViewBySheetId(Long sheetId) {
        MusicSheetView musicSheetView = new MusicSheetView();
        MusicSheet musicSheet = musicSheetMapper.selectByPrimaryKey(sheetId);
        musicSheetView.setMusicSheet(musicSheet);
        User user = userMapper.selectByPrimaryKey(musicSheet.getCreatorId());
        musicSheetView.setCreatorImage(user.getImage());
        // 添加歌单收藏的音乐列表
        String collectionMusic = musicSheet.getCollectionMusic();
        List<Music> musicList = new ArrayList<>();
        ArrayNode arrayNode = null;
        try {
            arrayNode = (ArrayNode) new ObjectMapper().readTree(collectionMusic);
            if (arrayNode.size() > 0) {
                List<Long> musicIdList = new ArrayList<>();
                arrayNode.forEach(node -> {
                    musicIdList.add(node.longValue());
                });
                musicList = musicMapper.selectMusicByIds(musicIdList);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        musicSheetView.setMusicList(musicList);
        return musicSheetView;
    }

    @Override
    public int addMusicToSheet(Long sheetId, Long musicId) {
        // 1.先查出歌单
        // 2.解析歌单中包含的音乐
        // 3.添加音乐到歌单包含的音乐
        // 4.更新歌单
        MusicSheet musicSheet = musicSheetMapper.selectByPrimaryKey(sheetId);
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayNode arrayNode = null;
        String collectionMusic = musicSheet.getCollectionMusic();
        if (collectionMusic == null) {
            collectionMusic = "[]";
        }
        try {
            arrayNode = (ArrayNode) objectMapper.readTree(collectionMusic);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert arrayNode != null;
        // 避免歌曲id重复
        boolean flag = true;
        for (int i = 0; i < arrayNode.size(); i++) {
            if (arrayNode.get(i).asLong() == musicId) {
                flag = false;
                break;
            }
        }
        if (flag) {
            arrayNode.add(musicId);
        }
        musicSheet.setCollectionMusic(arrayNode.toString());
        return musicSheetMapper.updateByPrimaryKey(musicSheet);
    }

    @Override
    public int updateMusicSheet(MusicSheet musicSheet) {
        return musicSheetMapper.updateByPrimaryKey(musicSheet);
    }

    @Override
    public int deleteMusicSheet(Long sheetId) {
        return musicSheetMapper.deleteByPrimaryKey(sheetId);
    }

    @Override
    public List<MusicSheet> selectMusicSheetRecommend(Long userId) {
        // 如果userId为空，则查询出播放量最高的热门歌单
        // 如果userId不为空，则根据userId的用户的标签推荐首页推荐歌单
//        return null != userId ? musicSheetMapper.recommendMusicSheet(userId) : musicSheetMapper.hotMusicSheet();
        if (userId == null) {
            return musicSheetMapper.hotMusicSheet();
        } else {
            //TODO 根据用户的标签，播放记录等进行个性化推荐
            return null;
        }
    }
}
