package com.huangxy.mcadapter;

import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huangxy on 2016/10/29.
 * https://github.com/GitSmark/McAdapter
 */
public class SampleActivity extends AppCompatActivity { //implements IAdapterView.OnClickListener

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);
        ListView lv = findViewById(R.id.sample_listview);

        List<String> data = new ArrayList<>();
        for (int i = 1; i < 16; i++) {
            data.add("Test"+i);
        }

        List<McEntity> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            //支持泛型，itemEntity支持多布局对应多model
            list.add(new McEntity(i%2, "Test"+i));
        }

        //List<McEntity> list = McAdapterUtil.toMcEntity(data);
        //List<McEntity> list = McAdapterUtil.toMcEntity(data, 1);

        switch (getIntent().getIntExtra("sampleNum", 0)){
            case 1:
                lv.setAdapter(new McAdapter(data, McAdapterItem1.class));
                //lv.setAdapter(new McAdapter(this, data, McAdapterItem1.class)); //添加监听
                break;
            case 2:
                lv.setAdapter(new McAdapter(list, McAdapterItem3.class, McAdapterItem4.class));
                break;
            case 3:
                lv.setAdapter(new CommonAdapter(data) {
                    @NonNull
                    @Override
                    public IAdapterItem onCreateItem(Object type) {
                        return new McAdapterItem2();
                    }
                });
                break;
            case 4:
                lv.setAdapter(new CommonAdapter<McEntity>(list, 2) {
                    @Override
                    public Object getItemType(McEntity obj) {
                        return obj.getItemType();
                    }
                    @NonNull@Override
                    public IAdapterItem onCreateItem(Object type) {
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