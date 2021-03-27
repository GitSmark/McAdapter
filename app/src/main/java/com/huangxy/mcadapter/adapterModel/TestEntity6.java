package com.huangxy.mcadapter.adapterModel;

import com.huangxy.mcadapter.IAdapterItem;
import com.huangxy.mcadapter.McAdapterModel;
import com.huangxy.mcadapter.adapterItem.McAdapterItem5;
import com.huangxy.mcadapter.adapterItem.McAdapterItem6;

public class TestEntity6 extends McAdapterModel {

    public int id;
    public String title;

    public TestEntity6() {

    }

    public TestEntity6(String title) {
        this.title = title;
    }

    @Override
    public Class<? extends IAdapterItem> getAdapterItem() {
//        if (id > 0) {
//            return McAdapterItem5.class;
//        }
        return McAdapterItem6.class;
    }
}
