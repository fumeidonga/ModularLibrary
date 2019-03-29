package com.android.testdesignmodel.builder.one;

import com.android.modulcommons.utils.DVLogUtils;
import com.android.testdesignmodel.module.Computer;

public class TCLBuilder extends Builder {

    Computer computer;

    public TCLBuilder() {
        init();
        buildCpu();
        buildKeHu();
        buildYingPan();
        buildZhuBan();
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
