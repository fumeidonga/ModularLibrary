package com.android.monitorbrightness;

import android.app.Activity;
import android.app.Service;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.ContentObserver;
import android.os.Handler;
import android.os.IBinder;
import android.provider.Settings;
import android.view.WindowManager;

import com.android.modulcommons.utils.DVDevicesUtils;
import com.android.modulcommons.utils.DVLogUtils;

public class MyService extends Service {
    public MyService() {
    }

    private ContentObserver mBrightnessObserver = new ContentObserver(new Handler()) {
        @Override
        public void onChange(boolean selfChange) {

            DVLogUtils.dt(selfChange);
            DVLogUtils.dt(DVDevicesUtils.getScreenBrightness(getApplicationContext()));
            if(DVDevicesUtils.getScreenBrightness(getApplicationContext()) < 15) {
                DVLogUtils.dt();
                //getApplicationContext().sendBroadcast(new Intent(MyReceiver.action));
                Intent i = new Intent(getApplicationContext(), Main2Activity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getApplicationContext().startActivity(i);
            }


        }
    };

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        DVLogUtils.dt();
        this.getContentResolver().registerContentObserver(
                Settings.System.getUriFor(Settings.System.SCREEN_BRIGHTNESS), true,
                mBrightnessObserver);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        DVLogUtils.dt();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        DVLogUtils.dt();
        super.onDestroy();
    }
}
