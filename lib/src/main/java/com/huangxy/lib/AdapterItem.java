package com.huangxy.lib;

import android.view.View;

/**
 * Created by huangxy on 2016/10/28.
 * https://github.com/GitSmark/McAdapter
 * 实现IAdapterItem接口可自定义ViewHolder，推荐优先使用McAdapterItem
 */
public abstract class AdapterItem<T> implements IAdapterItem<T> {

    private T model;
    protected IAdapterView.OnClickListener clickListener;
    protected IAdapterView.OnLongClickListener longClickListener;

    public AdapterItem(){}

    public AdapterItem(Object obj) {
        obtainListener(obj);
    }

    private void obtainListener(Object obj){
        try {
            clickListener = (IAdapterView.OnClickListener) obj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            longClickListener = (IAdapterView.OnLongClickListener) obj;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onBindViews(View root) {}

    @Override
    public void onUpdateViews(T model, int position) {
        this.model = model;
        onUpdateViews(model);
    }

    public abstract void onUpdateViews(T model);

    @Override
    public void onItemAction(int position) {

    }

    public T getBindModel(){
        return model;
    }

}
