package com.android.performance;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.android.MarkdownUtils;
import com.android.modulcommons.utils.DVLogUtils;
import com.android.performance.kadun.KaDunActivity;
import com.android.performance.layout.LayoutActivity;
import com.android.performance.memory.MemoryActivity;
import com.android.testdagger.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainPerformanceActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_performance);
        ButterKnife.bind(this);
        //用来测试卡顿监听
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @OnClick(R.id.show_dialog)
    public void button(){
        MarkdownUtils.setData(this, "android/performace/性能优化.MD");
    }

    @OnClick(R.id.show_dialog0)
    public void button0(){
        startActivity(new Intent(this, LayoutActivity.class));
    }

    @OnClick(R.id.show_dialog1)
    public void button1(){
        startActivity(new Intent(this, MemoryActivity.class));
    }


    @OnClick(R.id.show_dialog2)
    public void button2(){
        startActivity(new Intent(this, KaDunActivity.class));

    }

    @OnClick(R.id.show_dialog3)
    public void button3(){
        //用来测试卡顿监听
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        DVLogUtils.dt("");
    }

    @OnClick(R.id.show_dialog4)
    public void button4(){

    }

    @OnClick(R.id.show_dialog5)
    public void button5(){

    }

    @OnClick(R.id.show_dialog6)
    public void button6(){

    }

    @OnClick(R.id.show_dialog7)
    public void button7(){

    }

    @OnClick(R.id.show_dialog8)
    public void button8(){

    }

    @OnClick(R.id.show_dialog9)
    public void button9(){

    }


}
