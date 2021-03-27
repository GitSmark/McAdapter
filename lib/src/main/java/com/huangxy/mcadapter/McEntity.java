package com.huangxy.mcadapter;

/**
 * Created by huangxy on 2016/10/28.
 * https://github.com/GitSmark/McAdapter
 * 配合McAdapter和McRcvAdapter多布局时使用
 */
public class McEntity<T> extends McAdapterModel {

    private Class<? extends IAdapterItem> adapterItem;
    private int itemType = 0;
    private T itemEntity;

    public McEntity(){}

    @Deprecated
    public McEntity(T itemEntity, int itemType){
        this.itemEntity = itemEntity;
        this.itemType = itemType;
    }

    public McEntity(T itemEntity, Class<? extends IAdapterItem> adapterItem){
        this.adapterItem = adapterItem;
        this.itemEntity = itemEntity;
    }

    @Override
    public Class<? extends IAdapterItem> getAdapterItem() {
        return adapterItem;
    }

    public void setAdapterItem(Class<? extends IAdapterItem> adapterItem) {
        this.adapterItem = adapterItem;
    }

    @Override
    public T getItemEntity() {
        return itemEntity;
    }

    public void setItemEntity(T itemEntity) {
        this.itemEntity = itemEntity;
    }

    @Deprecated
    public int getItemType() {
        return itemType;
    }

    @Deprecated
    public void setItemType(int itemType) {
        this.itemType = itemType;
    }
}
