package com.android.moduleviews.dialog;

import android.support.annotation.LayoutRes;
import android.view.Gravity;
import android.view.View;

import com.android.modulcommons.utils.DVLogUtils;

/**
 * 从下往上弹出
 */
public class DVBaseButtonDialog extends DVAbsBaseFrgDialog<DVBaseButtonDialog, DVBaseButtonDialog.Builder> {
    @LayoutRes
    public int getLayoutRes(){
        return dvFragmentDialogConfig.mLayoutRes;
    }

    @Override
    public void onBindView(View v) {
        DVLogUtils.dt();
    }

    @Override
    protected DVBaseButtonDialog build(Builder builder) {
        super.setBuild(builder);
        return this;
    }


    public static class Builder extends DVAbsBaseFrgDialog.Builder<Builder> {

        public Builder() {
            setmGravity(Gravity.BOTTOM);
        }

        @Override
        public DVBaseButtonDialog build() {
            return new DVBaseButtonDialog().build(this);
        }
    }


}
