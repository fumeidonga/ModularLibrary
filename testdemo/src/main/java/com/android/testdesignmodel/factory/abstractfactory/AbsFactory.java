package com.android.testdesignmodel.factory.abstractfactory;

import com.android.testdesignmodel.module.Computer;

public abstract class AbsFactory {

    public abstract AbstractMouseProduct createMouse();
    public abstract AbstractKeyProduct createKey();
}
