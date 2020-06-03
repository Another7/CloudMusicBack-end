package star.sky.another.model.entity;

import java.util.Date;
import java.util.Objects;

public class Music extends BaseEntity {
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

    private Integer status;

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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag == null ? null : tag.trim();
    }

    @Override
    public String toString() {
        return "Music{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", name='" + name + '\'' +
                ", belongAlbumId=" + belongAlbumId +
                ", belongAlbumName='" + belongAlbumName + '\'' +
                ", singerId=" + singerId +
                ", singerName='" + singerName + '\'' +
                ", duration=" + duration +
                ", releaseTime=" + releaseTime +
                ", yesterdayPlayCount=" + yesterdayPlayCount +
                ", todayPlayCount=" + todayPlayCount +
                ", totalPlayCount=" + totalPlayCount +
                ", lyric='" + lyric + '\'' +
                ", status=" + status +
                ", tag='" + tag + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Music music = (Music) o;
        return id.equals(music.id) &&
                Objects.equals(url, music.url) &&
                Objects.equals(name, music.name) &&
                Objects.equals(belongAlbumId, music.belongAlbumId) &&
                Objects.equals(belongAlbumName, music.belongAlbumName) &&
                Objects.equals(singerId, music.singerId) &&
                Objects.equals(singerName, music.singerName) &&
                Objects.equals(duration, music.duration) &&
                Objects.equals(releaseTime, music.releaseTime) &&
                Objects.equals(yesterdayPlayCount, music.yesterdayPlayCount) &&
                Objects.equals(todayPlayCount, music.todayPlayCount) &&
                Objects.equals(totalPlayCount, music.totalPlayCount) &&
                Objects.equals(lyric, music.lyric) &&
                Objects.equals(status, music.status) &&
                Objects.equals(tag, music.tag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, url, name, belongAlbumId, belongAlbumName, singerId, singerName, duration, releaseTime, yesterdayPlayCount, todayPlayCount, totalPlayCount, lyric, status, tag);
    }
}