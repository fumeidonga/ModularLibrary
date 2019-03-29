package com.android.testdesignmodel.factory.abstractfactory;

public class MouseProductB extends AbstractMouseProduct {
    @Override
    public MouseProductB build() {

        name = "mouse product a";
        price = "100";
        return this;
    }
}
