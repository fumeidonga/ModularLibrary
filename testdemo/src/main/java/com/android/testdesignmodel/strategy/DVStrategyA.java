package com.android.testdesignmodel.strategy;

import com.android.modulcommons.utils.DVLogUtils;

public class DVStrategyA implements IDVStrategy {
    @Override
    public void strategy() {
        DVLogUtils.dt("a");
    }
}
