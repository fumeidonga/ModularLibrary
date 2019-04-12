package com.android.testdagger;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;

import com.android.MarkdownUtils;
import com.android.java.JavaMainActivity;
import com.android.test.TestActivity;
import com.android.testdagger.activitys.method_inject.FourActivity;
import com.android.testdagger.activitys.one_mvp.OneActivity;
import com.android.testdagger.activitys.three_absdagger.ThreeActivity;
import com.android.testdagger.activitys.two_mvp_dagger.TwoActivity;
import com.android.testdagger.fragments.TasksActivity;
import com.android.testdesignmodel.DesignModelActivity;
import com.android.testrxjava.HomeActivity;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends Activity {

    private Timer timer;
    ScreenOnOffReceiver mScreenOnOffReceiver = null;
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

                startActivity(new Intent(MainActivity.this, DaggerTestActivity.class));

            }
        });
        findViewById(R.id.show_dialog1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this, JavaMainActivity.class));
            }
        });
        findViewById(R.id.show_dialog2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MarkdownUtils.setData(MainActivity.this, "lifecycle/Lifecycle.md");
            }
        });
        findViewById(R.id.show_dialog3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MarkdownUtils.setData(MainActivity.this, "lamada/LAMADA.MD");
            }
        });
        findViewById(R.id.show_dialog4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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
        findViewById(R.id.show_dialog7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, DesignModelActivity.class));

            }
        });
        findViewById(R.id.show_dialog8).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MarkdownUtils.setData(MainActivity.this, "监听应用前后台切换.md");

            }
        });
        findViewById(R.id.show_dialog9).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MarkdownUtils.setData(MainActivity.this, "监听锁屏.md");

            }
        });
        startScreenBroadcastReceiver();
    }

    private void startScreenBroadcastReceiver(){
        if(mScreenOnOffReceiver == null) {
            mScreenOnOffReceiver = new ScreenOnOffReceiver();
        }
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_SCREEN_ON);
        filter.addAction(Intent.ACTION_SCREEN_OFF);
        filter.addAction(Intent.ACTION_USER_PRESENT);
        registerReceiver(mScreenOnOffReceiver, filter);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mScreenOnOffReceiver);
    }

    public void init(){
    }
}
