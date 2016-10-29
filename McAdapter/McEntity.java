package huangxy.com.mcadapter;

/**
 * Created by huangxy on 2016/10/28.
 * https://github.com/GitSmark/McAdapter
 * 使用McAdapter和McRcvAdapter多布局时用
 */
public class McEntity<T> {

    private int itemType;
    private T itemEntity;

    public McEntity(){}

    public McEntity(int itemType, T itemEntity){
        setItemEntity(itemEntity);
        setItemType(itemType);
    }

    public int getItemType() {
        return itemType;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }

    public T getItemEntity() {
        return itemEntity;
    }

    public void setItemEntity(T itemEntity) {
        this.itemEntity = itemEntity;
    }
}
