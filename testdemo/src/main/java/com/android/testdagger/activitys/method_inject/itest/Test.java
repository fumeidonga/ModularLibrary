package com.android.testdagger.activitys.method_inject.itest;

import android.content.Context;

import com.android.testdagger.dagger.scope.ActivityScoped;

import javax.inject.Inject;

public class Test implements ITest {

    private Context mContext;

    @Inject
    public Test() {
    }

//    @Inject
    public Test(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public void test() {

    }

    @Override
    public void test(String string) {

    }
}
