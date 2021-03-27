package com.huangxy.mcadapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.huangxy.mcadapter.adapterItem.McAdapterItem3;
import com.huangxy.mcadapter.adapterItem.McAdapterItem4;
import com.huangxy.mcadapter.adapterItem.McAdapterItem5;
import com.huangxy.mcadapter.adapterItem.McAdapterItem6;
import com.huangxy.mcadapter.adapterModel.TestEntity5;
import com.huangxy.mcadapter.adapterModel.TestEntity6;

import java.util.ArrayList;
import java.util.List;

public class MultiActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<McEntity> list = new ArrayList<>();
    private List<McAdapterModel> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi);

        data.add(new McEntity("111111", McAdapterItem3.class)); //使用通用的McEntity，并指定getAdapterItem类型
        data.add(new McEntity("123123", McAdapterItem4.class));
        data.add(new TestEntity5("123456")); //自定义adapterModel建议继承自McAdapterModel，并指定getAdapterItem类型
        data.add(new TestEntity6("666666"));

        list.add(new McEntity("111111", 0)); //不建议直接实现IAdapterModel接口指定getItemType类型，不利于复用
        list.add(new McEntity("123123", 1));
        list.add(new McEntity(new TestEntity5("123456"), 2));
        list.add(new McEntity(new TestEntity6("666666"), 3));

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //recyclerView.setAdapter(new McRcvAdapter(list, McAdapterItem3.class, McAdapterItem4.class, McAdapterItem5.class, McAdapterItem6.class));
        recyclerView.setAdapter(new McRcvAdapter(data));
    }
}