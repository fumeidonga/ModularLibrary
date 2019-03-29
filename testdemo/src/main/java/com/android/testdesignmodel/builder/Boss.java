package com.android.testdesignmodel.builder;

import com.android.testdesignmodel.builder.one.Main2Builder;
import com.android.testdesignmodel.builder.one.TCLBuilder;
import com.android.testdesignmodel.module.Computer;

/**
 * 商店老板
 */
public class Boss {

    /**
     * 员工 1
     */
    Builder builder1;
    /**
     * 员工 2
     */
    com.android.testdesignmodel.builder.one.Builder builder2;
    /**
     * 员工 3
     */
    com.android.testdesignmodel.builder.one.Builder builder3;

    public Boss() {
        builder1 = new Main1Builder();
        builder2 = new Main2Builder();
        builder3 = new TCLBuilder();
    }

    /**
     * 买电脑
     * 3. 这个时候，老板找到了员工1.，告诉他去组装一台电脑过来
     * @return
     */
    public Computer buyComputer(int i, String cpu, String zhuban, String yingpan){
        builder1.buildCpu(cpu);
        builder1.buildKeHu("客户 " + i);
        builder1.buildZhuBan(zhuban);
        builder1.buildYingPan(yingpan);
        return builder1.buildComputer();
    }
    /**
     * 买品牌电脑
     * 3. 这个时候，老板找到了员工2.，告诉他去组装一台电脑过来
     * 品牌电脑里面的都是固定的，所以直接组装就可以
     * @return
     */
    public Computer buyComputer(){
        return builder2.buildComputer();
    }
}
