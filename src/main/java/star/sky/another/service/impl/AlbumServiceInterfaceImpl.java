package star.sky.another.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import star.sky.another.dao.AlbumMapper;
import star.sky.another.dao.MusicMapper;
import star.sky.another.model.entity.Album;
import star.sky.another.model.entity.Music;
import star.sky.another.service.AlbumServiceInterface;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author Another
 * @Date 2020/3/1 10:20
 **/
@Service
public class AlbumServiceInterfaceImpl implements AlbumServiceInterface {
    private final AlbumMapper albumMapper;
    private final MusicMapper musicMapper;

    public AlbumServiceInterfaceImpl(AlbumMapper albumMapper, MusicMapper musicMapper) {
        this.albumMapper = albumMapper;
        this.musicMapper = musicMapper;
    }

    @Override
    public Album publishAlbum(Album album) {
        albumMapper.insert(album);
        String singerName = album.getSingerName();
        Long singerId = album.getSingerId();
        Long albumId = album.getId();
        String albumName = album.getTitle();
        String musicJson = album.getCollectionMusic();
        ObjectMapper objectMapper = new ObjectMapper();
        // 读取音乐列表
        JsonNode jsonNode = null;
        try {
            jsonNode = objectMapper.readTree(musicJson);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (jsonNode != null && jsonNode.isArray()) {
            List<Music> musicList = new ArrayList<>();
            jsonNode.forEach(node -> {
                Music music = new Music();
                music.setName(node.get("fileName").asText(""));
                music.setUrl(node.get("url").asText(""));
                music.setStatus(0);
                music.setBelongAlbumId(albumId);
                music.setBelongAlbumName(albumName);
                music.setSingerId(singerId);
                music.setSingerName(singerName);
                musicList.add(music);
            });
            musicMapper.insertList(musicList);
            musicList.forEach(music -> {
                System.out.println(music.getId());
            });
        }
        //TODO 封装歌曲id到专辑中
        return album;
    }
}
