package com.huangxy.mcadapter;

import android.view.View;
import android.widget.TextView;

/**
 * Created by huangxy on 2016/10/29.
 * https://github.com/GitSmark/McAdapter
 */
public class McAdapterItem4 extends McAdapterItem<String> {

    private TextView tv;
    private IAdapterView.OnLongClickListener mListener;

    public McAdapterItem4(){}

    public McAdapterItem4(Object obj){
        //super(obj);

        //注册你自己的监听事件
        try {
            mListener = (IAdapterView.OnLongClickListener) obj;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getLayoutResId() {
        return R.layout.layout_item2;
    }

    @Override
    public void onBindViews(View root) {
        super.onBindViews(root); //建议直接使用butterknife.BindView
        tv = root.findViewById(R.id.item2);
    }

    @Override
    public void onUpdateViews(String model) {
        tv.setText(model);
    }

    @Override
    public void onItemAction() {
        //if (mListener != null) mListener.onLongClick(view, getBindPosition());
    }
}