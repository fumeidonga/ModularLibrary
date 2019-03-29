package com.android.testdesignmodel.factory.factory;

import com.android.testdesignmodel.module.BiJiBenComputer;
import com.android.testdesignmodel.module.Computer;

public class AFactory extends AbstractFactory {
    @Override
    public Computer buildComputer() {
        return new BiJiBenComputer();
    }
}
