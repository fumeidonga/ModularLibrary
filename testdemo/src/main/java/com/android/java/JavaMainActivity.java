package com.android.java;

import android.app.Activity;
import android.os.Bundle;

import com.android.testdagger.R;

public class JavaMainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
