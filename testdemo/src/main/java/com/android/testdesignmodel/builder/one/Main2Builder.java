package com.android.testdesignmodel.builder.one;

import com.android.modulcommons.utils.DVLogUtils;
import com.android.testdesignmodel.module.Computer;

public class Main2Builder extends Builder {

    Computer computer;

    public Main2Builder() {
        init();
    }

    @Override
    public void init() {
        computer = new Computer();
    }

    @Override
    public void buildKeHu() {
        computer.kehu = "kehu";
    }

    @Override
    public void buildCpu() {
        computer.cpu = "cupu";
    }

    @Override
    public void buildZhuBan() {
        computer.zhuban = "zhuban";
    }

    @Override
    public void buildYingPan() {
        computer.yingpan = "yingpan";
    }

    @Override
    public Computer buildComputer() {
        DVLogUtils.d(computer);
        return computer;
    }
}
