package com.android.performance.loading;

import android.app.Activity;
import android.os.Bundle;

import com.android.testdagger.R;

public class LoadingPerformanceActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_performance);
    }
}
