package com.huangxy.mcadapter;

import android.view.View;

/**
 * Created by huangxy on 2016/10/28.
 * https://github.com/GitSmark/McAdapter
 * 实现IAdapterItem接口可自定义ViewHolder，推荐优先使用McAdapterItem
 */
public abstract class AdapterItem<T> implements IAdapterItem<T> {

    private T model = null;
    private int position = -1;
    protected View rootView = null;
    protected IAdapterView.OnClickListener mClickListener;
    protected IAdapterView.OnItemClickListener mItemClickListener;

    public AdapterItem(){}

    public AdapterItem(Object obj) {
        registerListener(obj);
    }

    protected void registerListener(Object obj){
        try {
            mClickListener = (IAdapterView.OnClickListener) obj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            mItemClickListener = (IAdapterView.OnItemClickListener) obj;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onBindViews(View root) {
        rootView = root;
    }

    @Override
    public void onUpdateViews(T model, int position) {
        this.model = model;
        this.position = position;
        onUpdateViews(model);
    }

    public abstract void onUpdateViews(T model);

    @Override
    public void onSetViews() {
        if (rootView != null && mItemClickListener != null) {
            rootView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mItemClickListener != null) {
                        mItemClickListener.onItemClick(AdapterItem.this, rootView, getBindPosition(), getBindModel());
                    }
                }
            });
        }
        onItemAction();
    }

    public void onItemAction(){}

    public T getBindModel(){
        return model;
    }

    public int getBindPosition(){
        return position;
    }

}
