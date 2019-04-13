package com.android.testdesignmodel.lianshi;

import android.text.TextUtils;

import com.android.modulcommons.utils.DVLogUtils;

/**
 * author: huruilong
 * date: 2019/4/12
 * description: ${责任链B} .
 */
public class LianShiB extends BaseHandlerResult {
    @Override
    public boolean handleResult(String url) {
        DVLogUtils.d("责任链B");
        if(TextUtils.isEmpty(url)) {
            return handleNext(url);
        }
        DVLogUtils.d("责任链B " + url);
        return true;
    }
}
