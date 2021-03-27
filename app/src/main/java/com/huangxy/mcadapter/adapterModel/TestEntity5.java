package com.huangxy.mcadapter.adapterModel;

import com.huangxy.mcadapter.IAdapterItem;
import com.huangxy.mcadapter.McAdapterModel;
import com.huangxy.mcadapter.adapterItem.McAdapterItem5;
import com.huangxy.mcadapter.adapterItem.McAdapterItem6;

public class TestEntity5 extends McAdapterModel {

    public int id;
    public String title;

    public TestEntity5() {

    }

    public TestEntity5(String title) {
        this.title = title;
    }

    @Override
    public Class<? extends IAdapterItem> getAdapterItem() {
//        if (id > 0) {
//            return McAdapterItem6.class;
//        }
        return McAdapterItem5.class;
    }
}
