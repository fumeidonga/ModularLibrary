package com.android.performance.layout;

import android.app.Activity;
import android.os.Bundle;

import com.android.testdagger.R;

public class LayoutActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);
    }
}
