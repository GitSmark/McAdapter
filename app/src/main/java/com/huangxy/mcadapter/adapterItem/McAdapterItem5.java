package com.huangxy.mcadapter.adapterItem;

import android.widget.TextView;

import com.huangxy.mcadapter.McAdapterItem;
import com.huangxy.mcadapter.R;
import com.huangxy.mcadapter.adapterModel.TestEntity5;

import butterknife.BindView;

/**
 * Created by huangxy on 2016/10/29.
 * https://github.com/GitSmark/McAdapter
 */
public class McAdapterItem5 extends McAdapterItem<TestEntity5> {

    @BindView(R.id.tv_item1)
    TextView tv;

    @Override
    public int getLayoutResId() {
        return R.layout.layout_item1;
    }

    @Override
    public void onUpdateViews(TestEntity5 model) {
        tv.setText(model.title);
    }

}