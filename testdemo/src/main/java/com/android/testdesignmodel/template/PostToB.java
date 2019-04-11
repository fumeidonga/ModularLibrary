package com.android.testdesignmodel.template;

import com.android.modulcommons.utils.DVLogUtils;

public class PostToB extends ABSKuaiDi {

    @Override
    protected void call() {
        DVLogUtils.d("联系B先生并送到门口");
    }

    //是否签收,覆盖父类的钩子方法，控制流程的走向
    @Override
    protected boolean isSign() {
        return false;
    }
    //拒签，覆盖父类的钩子方法
    @Override
    protected void refuse() {
        DVLogUtils.d("拒绝签收：商品不符");
    }
}
