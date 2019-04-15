package com.android.performance.layout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.android.MarkdownUtils;
import com.android.testdagger.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class LayoutActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.show_dialog0)
    public void button0(){
        MarkdownUtils.setData(this, "android/Android绘制原理.MD");
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
