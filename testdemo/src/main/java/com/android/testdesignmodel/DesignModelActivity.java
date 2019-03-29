package com.android.testdesignmodel;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.android.modulcommons.utils.DVLogUtils;
import com.android.testdagger.DVActivityLifecycleCallbacks;
import com.android.testdagger.R;
import com.android.testdesignmodel.builder.BuilderActivity;
import com.android.testdesignmodel.factory.FactoryActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class DesignModelActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_design_model);
        ButterKnife.bind(this);
    }
    @Override
    protected void onStart() {
        super.onStart();
        // 判断是否从后台恢复, 且时间间隔符合要求, 显示广告页面
        boolean isFromBackToFront = DVActivityLifecycleCallbacks.sAppState == DVActivityLifecycleCallbacks.STATE_BACK_TO_FRONT;
        if (isFromBackToFront) {
            DVLogUtils.e("");
        }
    }
    @OnClick(R.id.bottom0)
    public void begin(){
        startActivitys(BuilderActivity.class);
    }
    @OnClick(R.id.bottom1)
    public void begin1(){
        startActivitys(FactoryActivity.class);
    }
    @OnClick(R.id.bottom2)
    public void begin2(){

    }
    @OnClick(R.id.bottom3)
    public void begin3(){

    }
    @OnClick(R.id.bottom4)
    public void begin4(){

    }
    @OnClick(R.id.bottom5)
    public void begin5(){

    }
    @OnClick(R.id.bottom6)
    public void begin6(){

    }
    @OnClick(R.id.bottom7)
    public void begin7(){

    }
    @OnClick(R.id.bottom8)
    public void begin8(){

    }

    public <T> void startActivitys(Class<T> tClass){
        startActivity(new Intent(this, tClass));
    }
}
