package com.huangxy.mcadapter;

import android.view.View;
import android.widget.TextView;

import butterknife.BindView;

/**
 * Created by huangxy on 2016/10/29.
 * https://github.com/GitSmark/McAdapter
 */
public class McAdapterItem1 extends AdapterItem<String> {

    @BindView(R.id.item1)
    TextView tv;

    public McAdapterItem1(){}

    public McAdapterItem1(Object obj){
        super(obj); //初始化监听事件
    }

    @Override
    public int getLayoutResId() {
        return R.layout.layout_item1;
    }

    @Override
    public void onUpdateViews(String model) {
        tv.setText(model);
    }

    @Override
    public void onItemAction() {
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //点击事件回调
                if(mClickListener != null) mClickListener.onClick(view, getBindPosition());
            }
        });
    }
}