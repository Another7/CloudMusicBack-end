package star.sky.another.controller;

import org.springframework.web.bind.annotation.*;
import star.sky.another.model.entity.Album;
import star.sky.another.model.entity.Singer;
import star.sky.another.service.SingerServiceInterface;
import star.sky.another.service.impl.SingerServiceInterfaceImpl;
import star.sky.another.view.EntityView;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description
 * @Author Another
 * @Date 2020/2/12 13:07
 **/
@RestController
@RequestMapping(value = "/singers")
public class SingerController {
    private final SingerServiceInterface singerServiceInterface;

    public SingerController(SingerServiceInterfaceImpl singerServiceInterfaceImpl) {
        this.singerServiceInterface = singerServiceInterfaceImpl;
    }

    @PostMapping
    @ResponseBody
    public EntityView<Singer> register(@RequestBody Singer singer) {
        return singerServiceInterface.register(singer);
    }

    @GetMapping(value = "/login")
    @ResponseBody
    public EntityView<Singer> login(String email, String password) {
        Singer singer = new Singer();
        singer.setEmail(email);
        singer.setPassword(password);
        return singerServiceInterface.login(singer);
    }

    /**
     * 歌手发布专辑
     *
     * @param album
     * @return
     */
    @PostMapping(value = "/albums")
    public Album publishWords(@RequestBody Album album) {
        Album albumResult = new Album();
        System.out.println(album);
        return albumResult;
    }

    @GetMapping
    public Singer selectByEmail(String email) {
        return singerServiceInterface.selectByEmail(email);
    }

    /**
     * 查询所有为通过审核的歌手
     *
     * @return
     */
    @GetMapping(value = "/all")
    public List<Singer> selectAll() {
        List<Singer> singerList = singerServiceInterface.selectAll();
        // 过滤已经通过审核的歌手
        return singerList.stream().filter(singer -> !singer.getAuthentication()).collect(Collectors.toList());
    }

    @PutMapping
    public Boolean updateSinger(@RequestBody Singer singer) {
        return singerServiceInterface.updateSinger(singer);
    }

    @DeleteMapping
    public Boolean deleteSinger(Long id) {
        return singerServiceInterface.deleteSinger(id);
    }
}
