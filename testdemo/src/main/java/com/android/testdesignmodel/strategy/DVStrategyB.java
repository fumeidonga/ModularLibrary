package com.android.testdesignmodel.strategy;

import com.android.modulcommons.utils.DVLogUtils;

public class DVStrategyB implements IDVStrategy {
    @Override
    public void strategy() {

        DVLogUtils.dt("b");
    }
}
