package com.huangxy.mcadapter;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.huangxy.mcadapter.adapterItem.McAdapterItem1;
import com.huangxy.mcadapter.adapterItem.McAdapterItem2;
import com.huangxy.mcadapter.adapterItem.McAdapterItem3;
import com.huangxy.mcadapter.adapterItem.McAdapterItem4;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huangxy on 2016/10/29.
 * https://github.com/GitSmark/McAdapter
 */
public class SampleActivity extends AppCompatActivity implements IAdapterView.OnClickListener, IAdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);
        ListView lv = findViewById(R.id.sample_listview);

        List<String> data = new ArrayList<>();
        for (int i = 1; i < 20; i++) {
            data.add("Test"+i);
        }

        List<McEntity> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            //支持泛型，itemEntity支持多布局对应多model
            list.add(new McEntity("Test"+i, i%2));
        }

        //List<McEntity> list = McAdapterUtil.toMcEntity(data);
        //List<McEntity> list = McAdapterUtil.toMcEntity(data, 1);

        switch (getIntent().getIntExtra("sampleNum", 0)){
            case 1:
                //lv.setAdapter(new McAdapter(data, McAdapterItem1.class));
                lv.setAdapter(new McAdapter(this, data, McAdapterItem1.class)); //添加监听
                break;
            case 2:
                //lv.setAdapter(new McAdapter(list, McAdapterItem3.class, McAdapterItem4.class));
                lv.setAdapter(new McAdapter(this, list, McAdapterItem3.class, McAdapterItem4.class)); //多布局（最新范例请点击查看MultiActivity.java）
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

    @Override
    public void onClick(View view, int position) {
        switch (view.getId()) {
            case R.id.tv_item1:
                Log.e("McAdapter", "onClick - " + position);
                break;
            default:
                break;
        }
    }

    @Override
    public void onItemClick(IAdapterItem parent, View view, int position, Object item) {
        Log.e(parent.getClass().getSimpleName(), "onItemClick - " + position);
        if(parent.getClass() == McAdapterItem3.class) {
            Intent intent = new Intent(this, MultiActivity.class); //AdapterModel跟AdapterItem绑定，支持多布局
            startActivity(intent);
        }
    }
}