package com.android.modulcommons;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;

import com.android.modulcommons.threads.DVThreadManager;
import com.android.modulcommons.utils.DVStatusBarUtils;
import com.android.modulcommons.view.slidingview.DVSlidingPaneLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/3/9.
 * AppCompatActivity与Activity最大的差别就是界面顶上的ActionBar
 * 配置的theme必须要继承自Theme.AppCompat
 *
 */

public abstract class DVBaseAppCompatActivity extends AppCompatActivity implements DVSlidingPaneLayout.SlidingPaneListener{

    /**
     * 该Activity实例，命名为context是因为大部分方法都只需要context，写成context使用更方便
     * @warn 不能在子类中创建
     */
    protected DVBaseFragmentActivity context = null;
    /**
     * 该Activity的界面，即contentView
     * @warn 不能在子类中创建
     */
    protected View view = null;
    /**
     * 布局解释器
     * @warn 不能在子类中创建
     */
    protected LayoutInflater inflater = null;

    /**
     * Fragment管理器
     * @warn 不能在子类中创建
     */
    protected FragmentManager fragmentManager = null;

    private boolean isAlive = false;
    private boolean isRunning = false;
    /**
     * 线程名列表
     */
    protected List<String> threadNameList;

    protected DVSlidingPaneLayout slidingPaneLayout;
    private boolean mIsSwipeBackEnable = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        DVStatusBarUtils.initSubStatusBar(this);

        isAlive = true;
        context = (DVBaseFragmentActivity) getActivity();
        fragmentManager = getSupportFragmentManager();

        inflater = getLayoutInflater();

        threadNameList = new ArrayList<String>();

        if(needInitSwipeBack()) {
            initSwipeBackFinish();
        }

        boolean mIsEffectEnabled = isEffectEnabled();
        if (!mIsEffectEnabled) {
            setSwipeBackEnable(false);
        }
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onResume() {
        super.onResume();
        isRunning = true;
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onPause() {
        super.onPause();
        isRunning = false;
    }

    @Override
    protected void onDestroy() {
        isAlive = false;
        isRunning = false;
        super.onDestroy();

        inflater = null;
        view = null;
        fragmentManager = null;
        threadNameList = null;
        context = null;
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    public final boolean isAlive() {
        return isAlive && context != null;// & ! isFinishing();导致finish，onDestroy内runUiThread不可用
    }

    public final boolean isRunning() {
        return isRunning & isAlive();
    }

    /**
     * 是否初始化 滑动返回， 默认true
     * @return
     */
    public boolean needInitSwipeBack(){
        return true;
    }

    /**
     *
     * @return
     */
    protected boolean isEffectEnabled() {
        return true;
    }

    /**
     * 初始化滑动返回
     */
    private void initSwipeBackFinish() {
        slidingPaneLayout = new DVSlidingPaneLayout(this);
        slidingPaneLayout.bindActivity(this);
        slidingPaneLayout.setSlidingPaneListener(this);
        if (!mIsSwipeBackEnable) {
            slidingPaneLayout.setCloseSlidingPane(true);
        }
    }

    /**
     * 是否关闭侧滑返回
     * @param closeSlidingPane true关闭，否则开启
     */
    public void setCloseSlidingPane(boolean closeSlidingPane) {
        if(slidingPaneLayout != null){
            slidingPaneLayout.setCloseSlidingPane(closeSlidingPane);
        }
    }

    /**
     * 让滑动退出无效功能.
     */
    public synchronized void disableSwipeBackFinish() {
        if (!mIsSwipeBackEnable) {
            return;
        }
        mIsSwipeBackEnable = false;
        if (slidingPaneLayout != null) {
            slidingPaneLayout.setCloseSlidingPane(true);
        }

    }

    public void setSwipeBackEnable(boolean isSwipeBackEnable){
        mIsSwipeBackEnable = isSwipeBackEnable;
    }

    public void runThread(Runnable runnable) {
        DVThreadManager.getThreadManager().execute(runnable);
    }

    /**
     * return this
     * @return
     */
    protected abstract Activity getActivity();
}
