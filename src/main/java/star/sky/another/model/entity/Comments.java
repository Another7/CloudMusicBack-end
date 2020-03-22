package star.sky.another.model.entity;

import java.util.Date;

public class Comments extends BaseEntity {
    private Long id;

    private Integer type;

    private String content;

    private Date createTime;

    private Integer thumbNumber;

    private Long recordId;

    private Long commentatorId;

    private String commentatorNickName;

    private String commentatorImage;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getThumbNumber() {
        return thumbNumber;
    }

    public void setThumbNumber(Integer thumbNumber) {
        this.thumbNumber = thumbNumber;
    }

    public Long getRecordId() {
        return recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
    }

    public Long getCommentatorId() {
        return commentatorId;
    }

    public void setCommentatorId(Long commentatorId) {
        this.commentatorId = commentatorId;
    }

    public String getCommentatorNickName() {
        return commentatorNickName;
    }

    public void setCommentatorNickName(String commentatorNickName) {
        this.commentatorNickName = commentatorNickName == null ? null : commentatorNickName.trim();
    }

    public String getCommentatorImage() {
        return commentatorImage;
    }

    public void setCommentatorImage(String commentatorImage) {
        this.commentatorImage = commentatorImage == null ? null : commentatorImage.trim();
    }

    @Override
    public String toString() {
        return "Comments{" +
                "id=" + id +
                ", type=" + type +
                ", content='" + content + '\'' +
                ", createTime=" + createTime +
                ", thumbNumber=" + thumbNumber +
                ", recordId=" + recordId +
                ", commentatorId=" + commentatorId +
                ", commentatorNickName='" + commentatorNickName + '\'' +
                ", commentatorImage='" + commentatorImage + '\'' +
                '}';
    }
}