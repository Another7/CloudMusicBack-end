package star.sky.another.model.entity;

public class UserCollectionSheet extends BaseEntity {
    private Long id;

    private Long userId;

    private Long sheetId;

    private String sheetTitle;

    private String sheetImage;

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

    public Long getSheetId() {
        return sheetId;
    }

    public void setSheetId(Long sheetId) {
        this.sheetId = sheetId;
    }

    public String getSheetTitle() {
        return sheetTitle;
    }

    public void setSheetTitle(String sheetTitle) {
        this.sheetTitle = sheetTitle == null ? null : sheetTitle.trim();
    }

    public String getSheetImage() {
        return sheetImage;
    }

    public void setSheetImage(String sheetImage) {
        this.sheetImage = sheetImage == null ? null : sheetImage.trim();
    }
}