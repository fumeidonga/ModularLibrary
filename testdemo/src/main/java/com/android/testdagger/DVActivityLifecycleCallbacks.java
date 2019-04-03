package com.android.testdagger;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import com.android.modulcommons.utils.DVLogUtils;

/**
 * 注册在Application中监听所有Activity生命周期的管理类
 */
public class DVActivityLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {

    public static final int STATE_NORMAL = 0;
    public static final int STATE_BACK_TO_FRONT = 1;
    public static final int STATE_FRONT_TO_BACK = 2;
    public static int sAppState = STATE_NORMAL;
    private int mVisibleActivityCount = 0;

    public static boolean mIsScreenOff = false;


    public DVActivityLifecycleCallbacks() {
        DVLogUtils.dt();
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
//        UIUtils.setCustomDensity(activity,activity.getApplication());
        DVLogUtils.dt();
    }

    @Override
    public void onActivityStarted(Activity activity) {
        DVLogUtils.dt();
        // 每有一个activity可见都会走该方法，mVisibleActivityCount会增1。
        mVisibleActivityCount++;
        if (mVisibleActivityCount == 1) {
            if(mIsScreenOff){
                mIsScreenOff = false;
                // 否则是正常状态
                sAppState = STATE_NORMAL;
            } else {
                // 从后台进入前台
                sAppState = STATE_BACK_TO_FRONT;
            }
        } else {
            // 否则是正常状态
            sAppState = STATE_NORMAL;
        }
    }

    @Override
    public void onActivityResumed(Activity activity) {
        DVLogUtils.dt();

    }

    @Override
    public void onActivityPaused(Activity activity) {
        DVLogUtils.dt();
    }

    @Override
    public void onActivityStopped(final Activity activity) {
        DVLogUtils.dt();
        //每有一个acitivity不可见都会走该方法，让mVisibleActivityCount减1。
        mVisibleActivityCount--;
        if (mVisibleActivityCount == 0) {
            // 从前台进入后台
            sAppState = STATE_FRONT_TO_BACK;
        } else {
            // 否则是正常状态
            sAppState = STATE_NORMAL;
        }

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        DVLogUtils.dt();

    }

    @Override
    public void onActivityDestroyed(Activity activity) {
        DVLogUtils.dt();
    }
}
