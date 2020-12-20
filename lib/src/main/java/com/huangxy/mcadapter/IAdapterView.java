package com.huangxy.mcadapter;

import android.view.View;

/**
 * Created by huangxy on 2016/10/28.
 * https://github.com/GitSmark/McAdapter
 */
public class IAdapterView {

    public interface OnClickListener {
        void onClick(View view, int position);
    }

    public interface OnLongClickListener {
        boolean onLongClick(View view, int position);
    }

    public interface OnItemClickListener<T> {
        void onItemClick(IAdapterItem<?> parent, View view, int position, T item);
    }

    public interface OnItemLongClickListener<T> {
        boolean onItemLongClick(IAdapterItem<?> parent, View view, int position, T item);
    }
}
