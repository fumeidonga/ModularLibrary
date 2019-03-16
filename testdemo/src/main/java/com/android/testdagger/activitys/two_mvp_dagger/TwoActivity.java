package com.android.testdagger.activitys.two_mvp_dagger;

import android.app.Application;
import android.os.Bundle;

import com.android.modulcommons.utils.DVLogUtils;
import com.android.testdagger.R;
import com.google.gson.Gson;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.DaggerActivity;

public class TwoActivity extends DaggerActivity implements TwoContract.View{

    @Inject
    TwoPresenter twoPresenter;

    @Inject
    Application application;

    @Inject
    Gson gson;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        AndroidInjection.inject(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        DVLogUtils.dt(twoPresenter);
        DVLogUtils.dt(application);
        DVLogUtils.dt(gson);
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
    public void setPresenter(TwoContract.Presenter presenter) {

    }
}
