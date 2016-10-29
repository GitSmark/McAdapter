package com.huangxy.mcadapter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by huangxy on 2016/10/29.
 * https://github.com/GitSmark/McAdapter
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.McAdapter_btn1).setOnClickListener(this);
        findViewById(R.id.McAdapter_btn2).setOnClickListener(this);
        findViewById(R.id.McAdapter_btn3).setOnClickListener(this);
        findViewById(R.id.McAdapter_btn4).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.McAdapter_btn1:
                ShowSample(1);
                break;
            case R.id.McAdapter_btn2:
                ShowSample(2);
                break;
            case R.id.McAdapter_btn3:
                ShowSample(3);
                break;
            case R.id.McAdapter_btn4:
                ShowSample(4);
                break;
            default:
                break;
        }
    }

    private void ShowSample(int sampleNum){
        Intent intent = new Intent(this, SampleActivity.class);
        intent.putExtra("sampleNum", sampleNum);
        startActivity(intent);
    }
}
