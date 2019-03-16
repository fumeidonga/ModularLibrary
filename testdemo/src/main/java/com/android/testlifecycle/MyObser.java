package com.android.testlifecycle;

import android.arch.lifecycle.DefaultLifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.support.annotation.NonNull;

/**
 * 两种实现方式：
 *
 * 实现DefultLifecyceObserver接口，然后重写里面生命周期方法；
 * 直接实现LifecycleObserver接口，然后通过注解的方式来接收生命周期的变化；
 * Lifecycle.java文档中是建议使用第一种方式，因为文档中说明了，随着Java8成为主流，注解的方式会被弃用。DefaultLifecycleObserver是需要另外声明的java8 比如下面
 * GenericLifecycleObserver，FullLifecycleObserver，DefaultLifecycleObserver 这三个接口都是直接或者间接继承的LifecycleObserver
 */
public class MyObser implements DefaultLifecycleObserver {
    @Override
    public void onCreate(@NonNull LifecycleOwner owner) {

    }

    @Override
    public void onStart(@NonNull LifecycleOwner owner) {

    }

    @Override
    public void onResume(@NonNull LifecycleOwner owner) {

    }

    @Override
    public void onPause(@NonNull LifecycleOwner owner) {

    }

    @Override
    public void onStop(@NonNull LifecycleOwner owner) {

    }

    @Override
    public void onDestroy(@NonNull LifecycleOwner owner) {

    }
}
