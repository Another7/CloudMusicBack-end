package star.sky.another.view;

import star.sky.another.model.entity.Music;
import star.sky.another.model.entity.MusicSheet;

import java.util.List;

/**
 * @Description
 * @Author Another
 * @Date 2020/4/18 20:17
 **/
public class MusicSheetView extends BaseView {
    private MusicSheet musicSheet;
    private List<Music> musicList;
    private String creatorImage;

    public MusicSheet getMusicSheet() {
        return musicSheet;
    }

    public void setMusicSheet(MusicSheet musicSheet) {
        this.musicSheet = musicSheet;
    }

    public List<Music> getMusicList() {
        return musicList;
    }

    public void setMusicList(List<Music> musicList) {
        this.musicList = musicList;
    }

    public String getCreatorImage() {
        return creatorImage;
    }

    public void setCreatorImage(String creatorImage) {
        this.creatorImage = creatorImage;
    }

    @Override
    public String toString() {
        return "MusicSheetView{" +
                "musicSheet=" + musicSheet +
                ", musicList=" + musicList +
                ", creatorImage='" + creatorImage + '\'' +
                '}';
    }
}
