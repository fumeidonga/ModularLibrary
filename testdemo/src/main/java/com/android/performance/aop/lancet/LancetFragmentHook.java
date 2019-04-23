package com.android.performance.aop.lancet;

import android.os.Bundle;

import com.android.modulcommons.utils.DVLogUtils;

import me.ele.lancet.base.Origin;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/**
 * author: hrl
 * date: 2019/4/18
 * description: ${Desc} .
 */
public class LancetFragmentHook {


    @TargetClass(value = "android.support.v7.app.AppCompatActivity",scope = Scope.ALL)
    @Insert(value = "onCreate",mayCreateSuper = true)
    protected void onCreate(Bundle savedInstanceState) {
        DVLogUtils.dt();
        Origin.callVoid();
    }

    @TargetClass(value = "android.support.v7.app.AppCompatActivity", scope = Scope.LEAF)
    @Insert(value = "onStop", mayCreateSuper = true)
    protected void onStop(){
        DVLogUtils.dt();
        Origin.callVoid();
    }

    @TargetClass(value = "android.app.Activity",scope = Scope.ALL)
    @Insert(value = "onCreate",mayCreateSuper = true)
    protected void onCreate1(Bundle savedInstanceState) {
        DVLogUtils.dt(4);
        Origin.callVoid();
        DVLogUtils.dt(5);
    }

    @TargetClass(value = "android.app.Activity")
    @Proxy("onResume")
    protected void onResume() {
        DVLogUtils.dt();
        Origin.callVoid();
        DVLogUtils.dt();
    }

    /**
     * 成功hook， 类型必须完全一致，下面的方法少了一个static都会失败
     * @param tag
     * @param msg
     * @return
     */
    @Proxy("d")
    @TargetClass("android.util.Log")
    public static int ddd(String tag, String msg) {
        msg = " hook Log.d " + msg ;
        //DVLogUtils.et(msg);
        return (int) Origin.call();
    }

    /**
     * hook 不了
     * @param tag
     * @param msg
     * @return
     */
    /*@Insert(value = "d")
    @TargetClass("android.util.Log")
    public static int d(String tag, String msg) {
        msg = msg + " hook Log.d";
        DVLogUtils.et(msg);
        return (int) Origin.call();
    }*/

    @Proxy("i")
    @TargetClass("android.util.Log")
    public static int i(String tag, String msg) {
        msg = msg + "  hook Log.i";
        return (int) Origin.call();
    }

    @TargetClass(value = "android.widget.LinearLayout", scope = Scope.ALL)
    @Insert(value = "getBaseline", mayCreateSuper = true)
    protected int getBaseline(){
        DVLogUtils.dt();
        return (int) Origin.call();
    }
    @TargetClass(value = "android.view.ViewGroup.MarginLayoutParams", scope = Scope.ALL)
    @Insert(value = "setMargins", mayCreateSuper = true)
    protected void setMargins1(int left, int top, int right, int bottom){
        DVLogUtils.dt();
        Origin.callVoid();
    }
}
