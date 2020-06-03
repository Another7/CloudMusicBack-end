package star.sky.another.controller;

import org.springframework.web.bind.annotation.*;
import star.sky.another.model.entity.Album;
import star.sky.another.service.AlbumServiceInterface;

import java.util.List;

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

    @GetMapping
    @ResponseBody
    public Album selectAlbumById(Long albumId) {
        return albumServiceInterface.selectAlbumById(albumId);
    }

    @PostMapping
    @ResponseBody
    public Album publishWords(@RequestBody Album album) {
        //language=JSON5
//        String collectionMusic = "[\n" +
//                "  {\n" +
//                "    \"id\": 1,\n" +
//                "    \"fileName\": \"江南\",\n" +
//                "    \"singer\": \"林俊杰\",\n" +
//                "    \"url\": \"D:/data/audio/江南.mp3\"\n" +
//                "  }\n" +
//                "]";
//        album.setCollectionMusic(collectionMusic);
        return albumServiceInterface.publishAlbum(album);
    }

    @GetMapping("/singerId")
    @ResponseBody
    public List<Album> selectAlbumBySingerId(Long singerId) {
        return albumServiceInterface.selectAlbumBySingerId(singerId);
    }
}
