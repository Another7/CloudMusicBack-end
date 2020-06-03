package star.sky.another.view;

import star.sky.another.model.entity.Music;

/**
 * @Description
 * @Author Another
 * @Date 2020/3/31 20:54
 **/
public class MusicView extends BaseView {
    private Music music;
    private String belongAlbumImageUrl;

    public Music getMusic() {
        return music;
    }

    public void setMusic(Music music) {
        this.music = music;
    }

    public String getBelongAlbumImageUrl() {
        return belongAlbumImageUrl;
    }

    public void setBelongAlbumImageUrl(String belongAlbumImageUrl) {
        this.belongAlbumImageUrl = belongAlbumImageUrl;
    }

    @Override
    public String toString() {
        return "MusicView{" +
                "music=" + music +
                ", belongAlbumImageUrl='" + belongAlbumImageUrl + '\'' +
                '}';
    }
}
