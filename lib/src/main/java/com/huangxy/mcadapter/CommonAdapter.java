package com.huangxy.mcadapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import androidx.annotation.NonNull;

import java.util.List;

import butterknife.ButterKnife;

/**
 * @author Jack Tony
 * @date 2015/5/15
 */
public abstract class CommonAdapter<T> extends BaseAdapter implements IAdapter<T> {

    private final boolean DEBUG = false;

    private List<T> mDataList;

    private int mViewTypeCount;

    private Object mType;

    private LayoutInflater mInflater;

    private AdapterItemUtil util;

    protected CommonAdapter(@NonNull List<T> data) {
        this(data, 1);
    }

    protected CommonAdapter(@NonNull List<T> data, int viewTypeCount) {
        mDataList = data;
        mViewTypeCount = viewTypeCount;
        util = new AdapterItemUtil();
    }

    @Override
    public int getCount() {
        return mDataList.size();
    }

    @Override
    public T getItem(int position) {
        return mDataList.get(position);
    }

    @Override
    public void setData(@NonNull List<T> data) {
        mDataList = data;
        notifyDataSetChanged();
    }

    @Override
    public List<T> getData() {
        return mDataList;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * instead by{@link #getItemType(Object)}
     */
    @Override
    @Deprecated
    public int getItemViewType(int position) {
        mType = getItemType(mDataList.get(position));
        // 如果不写这个方法，会让listView更换dataList后无法刷新数据
        return util.getIntType(mType);
    }

    /**
     * 强烈建议返回string,int,bool类似的基础对象做type
     */
    @Override
    public Object getItemType(T t) {
        return -1; // default
    }

    @Override
    public int getViewTypeCount() {
        return mViewTypeCount;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (mInflater == null) {
            mInflater = LayoutInflater.from(parent.getContext());
        }

        IAdapterItem<T> item;
        if (convertView == null) {
            item = onCreateItem(mType);
            convertView = mInflater.inflate(item.getLayoutResId(), parent, false);
            convertView.setTag(item);
            ButterKnife.bind(item, convertView);// 绑定ButterKnife
            item.onBindViews(convertView);
            item.onSetViews();
            if (DEBUG) convertView.setBackgroundColor(0xffff0000);
        } else {
            item = (IAdapterItem<T>) convertView.getTag();
            if (DEBUG) convertView.setBackgroundColor(0xff00ff00);
        }
        item.onUpdateViews(mDataList.get(position), position);
        return convertView;
    }

}
