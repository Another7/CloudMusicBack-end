package star.sky.another.model.entity;

import java.util.Date;

public class PersonalMessage {
    private Long id;

    private Long senderId;

    private String senderNickName;

    private String senderImage;

    private Long receiverId;

    private String receiverNickName;

    private String receiverImage;

    private Date sendingTime;

    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public String getSenderNickName() {
        return senderNickName;
    }

    public void setSenderNickName(String senderNickName) {
        this.senderNickName = senderNickName == null ? null : senderNickName.trim();
    }

    public String getSenderImage() {
        return senderImage;
    }

    public void setSenderImage(String senderImage) {
        this.senderImage = senderImage == null ? null : senderImage.trim();
    }

    public Long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Long receiverId) {
        this.receiverId = receiverId;
    }

    public String getReceiverNickName() {
        return receiverNickName;
    }

    public void setReceiverNickName(String receiverNickName) {
        this.receiverNickName = receiverNickName == null ? null : receiverNickName.trim();
    }

    public String getReceiverImage() {
        return receiverImage;
    }

    public void setReceiverImage(String receiverImage) {
        this.receiverImage = receiverImage == null ? null : receiverImage.trim();
    }

    public Date getSendingTime() {
        return sendingTime;
    }

    public void setSendingTime(Date sendingTime) {
        this.sendingTime = sendingTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}