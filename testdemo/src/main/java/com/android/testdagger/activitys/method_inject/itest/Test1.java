package com.android.testdagger.activitys.method_inject.itest;

import android.content.Context;

import com.android.modulcommons.utils.DVLogUtils;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Test1 {

    private Context mContext;
//    @Inject
    public Test1() {
    }

    @Inject
    public Test1(Context mContext) {
        this.mContext = mContext;
        DVLogUtils.dt(mContext);
    }

}
