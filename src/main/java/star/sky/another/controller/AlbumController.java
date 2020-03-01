package star.sky.another.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import star.sky.another.model.entity.Album;
import star.sky.another.service.AlbumServiceInterface;

/**
 * @Description
 * @Author Another
 * @Date 2020/3/1 9:47
 **/
@RestController
@RequestMapping(value = "/albums")
public class AlbumController {
    private final AlbumServiceInterface albumServiceInterface;

    public AlbumController(AlbumServiceInterface albumServiceInterface) {
        this.albumServiceInterface = albumServiceInterface;
    }

    @PostMapping
    public Album publishWords(@RequestBody Album album) {
        Album albumResult = new Album();
        album.setSingerId(123L);
        album.setSingerName("邓紫棋");
        //language=JSON5
        String collectionMusic = "[\n" +
                "  {\n" +
                "    \"id\": 1,\n" +
                "    \"fileName\": \"江南\",\n" +
                "    \"singer\": \"林俊杰\",\n" +
                "    \"url\": \"D:/data/audio/江南.mp3\"\n" +
                "  }\n" +
                "]";
        album.setCollectionMusic(collectionMusic);
        return albumServiceInterface.publishAlbum(album);
    }
}
