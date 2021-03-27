package com.huangxy.mcadapter.adapterItem;

import android.widget.TextView;

import com.huangxy.mcadapter.McAdapterItem;
import com.huangxy.mcadapter.R;
import com.huangxy.mcadapter.adapterModel.TestEntity6;

import butterknife.BindView;

/**
 * Created by huangxy on 2016/10/29.
 * https://github.com/GitSmark/McAdapter
 */
public class McAdapterItem6 extends McAdapterItem<TestEntity6> {

    @BindView(R.id.tv_item2)
    TextView tv;

    @Override
    public int getLayoutResId() {
        return R.layout.layout_item2;
    }

    @Override
    public void onUpdateViews(TestEntity6 model) {
        tv.setText(model.title);
    }

}