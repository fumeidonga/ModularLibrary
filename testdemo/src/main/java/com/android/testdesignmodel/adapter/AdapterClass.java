package com.android.testdesignmodel.adapter;

import com.android.modulcommons.utils.DVLogUtils;

/**
 * 类适配器
 */
public class AdapterClass extends ThreeAdaptee implements ITarget {

    public void charge(){
        DVLogUtils.dt();
    }
}
