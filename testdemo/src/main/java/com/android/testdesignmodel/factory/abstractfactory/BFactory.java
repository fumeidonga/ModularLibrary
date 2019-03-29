package com.android.testdesignmodel.factory.abstractfactory;

public class BFactory extends AbsFactory {

    @Override
    public AbstractMouseProduct createMouse() {
        return new MouseProductB();
    }

    @Override
    public AbstractKeyProduct createKey() {
        return new KeyProductB();
    }
}
