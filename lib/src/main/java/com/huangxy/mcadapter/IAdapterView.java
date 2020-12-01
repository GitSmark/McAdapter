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

    public interface OnItemClickListener<T> {
        void onClick(View view, T item);
    }

    public interface OnLongClickListener {
        boolean onLongClick(View view, int position);
    }

    public interface OnItemLongClickListener<T> {
        boolean onLongClick(View view, T item);
    }

//    public interface OnItemClickListener {
//        void onItemClick(AdapterView<?> parent, View view, int position, long id);
//    }
//
//    public interface OnItemLongClickListener {
//        void onItemLongClick(AdapterView<?> parent, View view, int position, long id);
//    }

}
