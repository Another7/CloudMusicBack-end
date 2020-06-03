package star.sky.another.view;

import star.sky.another.model.entity.User;

/**
 * @Description
 * @Author Another
 * @Date 2020/4/8 16:10
 **/
public class UserView extends BaseView {
    private User user;
    private Boolean isFollowed;
    private Boolean isSinger;

    public Boolean getSinger() {
        return isSinger;
    }

    public void setSinger(Boolean singer) {
        isSinger = singer;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Boolean getFollowed() {
        return isFollowed;
    }

    public void setFollowed(Boolean followed) {
        isFollowed = followed;
    }

    @Override
    public String toString() {
        return "UserView{" +
                "user=" + user +
                ", isFollowed=" + isFollowed +
                ", isSinger=" + isSinger +
                '}';
    }
}
