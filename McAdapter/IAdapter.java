package com.administrator.ticat.Common.CommonAdapter;

import android.support.annotation.NonNull;

import java.util.List;


/**
 * @author Jack Tony
 * @date 2015/11/29
 * 通用的adapter必须实现的接口
 */
interface IAdapter<T> {

    void setData(@NonNull List<T> data);

    List<T> getData();

    Object getItemType(T t);

    T getItem(int position);

    /**
     * 当缓存中无法得到所需item时才会调用
     */
    @NonNull
    AdapterItem<T> onCreateItem(Object type);
}
