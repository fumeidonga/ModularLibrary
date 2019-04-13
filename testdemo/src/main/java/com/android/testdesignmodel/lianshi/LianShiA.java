package com.android.testdesignmodel.lianshi;

import android.text.TextUtils;

import com.android.modulcommons.utils.DVLogUtils;

/**
 * author: hrl
 * date: 2019/4/12
 * description: $ 责任链A .
 */
public class LianShiA extends BaseHandlerResult {
    @Override
    public boolean handleResult(String url) {
        DVLogUtils.d("责任链A");
        if(TextUtils.isEmpty(url)) {
            return handleNext(url);
        }
        DVLogUtils.d("责任链A " + url);
        return true;
    }
}
