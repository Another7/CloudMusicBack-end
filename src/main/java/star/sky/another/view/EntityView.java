package star.sky.another.view;

/**
 * @Description
 * @Author Another
 * @Date 2020/2/18 17:36
 **/
public class EntityView<T> extends BaseView {
    private String code;
    private T entity;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getEntity() {
        return entity;
    }

    public void setEntity(T entity) {
        this.entity = entity;
    }
}
