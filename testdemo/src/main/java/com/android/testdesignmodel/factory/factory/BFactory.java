package com.android.testdesignmodel.factory.factory;

import com.android.testdesignmodel.module.Computer;
import com.android.testdesignmodel.module.TaiShiJiComputer;

public class BFactory extends AbstractFactory {
    @Override
    public Computer buildComputer() {
        return new TaiShiJiComputer();
    }
}
