package com.huangxy.mcadapter;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import huangxy.com.mcadapter.AdapterItem;
import huangxy.com.mcadapter.CommonAdapter;
import huangxy.com.mcadapter.McAdapter;
import huangxy.com.mcadapter.McEntity;

/**
 * Created by huangxy on 2016/10/29.
 * https://github.com/GitSmark/McAdapter
 */
public class SampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);
        ListView lv = (ListView) findViewById(R.id.sample_listview);

        List<String> data = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            data.add("Test"+i);
        }

        List<McEntity<String>> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(new McEntity(i%2, "Test"+i));
        }

        switch (getIntent().getIntExtra("sampleNum", 0)){
            case 1:
                lv.setAdapter(new McAdapter(data, McAdapterItem1.class));
                break;
            case 2:
                lv.setAdapter(new McAdapter(list, McAdapterItem3.class, McAdapterItem4.class));
                break;
            case 3:
                lv.setAdapter(new CommonAdapter(data) {
                    @NonNull@Override
                    public AdapterItem onCreateItem(Object type) {
                        return new McAdapterItem2();
                    }
                });
                break;
            case 4:
                lv.setAdapter(new CommonAdapter<McEntity<String>>(list, 2) {
                    @Override
                    public Object getItemType(McEntity obj) {
                        return obj.getItemType();
                    }
                    @NonNull@Override
                    public AdapterItem onCreateItem(Object type) {
                        switch (((int) type)) {
                            case 0:
                                return new McAdapterItem3();
                            case 1:
                                return new McAdapterItem4();
                            default:
                                throw new IllegalArgumentException("不合法的type");
                        }
                    }
                });
                break;
            default:
                break;
        }

    }

}