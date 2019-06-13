package star.sky.another.model.entity;

import java.util.Date;

public class Moments {
    private Long id;

    private Long creatorId;

    private String creatorNickName;

    private String creatorImage;

    private Date publishTime;

    private Integer type;

    private Integer thumbNumber;

    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getCreatorImage() {
        return creatorImage;
    }

    public void setCreatorImage(String creatorImage) {
        this.creatorImage = creatorImage == null ? null : creatorImage.trim();
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getThumbNumber() {
        return thumbNumber;
    }

    public void setThumbNumber(Integer thumbNumber) {
        this.thumbNumber = thumbNumber;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}