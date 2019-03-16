package com.android.testdagger;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.android.test.TestActivity;
import com.android.testdagger.activitys.method_inject.FourActivity;
import com.android.testdagger.activitys.one_mvp.OneActivity;
import com.android.testdagger.activitys.three_absdagger.ThreeActivity;
import com.android.testdagger.activitys.two_mvp_dagger.TwoActivity;
import com.android.testdagger.fragments.TasksActivity;
import com.android.testrxjava.HomeActivity;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends Activity {

    private Timer timer;
    private TimerTask timerTask= new TimerTask(){

        @Override
        public void run() {
            System.out.println("run");
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        findViewById(R.id.show_dialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this, OneActivity.class));

            }
        });
        findViewById(R.id.show_dialog1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TwoActivity.class));
            }
        });
        findViewById(R.id.show_dialog2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ThreeActivity.class));

            }
        });
        findViewById(R.id.show_dialog3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, FourActivity.class));

            }
        });
        findViewById(R.id.show_dialog4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TasksActivity.class));

            }
        });
        findViewById(R.id.show_dialog5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, HomeActivity.class));

            }
        });
        findViewById(R.id.show_dialog6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TestActivity.class));

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public void init(){
    }
}
