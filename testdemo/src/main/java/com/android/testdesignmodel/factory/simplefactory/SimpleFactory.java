package com.android.testdesignmodel.factory.simplefactory;

import com.android.testdesignmodel.module.BiJiBenComputer;
import com.android.testdesignmodel.module.Computer;
import com.android.testdesignmodel.module.TaiShiJiComputer;

public class SimpleFactory {



    public static Computer getComputer(int type){
        switch (type) {
            case 0:
                return new TaiShiJiComputer();
            case 1:
                return new BiJiBenComputer();
        }
        return new Computer();
    }


}
