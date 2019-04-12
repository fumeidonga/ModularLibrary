package com.android.performance;

import android.app.Activity;
import android.os.Bundle;

import com.android.testdagger.R;

import butterknife.ButterKnife;

public class MainPerformanceActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_performance);
        ButterKnife.bind(this);
    }



}
