package com.huangxy.mcadapter;

import android.view.View;
import android.widget.TextView;

import huangxy.com.mcadapter.AdapterItem;

/**
 * Created by huangxy on 2016/10/29.
 * https://github.com/GitSmark/McAdapter
 */
public class McAdapterItem1 implements AdapterItem<String> {

    private TextView tv;

    @Override
    public int getLayoutResId() {
        return R.layout.layout_item1;
    }

    @Override
    public void onBindViews(View root) {
        tv = (TextView) root.findViewById(R.id.item1);
    }

    @Override
    public void onUpdateViews(String model, int position) {
        tv.setText(model);
    }

    @Override
    public void onItemAction(int position) {

    }
}