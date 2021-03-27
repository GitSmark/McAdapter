package com.huangxy.mcadapter.adapterItem;

import android.view.View;
import android.widget.TextView;

import com.huangxy.mcadapter.McAdapterItem;
import com.huangxy.mcadapter.R;

/**
 * Created by huangxy on 2016/10/29.
 * https://github.com/GitSmark/McAdapter
 */
public class McAdapterItem3 extends McAdapterItem<String> {

    private TextView tv;

    public McAdapterItem3(){}

    public McAdapterItem3(Object obj){
        registerListener(obj); //注册监听事件，仅使用McAdapter/McRcvAdapter生效
    }

    @Override
    public int getLayoutResId() {
        return R.layout.layout_item1;
    }

    @Override
    public void onBindViews(View root) {
        super.onBindViews(root); //重写该方法别忘记赋值
        tv = root.findViewById(R.id.tv_item1);
    }

    @Override
    public void onUpdateViews(String model) {
        tv.setText(model);
    }

    @Override
    public void onItemAction() {
        //列表项选中事件已默认设置，可在此添加更多监听事件
        //if (mClickListener != null) mClickListener.onClick(view, getBindPosition());
        //if (mItemClickListener != null) {
        //    mItemClickListener.onItemClick(McAdapterItem3.this, rootView, getBindPosition(), getBindModel());
        //}
    }
}