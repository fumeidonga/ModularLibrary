package com.android.moduleviews.dialog;

import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.support.v7.app.AppCompatDialogFragment;

import com.android.modulcommons.utils.DVLogUtils;
import com.android.moduleviews.R;
import com.android.moduleviews.bean.DVDialogConfig;

public abstract class DVAbsBaseFrgDialog<T extends DVAbsBaseFrgDialog, V extends DVAbsBaseFrgDialog.Builder> extends AppCompatDialogFragment {
    protected static final String TAG = "base_bottom_dialog";
    private static final String KEY_LAYOUT_RES = "bottom_layout_res";
    private static final String KEY_HEIGHT = "bottom_height";
    private static final String KEY_DIM = "bottom_dim";
    private static final String KEY_CANCEL_OUTSIDE = "bottom_cancel_outside";


    protected ViewListener mViewListener;

    DVDialogConfig.DVFragmentDialogConfig dvFragmentDialogConfig;

    protected abstract T build(V builder) ;

    @LayoutRes
    public abstract int getLayoutRes();

    public abstract void onBindView(View view);

    /**
     * layout绑定后的回调
     * @param v
     */
    private void bindView(View v) {
        DVLogUtils.dt();
        onBindView(v);
        if (mViewListener != null) {
            mViewListener.bindView(v);
        }
    }

    //0
    protected void setBuild(Builder builder) {
        DVLogUtils.dt();
        dvFragmentDialogConfig = new DVDialogConfig.DVFragmentDialogConfig();
        dvFragmentDialogConfig.mIsCancelOutside = builder.mIsCancelOutside;
        dvFragmentDialogConfig.mLayoutRes = builder.mLayoutRes;
        dvFragmentDialogConfig.mFragmentTag = builder.mFragmentTag;
        dvFragmentDialogConfig.mDimAmount = builder.mDimAmount;
        dvFragmentDialogConfig.mAlpha = builder.mAlpha;
        dvFragmentDialogConfig.mTheme = builder.mTheme;
        dvFragmentDialogConfig.mHeight = builder.mHeight;
        dvFragmentDialogConfig.mWidth = builder.mWidth;
        dvFragmentDialogConfig.mGravity = builder.mGravity;
        dvFragmentDialogConfig.mFragmentManager = builder.mFragmentManager;
        this.mViewListener = builder.mViewListener;
    }

    // 1
    public void show() {

        Fragment fragment = dvFragmentDialogConfig.mFragmentManager.findFragmentByTag(TAG);
        if (fragment != null && fragment instanceof DVAbsBaseFrgDialog) {
            ((DVAbsBaseFrgDialog) fragment).dismissAllowingStateLoss();
        }

        if (getActivity() != null && getActivity().isFinishing()) {
            return ;
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            if (getActivity() != null && getActivity().isDestroyed()) {
                return ;
            }
        }
        if (dvFragmentDialogConfig.mFragmentManager != null && !dvFragmentDialogConfig.mFragmentManager.isDestroyed()) {
            try {
                if(isAdded()) {
                    dismissAllowingStateLoss();
                } else {
                    show(dvFragmentDialogConfig.mFragmentManager, getDialogFragmentTag());
                }
            } catch (Exception e) {
            }
        }

    }

    /**
     * 2
     * fragment tag
     * @return
     */
    public String getDialogFragmentTag() {
        DVLogUtils.dt();
        return dvFragmentDialogConfig.mFragmentTag;
    }

    //3
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DVLogUtils.dt();
        if (savedInstanceState != null) {
            dvFragmentDialogConfig.mLayoutRes = savedInstanceState.getInt(KEY_LAYOUT_RES);
            dvFragmentDialogConfig.mHeight = savedInstanceState.getInt(KEY_HEIGHT);
            dvFragmentDialogConfig.mDimAmount = savedInstanceState.getFloat(KEY_DIM);
            dvFragmentDialogConfig.mIsCancelOutside = savedInstanceState.getBoolean(KEY_CANCEL_OUTSIDE);
        }
        setStyle(DialogFragment.STYLE_NO_TITLE, dvFragmentDialogConfig.mTheme);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        DVLogUtils.dt();
        outState.putInt(KEY_LAYOUT_RES, dvFragmentDialogConfig.mLayoutRes);
        outState.putInt(KEY_HEIGHT, dvFragmentDialogConfig.mHeight);
        outState.putFloat(KEY_DIM, dvFragmentDialogConfig.mDimAmount);
        outState.putBoolean(KEY_CANCEL_OUTSIDE, dvFragmentDialogConfig.mIsCancelOutside);

        super.onSaveInstanceState(outState);
    }

    /**
     * 4
     * @param savedInstanceState
     * @return
     */
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        DVLogUtils.dt();
        return super.onCreateDialog(savedInstanceState);
    }

    /**
     * 5
     * 重写onCreateView创建Dialog
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        DVLogUtils.dt();
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getDialog().setCanceledOnTouchOutside(getCancelOutside());

        View v = inflater.inflate(getLayoutRes(), container, false);
        bindView(v);
        return v;
    }

    //6
    @Override
    public void onStart() {
        super.onStart();
        DVLogUtils.dt();

        Window window = getDialog().getWindow();
        WindowManager.LayoutParams params = window.getAttributes();

        params.alpha = getmAlpha();
        params.dimAmount = getmDimAmount();

        if (getmWidth() > 0) {
            params.width = getmWidth();
        } else {
            params.width = WindowManager.LayoutParams.MATCH_PARENT;
        }

        if (getmHeight() > 0) {
            params.height = getmHeight();
        } else {
            params.height = WindowManager.LayoutParams.WRAP_CONTENT;
        }

        params.gravity = getmGravity();

        window.setAttributes(params);
    }

    public int getmHeight() {
        DVLogUtils.dt();
        return dvFragmentDialogConfig.mHeight;
    }

    public int getmWidth() {
        DVLogUtils.dt();
        return dvFragmentDialogConfig.mWidth;
    }

    public float getmAlpha() {
        DVLogUtils.dt();
        return dvFragmentDialogConfig.mAlpha;
    }

    public float getmDimAmount() {
        DVLogUtils.dt();
        return dvFragmentDialogConfig.mDimAmount;
    }

    public int getmGravity() {
        DVLogUtils.dt();
        return dvFragmentDialogConfig.mGravity;
    }

    /**
     * 点击框框外面是否可取消
     * @return
     */
    public boolean getCancelOutside() {
        DVLogUtils.dt();
        return true;
    }

    public static abstract class Builder<T extends Builder<T>> {

        protected boolean mIsCancelOutside = true;

        @LayoutRes
        protected int mLayoutRes;

        protected int mTheme = R.style.dv_base_fragment_dialog_slide;

        protected String mFragmentTag = TAG;

        protected float mDimAmount = DVDialogConfig.DVFragmentDialogConfig.DIM_AMOUNT;

        protected float mAlpha = DVDialogConfig.DVFragmentDialogConfig.ALPHA;

        protected int mHeight = -1;

        protected int mWidth = -2;

        protected int mGravity = Gravity.CENTER;

        @Nullable
        protected FragmentManager mFragmentManager;

        protected DVBaseButtonDialog.ViewListener mViewListener;


        public T setmIsCancelOutside(boolean mIsCancelOutside) {
            this.mIsCancelOutside = mIsCancelOutside;
            return self();
        }

        public T setmLayoutRes(int mLayoutRes) {
            this.mLayoutRes = mLayoutRes;
            return self();
        }

        public T setmTheme(int mTheme) {
            this.mTheme = mTheme;
            return self();
        }

        public T setmFragmentTag(String mFragmentTag) {
            this.mFragmentTag = mFragmentTag;
            return self();
        }

        public T setmDimAmount(float mDimAmount) {
            this.mDimAmount = mDimAmount;
            return self();
        }

        public T setmAlpha(float mAlpha) {
            this.mAlpha = mAlpha;
            return self();
        }

        public T setmHeight(int mHeight) {
            this.mHeight = mHeight;
            return self();
        }

        public T setmWidth(int mWidth) {
            this.mWidth = mWidth;
            return self();
        }

        public T setmGravity(int mGravity) {
            this.mGravity = mGravity;
            return self();
        }

        public T setmFragmentManager(@Nullable FragmentManager mFragmentManager) {
            this.mFragmentManager = mFragmentManager;
            return self();
        }

        public T setmViewListener(ViewListener mViewListener) {
            this.mViewListener = mViewListener;
            return self();
        }

        private T self() {
            return (T) this;
        }

        public abstract DVAbsBaseFrgDialog build();
    }

    public interface ViewListener {
        void bindView(View v);
    }
}
