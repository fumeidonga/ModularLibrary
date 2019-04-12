package com.android.testdesignmodel.lianshi;

import com.android.modulcommons.utils.DVLogUtils;

/**
 * author: huruilong
 * date: 2019/4/12
 * description: ${责任链B} .
 */
public class LianShiB extends BaseHandlerResult {
    @Override
    void handleResult(String url) {
        DVLogUtils.d("责任链B");
    }
}
