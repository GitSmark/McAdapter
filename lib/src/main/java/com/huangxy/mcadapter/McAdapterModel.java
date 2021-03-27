package com.huangxy.mcadapter;

/**
 * Created by huangxy on 2016/10/28.
 * https://github.com/GitSmark/McAdapter
 * 实现IAdapterModel接口可自定义adapterModel，推荐优先使用McAdapterModel
 */
public abstract class McAdapterModel implements IAdapterModel {

    public abstract Class<? extends IAdapterItem> getAdapterItem();

    @Override
    public Object getItemEntity() {
        return this;
    }

    @Override
    public int getItemType() {
        return 0;
    }
}
