package star.sky.another.controller;

import org.springframework.web.bind.annotation.*;
import star.sky.another.model.entity.MusicSheet;
import star.sky.another.service.MusicSheetServiceInterface;
import star.sky.another.view.MusicSheetView;

import java.util.List;

/**
 * @Description 歌单控制层
 * @Author Another
 * @Date 2020/4/18 9:47
 **/
@RestController
@RequestMapping(value = "/sheets")
public class MusicSheetController {
    private final MusicSheetServiceInterface musicSheetServiceInterface;

    public MusicSheetController(MusicSheetServiceInterface musicSheetServiceInterface) {
        this.musicSheetServiceInterface = musicSheetServiceInterface;
    }

    @GetMapping
    @ResponseBody
    public MusicSheetView selectSheetViewBySheetId(Long sheetId) {
        return musicSheetServiceInterface.selectSheetViewBySheetId(sheetId);
    }

    @GetMapping(value = "/creatorId")
    @ResponseBody
    public List<MusicSheet> selectMusicSheetByCreatorId(Long creatorId) {
        return musicSheetServiceInterface.selectByCreatorId(creatorId);
    }

    @GetMapping(value = "/recommend")
    @ResponseBody
    public List<MusicSheet> recommendMusicSheet(Long userId) {
        return musicSheetServiceInterface.selectMusicSheetRecommend(userId);
    }

    @PostMapping
    @ResponseBody
    public int createMusicSheet(@RequestBody MusicSheet musicSheet) {
        return musicSheetServiceInterface.insertMusicSheet(musicSheet);
    }

    @GetMapping(value = "/add")
    @ResponseBody
    public int addMusicToSheet(@RequestParam(value = "sheetId") Long sheetId,
                               @RequestParam(value = "musicId") Long musicId) {
        return musicSheetServiceInterface.addMusicToSheet(sheetId, musicId);
    }

    @PutMapping
    public int updateMusicSheet(@RequestBody MusicSheet musicSheet) {
        return musicSheetServiceInterface.updateMusicSheet(musicSheet);
    }

    @DeleteMapping
    public int deleteMusicSheet(Long sheetId) {
        return musicSheetServiceInterface.deleteMusicSheet(sheetId);
    }
}
