package com.android.testdesignmodel.lianshi;

/**
 * author: Gex
 * date: 2019/4/12
 * description: ${Desc} .
 */
public abstract class BaseHandlerResult {

    BaseHandlerResult mNextHandler;

    abstract void handleResult(String url);

    public BaseHandlerResult getmNextHandler() {
        return mNextHandler;
    }

    public void setmNextHandler(BaseHandlerResult mNextHandler) {
        this.mNextHandler = mNextHandler;
    }
}
