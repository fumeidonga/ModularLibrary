package com.android.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.android.MarkdownUtils;
import com.android.performance.MainPerformanceActivity;
import com.android.testdagger.DaggerTestActivity;
import com.android.testdagger.MainActivity;
import com.android.testdagger.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainAndroidActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_android);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.show_dialog0)
    public void button0(){
        startActivity(new Intent(this, MainPerformanceActivity.class));
    }

    @OnClick(R.id.show_dialog1)
    public void button1(){

    }

    @OnClick(R.id.show_dialog2)
    public void button2(){

    }

    @OnClick(R.id.show_dialog3)
    public void button3(){

    }

    @OnClick(R.id.show_dialog4)
    public void button4(){

    }

    @OnClick(R.id.show_dialog5)
    public void button5(){

    }

    @OnClick(R.id.show_dialog6)
    public void button6(){

        startActivity(new Intent(this, DaggerTestActivity.class));
    }

    @OnClick(R.id.show_dialog7)
    public void button7(){

        MarkdownUtils.setData(this, "lifecycle/Lifecycle.md");
    }

    @OnClick(R.id.show_dialog8)
    public void button8(){

        MarkdownUtils.setData(MainAndroidActivity.this, "android/监听应用前后台切换.md");
    }

    @OnClick(R.id.show_dialog9)
    public void button9(){
        MarkdownUtils.setData(MainAndroidActivity.this, "android/监听锁屏.md");

    }
}
