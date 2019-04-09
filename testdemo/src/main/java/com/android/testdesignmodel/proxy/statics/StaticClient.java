package com.android.testdesignmodel.proxy.statics;

import com.android.modulcommons.utils.DVLogUtils;
import com.android.testdesignmodel.proxy.IStaticProxy;

public class StaticClient implements IStaticProxy {
    @Override
    public void buy() {
        DVLogUtils.d("客户要买海外的东西");
    }

    @Override
    public void pay() {

        DVLogUtils.d("客户pay");
    }
}
