package star.sky.another.model;

public class Follow {
    private Long id;

    private Long userId;

    private Long followId;

    private String followNickName;

    private String followImage;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getFollowId() {
        return followId;
    }

    public void setFollowId(Long followId) {
        this.followId = followId;
    }

    public String getFollowNickName() {
        return followNickName;
    }

    public void setFollowNickName(String followNickName) {
        this.followNickName = followNickName == null ? null : followNickName.trim();
    }

    public String getFollowImage() {
        return followImage;
    }

    public void setFollowImage(String followImage) {
        this.followImage = followImage == null ? null : followImage.trim();
    }
}