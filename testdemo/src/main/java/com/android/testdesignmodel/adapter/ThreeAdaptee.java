package com.android.testdesignmodel.adapter;

import com.android.modulcommons.utils.DVLogUtils;

public class ThreeAdaptee implements IAdaptee {
    @Override
    public void charge() {
        DVLogUtils.dt("这是 3 孔的插座");
    }
}
