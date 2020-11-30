package com.huangxy.mcadapter;

import android.view.View;
import android.widget.TextView;

import com.huangxy.lib.AdapterItem;

/**
 * Created by huangxy on 2016/10/29.
 * https://github.com/GitSmark/McAdapter
 */
public class McAdapterItem1 extends AdapterItem<String> {

    private TextView tv;

    public McAdapterItem1(){

    }

    public McAdapterItem1(Object obj){
        super(obj); //初始化监听事件
    }

    @Override
    public int getLayoutResId() {
        return R.layout.layout_item1;
    }

    @Override
    public void onBindViews(View root) {
        tv = (TextView) root.findViewById(R.id.item1);
    }

    @Override
    public void onUpdateViews(String model) {
        tv.setText(model);
    }

    @Override
    public void onItemAction(final int position) {
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //点击事件回调
                if(clickListener != null) clickListener.onClick(view, position);
            }
        });
    }
}