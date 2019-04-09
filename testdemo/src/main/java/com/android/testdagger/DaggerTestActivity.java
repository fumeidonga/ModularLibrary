package com.android.testdagger;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.android.testdagger.activitys.method_inject.FourActivity;
import com.android.testdagger.activitys.one_mvp.OneActivity;
import com.android.testdagger.activitys.three_absdagger.ThreeActivity;
import com.android.testdagger.activitys.two_mvp_dagger.TwoActivity;
import com.android.testdagger.fragments.TasksActivity;

public class DaggerTestActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger_test);

        findViewById(R.id.show_dialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(DaggerTestActivity.this, OneActivity.class));

            }
        });
        findViewById(R.id.show_dialog1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DaggerTestActivity.this, TwoActivity.class));
            }
        });
        findViewById(R.id.show_dialog2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DaggerTestActivity.this, ThreeActivity.class));

            }
        });
        findViewById(R.id.show_dialog3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DaggerTestActivity.this, FourActivity.class));

            }
        });
        findViewById(R.id.show_dialog4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DaggerTestActivity.this, TasksActivity.class));

            }
        });
    }
}
