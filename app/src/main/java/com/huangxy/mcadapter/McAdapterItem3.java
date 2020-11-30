package com.huangxy.mcadapter;

import android.view.View;
import android.widget.TextView;

import com.huangxy.lib.McAdapterItem;

/**
 * Created by huangxy on 2016/10/29.
 * https://github.com/GitSmark/McAdapter
 */
public class McAdapterItem3 extends McAdapterItem<String> {

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
    public void onUpdateViews(String model) {
        tv.setText(model);
    }
}