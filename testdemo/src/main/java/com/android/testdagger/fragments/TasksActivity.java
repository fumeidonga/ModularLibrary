package com.android.testdagger.fragments;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;

import com.android.modulcommons.utils.DVLogUtils;
import com.android.testdagger.DVActivityLifecycleCallbacks;
import com.android.testdagger.R;

import javax.inject.Inject;

import dagger.Lazy;
import dagger.android.support.DaggerAppCompatActivity;

public class TasksActivity extends DaggerAppCompatActivity {
//
    @Inject
    TasksFragment tasksFragment;
    @Inject
    Lazy<TasksFragment> taskFragmentProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);

//        TasksFragment tasksFragment = null;
//        tasksFragment = taskFragmentProvider.get();
//        tasksFragment =
//                (TasksFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);

        if (tasksFragment == null) {
            // Get the fragment from dagger
            //tasksFragment = TasksFragment.newInstance("1", "2");
            tasksFragment = taskFragmentProvider.get();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.contentFrame, tasksFragment);
            transaction.commit();
        } else {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.contentFrame, tasksFragment);
            transaction.commit();
        }
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
}
