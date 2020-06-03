package star.sky.another.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class User extends BaseEntity {
    private Long id;

    private String nickName;

    private String email;

    private String password;

    private String image;

    private Integer gender;

    private String tel;

    private String address;

    private String description;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date registerTime;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    private Integer momentNumber;

    private Integer followNumber;

    private Integer followerNumber;

    private String notification;

    private String tag;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getMomentNumber() {
        return momentNumber;
    }

    public void setMomentNumber(Integer momentNumber) {
        this.momentNumber = momentNumber;
    }

    public Integer getFollowNumber() {
        return followNumber;
    }

    public void setFollowNumber(Integer followNumber) {
        this.followNumber = followNumber;
    }

    public Integer getFollowerNumber() {
        return followerNumber;
    }

    public void setFollowerNumber(Integer followerNumber) {
        this.followerNumber = followerNumber;
    }

    public String getNotification() {
        return notification;
    }

    public void setNotification(String notification) {
        this.notification = notification == null ? null : notification.trim();
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag == null ? null : tag.trim();
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nickName='" + nickName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", image='" + image + '\'' +
                ", gender=" + gender +
                ", tel='" + tel + '\'' +
                ", address='" + address + '\'' +
                ", description='" + description + '\'' +
                ", registerTime=" + registerTime +
                ", birthday=" + birthday +
                ", momentNumber=" + momentNumber +
                ", followNumber=" + followNumber +
                ", followerNumber=" + followerNumber +
                ", notification='" + notification + '\'' +
                ", tag='" + tag + '\'' +
                '}';
    }
}