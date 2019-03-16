package com.android.testdagger.activitys.method_inject;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.android.modulcommons.utils.DVLogUtils;
import com.android.testdagger.R;
import com.android.testdagger.activitys.method_inject.itest.ITest;
import com.android.testdagger.dagger.scope.ActivityScoped;
import com.google.gson.Gson;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class FourActivity extends AppCompatActivity {

    @Inject
    Application application;

    @Inject
    Gson gson;

    /**
     * 构造方法注入
     *
     *
     * iTest 不为空，必须满足下面几个条件
     * 1， 构造方法添加inject
     *     @Inject
     *     public Test() {
     *     }
     * 2，ActivityBindingModule
     *     @ContributesAndroidInjector(modules = {InjectModule.class})
     *     abstract FourActivity fourActivity();
     * 3，oncreate  AndroidInjection.inject(this);
     * 4，
     */
    @Inject
//    @ActivityScoped
    ITest iTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        AndroidInjection.inject(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four);
        DVLogUtils.dt(application);
        DVLogUtils.dt(iTest);
        DVLogUtils.dt(gson);
    }
}
