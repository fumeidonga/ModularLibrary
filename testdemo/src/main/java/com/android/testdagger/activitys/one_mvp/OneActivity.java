package com.android.testdagger.activitys.one_mvp;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.android.modulcommons.utils.DVLogUtils;
import com.android.testdagger.R;
import com.google.gson.Gson;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

/**
 * MVP
 * v
 * 持有P层 {@link OnePresenter}
 */
public class OneActivity extends AppCompatActivity implements OneContract.View {

    /**
     * 这里application 要注入，需要2步
     * 1， oncreate 中调用AndroidInjection.inject(this);
     * 2，    ActivityBindingModule中调用
     *       @ContributesAndroidInjector
     *       abstract OneActivity oneActivity();
     */
    @Inject
    Application application;

    @Inject
    Gson gson;

    OneContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);
        mPresenter = new OnePresenter(this);

        DVLogUtils.dt(application);
        DVLogUtils.dt(gson);
    }

    @Override
    public void setPresenter(OneContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.takeView(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.dropView();
    }
    @Override
    public void editTask() {
        mPresenter.editTask();
    }

    @Override
    public void deleteTask() {
        mPresenter.deleteTask();
    }

    @Override
    public void completeTask() {
        mPresenter.completeTask();
    }

}
