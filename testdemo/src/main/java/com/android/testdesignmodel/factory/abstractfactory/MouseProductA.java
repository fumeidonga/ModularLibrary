package com.android.testdesignmodel.factory.abstractfactory;

public class MouseProductA extends AbstractMouseProduct {
    @Override
    public MouseProductA build() {

        name = "mouse product a";
        price = "100";
        return this;
    }
}
