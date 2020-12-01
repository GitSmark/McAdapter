package com.huangxy.mcadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import butterknife.ButterKnife;

/**
 * @author Jack Tony
 * @date 2015/5/17
 */
public abstract class CommonRcvAdapter<T> extends RecyclerView.Adapter implements IAdapter<T>{

    private final boolean DEBUG = false;

    private List<T> mDataList;

    private Object mItemType;

    private AdapterItemUtil mUtil = new AdapterItemUtil();

    protected CommonRcvAdapter(List<T> data) {
        mDataList = data;
    }

    @Override
    public int getItemCount() {
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
    @Deprecated
    @Override
    public int getItemViewType(int position) {
        mItemType = getItemType(mDataList.get(position));
        return mUtil.getIntType(mItemType);
    }

    @Override
    public Object getItemType(T t) {
        return -1; // default
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RcvAdapterItem(parent.getContext(), parent, onCreateItem(mItemType));
    }

    @SuppressWarnings("unchecked")
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (DEBUG) {
            RcvAdapterItem item = (RcvAdapterItem) holder;
            item.itemView.setBackgroundColor(item.isNew ? 0xffff0000 : 0xff00ff00);
            item.isNew = false;
        }
        //((RcvAdapterItem) holder).getItem().onUpdateViews(mDataList.get(position), position);
        IAdapterItem<T> mItem = ((RcvAdapterItem) holder).getItem();
        mItem.onUpdateViews(mDataList.get(position), position);
        mItem.onItemAction(position);
    }


    ///////////////////////////////////////////////////////////////////////////
    // 内部用到的viewhold
    ///////////////////////////////////////////////////////////////////////////

    private class RcvAdapterItem extends RecyclerView.ViewHolder {

        private IAdapterItem<T> mItem;

        public boolean isNew = true; // debug中才用到

        protected RcvAdapterItem(Context context, ViewGroup parent, IAdapterItem<T> item) {
            super(LayoutInflater.from(context).inflate(item.getLayoutResId(), parent, false));
            mItem = item;
            ButterKnife.bind(item, itemView);// 绑定ButterKnife
            mItem.onBindViews(itemView);
            //mItem.onSetViews();
        }

        protected IAdapterItem<T> getItem() {
            return mItem;
        }

    }

}
