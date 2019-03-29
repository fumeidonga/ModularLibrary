package com.android.testdagger.activitys.three_absdagger;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.android.modulcommons.utils.DVLogUtils;
import com.android.testdagger.DVActivityLifecycleCallbacks;
import com.android.testdagger.R;
import com.google.gson.Gson;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class ThreeActivity extends AppCompatActivity implements ThreeContract.View{

    @Inject
    ThreePresenter threePresenter;

    @Inject
    Application application;

    @Inject
    Gson gson;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        AndroidInjection.inject(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);
        DVLogUtils.dt(threePresenter);
        DVLogUtils.dt(application);
        DVLogUtils.dt(gson);
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
    @Override
    public void editTask() {

    }

    @Override
    public void deleteTask() {

    }

    @Override
    public void completeTask() {

    }

    @Override
    public void setPresenter(ThreeContract.Presenter presenter) {

    }
}
