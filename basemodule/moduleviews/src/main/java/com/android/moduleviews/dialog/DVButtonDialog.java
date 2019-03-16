package com.android.moduleviews.dialog;

import android.support.annotation.LayoutRes;
import android.view.Gravity;
import android.view.View;

import com.android.modulcommons.utils.DVLogUtils;
import com.android.moduleviews.R;

/**
 * 渐变的
 */
public class DVButtonDialog extends DVBaseButtonDialog {

    @LayoutRes
    public int getLayoutRes(){
        return R.layout.control_pic_popupwindow;
    }
    @Override
    public void onBindView(View v) {
        DVLogUtils.dt();
    }

    @Override
    protected DVButtonDialog build(DVBaseButtonDialog.Builder builder) {
        super.setBuild(builder);
        return this;
    }

    public static class Builder extends DVBaseButtonDialog.Builder {
        public Builder() {
            setmTheme(R.style.dv_base_fragment_dialog_alpha);
        }

        @Override
        public DVButtonDialog build() {
            return new DVButtonDialog().build(this);
        }
    }
}
