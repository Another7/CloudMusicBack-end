package star.sky.another.model;

import java.util.Date;

public class Music {
    private Long id;

    private String url;

    private String name;

    private Long belongAlbumId;

    private String belongAlbumName;

    private Long singerId;

    private String singerName;

    private Date duration;

    private Date releaseTime;

    private Integer yesterdayPlayCount;

    private Integer todayPlayCount;

    private Integer totalPlayCount;

    private String lyric;

    private String tag;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Long getBelongAlbumId() {
        return belongAlbumId;
    }

    public void setBelongAlbumId(Long belongAlbumId) {
        this.belongAlbumId = belongAlbumId;
    }

    public String getBelongAlbumName() {
        return belongAlbumName;
    }

    public void setBelongAlbumName(String belongAlbumName) {
        this.belongAlbumName = belongAlbumName == null ? null : belongAlbumName.trim();
    }

    public Long getSingerId() {
        return singerId;
    }

    public void setSingerId(Long singerId) {
        this.singerId = singerId;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName == null ? null : singerName.trim();
    }

    public Date getDuration() {
        return duration;
    }

    public void setDuration(Date duration) {
        this.duration = duration;
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    public Integer getYesterdayPlayCount() {
        return yesterdayPlayCount;
    }

    public void setYesterdayPlayCount(Integer yesterdayPlayCount) {
        this.yesterdayPlayCount = yesterdayPlayCount;
    }

    public Integer getTodayPlayCount() {
        return todayPlayCount;
    }

    public void setTodayPlayCount(Integer todayPlayCount) {
        this.todayPlayCount = todayPlayCount;
    }

    public Integer getTotalPlayCount() {
        return totalPlayCount;
    }

    public void setTotalPlayCount(Integer totalPlayCount) {
        this.totalPlayCount = totalPlayCount;
    }

    public String getLyric() {
        return lyric;
    }

    public void setLyric(String lyric) {
        this.lyric = lyric == null ? null : lyric.trim();
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag == null ? null : tag.trim();
    }
}