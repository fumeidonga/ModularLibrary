package com.android.testdesignmodel.proxy.statics;

import com.android.modulcommons.utils.DVLogUtils;
import com.android.testdesignmodel.proxy.IStaticProxy;

public class StaticProxy implements IStaticProxy {
    IStaticProxy client;

    public StaticProxy(IStaticProxy client) {
        this.client = client;
    }

    @Override
    public void buy() {
        DVLogUtils.d("这里是代购，可以买海外的东西");
        client.buy();

    }

    @Override
    public void pay() {

        DVLogUtils.d("这里是代购 pay");
    }
}
