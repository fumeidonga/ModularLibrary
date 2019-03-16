package com.android.monitorbrightness;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.android.modulcommons.utils.DVLogUtils;

public class MyReceiver extends BroadcastReceiver {

    public static final String action = "android.intent.action.brighness.change";
    @Override
    public void onReceive(Context context, Intent intent) {
        DVLogUtils.dt(intent.getAction());
        if (intent.getAction().equals("android.intent.action.BOOT_COMPLETED")) {
            Intent i = new Intent(context, MainActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
        } else if(intent.getAction().equals(action)) {
            Intent i = new Intent(context, Main2Activity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
        }
    }
}
