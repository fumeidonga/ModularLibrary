package com.android.modulcommons;

import android.app.Application;

import com.android.modulcommons.utils.DVApplicationUtil;

/**
 * Created by Administrator on 2018/3/9.
 * DVBaseApplication，必须在组件中实现自己的Application，DVBaseApplication；
 * 组件中实现的Application必须在debug包中的AndroidManifest.xml中注册，否则无法使用；
 * 组件的Application需置于java/debug文件夹中，不得放于主代码；
 * 组件中获取Context的方法必须为:DVApplicationUtil.getContext()，不允许其他写法；
 */

public class DVBaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        DVApplicationUtil.init(this);
    }

}
