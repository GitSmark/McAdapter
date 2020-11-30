package com.huangxy.lib;

import android.view.View;

import androidx.annotation.LayoutRes;

/**
 * adapter的所有item必须实现此接口.
 * 通过返回{@link #getLayoutResId()}来自动初始化view，之后在{@link #onBindViews(View)}中就可以初始化item的内部视图了。<br>
 *
 * @author Jack Tony
 * @date 2015/5/15
 */
public interface IAdapterItem<T> {

    /**
     * @return item布局文件的layoutId
     */
    @LayoutRes
    int getLayoutResId();

    /**
     * 初始化views
     */
    void onBindViews(final View root);

    /**
     * 设置view的参数
     */
    //onItemAction(position)来替代onSetViews()
    //void onSetViews();

    /**
     * 根据数据来设置item的内部views
     * @param model    数据list内部的model
     */
    void onUpdateViews(T model, int position);

    /**
     * 根据数据来设置item的监听回调
     * @param position 当前adapter调用item的位置
     */
    void onItemAction(int position);

}