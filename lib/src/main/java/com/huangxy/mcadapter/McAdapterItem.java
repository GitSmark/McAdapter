package com.huangxy.mcadapter;

import android.view.View;

/**
 * Created by huangxy on 2016/10/28.
 * https://github.com/GitSmark/McAdapter
 * McAdapterItem对应AdapterItem，配合McEntity多布局使用，推荐优先使用
 */
public abstract class McAdapterItem<T> implements IAdapterItem<McEntity<T>> {

    private T model;
    protected IAdapterView.OnClickListener clickListener;
    protected IAdapterView.OnLongClickListener longClickListener;

    public McAdapterItem(){}

    public McAdapterItem(Object obj) {
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
    public void onUpdateViews(McEntity<T> model, int position) {
        if(model != null) this.model = model.getItemEntity();
        onUpdateViews(model.getItemEntity());
    }

    public abstract void onUpdateViews(T model);

    @Override
    public void onItemAction(int position) {

    }

    public T getBindModel(){
        return model;
    }

}
