package com.android.testdagger;


import android.app.Activity;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;

import com.android.modulcommons.DVBaseApplication;
import com.android.modulcommons.utils.DVLogUtils;
import com.android.testdagger.activitys.method_inject.itest.Test1;
import com.android.testdagger.dagger.component.DaggerAppComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import dagger.android.HasBroadcastReceiverInjector;
import dagger.android.HasContentProviderInjector;
import dagger.android.HasServiceInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class AppApplication extends DVBaseApplication implements HasActivityInjector,
        HasSupportFragmentInjector,
        HasServiceInjector,
        HasBroadcastReceiverInjector,
        HasContentProviderInjector {


    @Inject
    DispatchingAndroidInjector<Activity> dispatchingActivityInjector;
    @Inject
    DispatchingAndroidInjector<Fragment> dispatchingFragmentInjector;
    @Inject
    DispatchingAndroidInjector<BroadcastReceiver> broadcastReceiverInjector;
    @Inject
    DispatchingAndroidInjector<Service> serviceInjector;
    @Inject
    DispatchingAndroidInjector<ContentProvider> contentProviderInjector;

    @Inject
    Test1 test1;

    @Override
    public void onCreate() {
        super.onCreate();
        DaggerAppComponent.builder().application(this).build().inject(this);

        mContext = getApplicationContext();
        DVLogUtils.dt(test1);
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingActivityInjector;
    }

    @Override
    public AndroidInjector<BroadcastReceiver> broadcastReceiverInjector() {
        return broadcastReceiverInjector;
    }

    @Override
    public AndroidInjector<ContentProvider> contentProviderInjector() {
        return contentProviderInjector;
    }

    @Override
    public AndroidInjector<Service> serviceInjector() {
        return serviceInjector;
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return dispatchingFragmentInjector;
    }
    // 获取到主线程的上下文
    private static Context mContext;

    public static SharedPreferences preferences() {
        if(sharedPreferences == null) {
            sharedPreferences = mContext.getSharedPreferences("km-other-sp",
                    Context.MODE_PRIVATE);
        }
        return sharedPreferences;
    }

    private static SharedPreferences sharedPreferences;
    /**
     * 获取字符串格式的数据
     */
    public static String getString(String key, String value) {
        preferences();
        return sharedPreferences.getString(key, value);
    }

    /**
     * 字符串格式保存数据
     */
    public static void saveString(String key, String data) {
        preferences();
        sharedPreferences.edit().putString(key, data).apply();
    }
}

/*public class AppApplication extends DaggerApplication {

//    @Override
//    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
//        return DaggerAppComponent.builder().application(this).build();
//    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().create(this);
    }

}*/
