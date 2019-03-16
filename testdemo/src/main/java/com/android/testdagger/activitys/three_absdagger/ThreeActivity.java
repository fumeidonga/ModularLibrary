package com.android.testdagger.activitys.three_absdagger;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.android.modulcommons.utils.DVLogUtils;
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
