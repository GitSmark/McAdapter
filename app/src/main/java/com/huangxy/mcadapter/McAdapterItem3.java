package com.huangxy.mcadapter;

import android.view.View;
import android.widget.TextView;

import huangxy.com.mcadapter.AdapterItem;
import huangxy.com.mcadapter.McEntity;

/**
 * Created by huangxy on 2016/10/29.
 * https://github.com/GitSmark/McAdapter
 */
public class McAdapterItem3 implements AdapterItem<McEntity<String>> {

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
    public void onUpdateViews(McEntity<String> model, int position) {
        tv.setText(model.getItemEntity());
    }

    @Override
    public void onItemAction(int position) {
        tv.setOnClickListener();
    }
}