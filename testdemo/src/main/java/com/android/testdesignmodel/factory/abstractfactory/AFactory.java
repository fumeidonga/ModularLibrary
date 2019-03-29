package com.android.testdesignmodel.factory.abstractfactory;

public class AFactory extends AbsFactory {

    @Override
    public AbstractMouseProduct createMouse() {
        return new MouseProductA();
    }

    @Override
    public AbstractKeyProduct createKey() {
        return new KeyProductA();
    }
}
