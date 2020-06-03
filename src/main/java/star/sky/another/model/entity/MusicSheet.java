package star.sky.another.model.entity;

import java.util.Date;
import java.util.Objects;

public class MusicSheet extends BaseEntity {
    private Long id;

    private String title;

    private String description;

    private String image;

    private Long creatorId;

    private String creatorNickName;

    private Date createTime;

    private Long collectionNumber;

    private Long totalPlayCount;

    private Long shareCount;

    private String collectionMusic;

    private String tag;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public Long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    public String getCreatorNickName() {
        return creatorNickName;
    }

    public void setCreatorNickName(String creatorNickName) {
        this.creatorNickName = creatorNickName == null ? null : creatorNickName.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getCollectionNumber() {
        return collectionNumber;
    }

    public void setCollectionNumber(Long collectionNumber) {
        this.collectionNumber = collectionNumber;
    }

    public Long getTotalPlayCount() {
        return totalPlayCount;
    }

    public void setTotalPlayCount(Long totalPlayCount) {
        this.totalPlayCount = totalPlayCount;
    }

    public Long getShareCount() {
        return shareCount;
    }

    public void setShareCount(Long shareCount) {
        this.shareCount = shareCount;
    }

    public String getCollectionMusic() {
        return collectionMusic;
    }

    public void setCollectionMusic(String collectionMusic) {
        this.collectionMusic = collectionMusic == null ? null : collectionMusic.trim();
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag == null ? null : tag.trim();
    }

    @Override
    public String toString() {
        return "MusicSheet{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", creatorId=" + creatorId +
                ", creatorNickName='" + creatorNickName + '\'' +
                ", createTime=" + createTime +
                ", collectionNumber=" + collectionNumber +
                ", totalPlayCount=" + totalPlayCount +
                ", shareCount=" + shareCount +
                ", collectionMusic='" + collectionMusic + '\'' +
                ", tag='" + tag + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MusicSheet that = (MusicSheet) o;
        return id.equals(that.id) &&
                Objects.equals(title, that.title) &&
                Objects.equals(description, that.description) &&
                Objects.equals(image, that.image) &&
                Objects.equals(creatorId, that.creatorId) &&
                Objects.equals(creatorNickName, that.creatorNickName) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(collectionNumber, that.collectionNumber) &&
                Objects.equals(totalPlayCount, that.totalPlayCount) &&
                Objects.equals(shareCount, that.shareCount) &&
                Objects.equals(collectionMusic, that.collectionMusic) &&
                Objects.equals(tag, that.tag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, image, creatorId, creatorNickName, createTime, collectionNumber, totalPlayCount, shareCount, collectionMusic, tag);
    }
}