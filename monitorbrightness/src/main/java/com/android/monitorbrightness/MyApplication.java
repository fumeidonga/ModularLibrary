package com.android.monitorbrightness;

import android.app.Application;
import android.content.Intent;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Intent i = new Intent(this, MyService.class);
        startService(i);
    }
}
