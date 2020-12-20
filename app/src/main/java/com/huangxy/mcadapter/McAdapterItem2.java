package com.huangxy.mcadapter;

import android.widget.TextView;

import butterknife.BindView;

/**
 * Created by huangxy on 2016/10/29.
 * https://github.com/GitSmark/McAdapter
 */
public class McAdapterItem2 extends AdapterItem<String> {

    @BindView(R.id.item2)
    TextView tv;

    @Override
    public int getLayoutResId() {
        return R.layout.layout_item2;
    }

    @Override
    public void onUpdateViews(String model) {
        tv.setText(model);
    }

}