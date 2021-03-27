package com.huangxy.mcadapter;

/**
 * Created by huangxy on 2016/10/28.
 * https://github.com/GitSmark/McAdapter
 * 通用的McAdapter传入的model必须实现的接口
 */
public interface IAdapterModel {

    Object getItemEntity();

    @Deprecated
    int getItemType();

}
