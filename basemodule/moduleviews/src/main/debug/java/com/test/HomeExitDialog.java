package com.test;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.moduleviews.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by Administrator on 2018/12/10.
 */
public class HomeExitDialog extends DialogFragment {
    protected static final String TAG = "base_bottom_dialog";
    private static final String KEY_LAYOUT_RES = "bottom_layout_res";
    private static final String KEY_HEIGHT = "bottom_height";
    private static final String KEY_DIM = "bottom_dim";
    private static final String KEY_CANCEL_OUTSIDE = "bottom_cancel_outside";

    /**
     * 设置幕布，也就是本dialog的背景层
     * dimAmount在0.0f和1.0f之间，0.0f完全不暗，即背景是可见的,透明的 ，1.0f时候，背景全部变黑
     * 如果要达到背景全部变暗的效果，需要设置  dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
     * ，否则，背景无效果
     */
    private static final float DIM_AMOUNT = 0.5f;

    /**
     * 设置透明度，主要设置的是dialog自身的透明度
     * alpha在0.0f到1.0f之间。1.0完全不透明，0.0f完全透明，自身不可见
     */
    private static final float ALPHA = 1.0f;

    /**
     * 点击框框外面是否可取消
     */
    protected boolean mIsCancelOutside = true;

    @LayoutRes
    protected int mLayoutRes;

    protected int mTheme = R.style.dv_base_fragment_dialog_slide;

    protected String mFragmentTag = TAG;

    protected float mDimAmount = DIM_AMOUNT;

    protected float mAlpha = ALPHA;

    protected int mHeight = -1;

    protected int mWidth = -2;

    protected int mGravity = Gravity.BOTTOM;

    protected FragmentManager mFragmentManager;
    DelayConfigResponse.LogoutSetting logoutsetting;

    public void setmFragmentManager(FragmentManager mFragmentManager) {
        this.mFragmentManager = mFragmentManager;
    }

    RelativeLayout exit_title_relativelayout;
    LinearLayout join_pop_layout;
    TextView exit_title;

    RelativeLayout home_activity_exit_content;
    ImageView user_fragment_icon;
    TextView user_fragment_title;

    TextView join_ok;
    TextView join_cancel;

    @LayoutRes
    public int getLayoutRes(){
        return R.layout.home_activity_exit_dialog;
    }

    @OnClick(R.id.join_ok)
    public void exits(){
        dismiss();
    }

    @OnClick(R.id.join_cancel)
    public void canceled(){
        dismiss();
    }
    @OnClick(R.id.home_activity_exit_content)
    public void jump(){
        dismiss();

        switch (logoutsetting.showStyle) {
            case 0://退出
                break;
            case 1://1 下载
                break;
            default:
                break;
        }
    }

    /**
     * layout绑定后的回调
     * @param v
     */
    private void bindView(View v) {
        switch (logoutsetting.showStyle) {
            case 0:
                home_activity_exit_content.setVisibility(View.GONE);
                RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) exit_title.getLayoutParams();
                params.addRule(Gravity.LEFT);
                params.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
                exit_title.setLayoutParams(params);

                RelativeLayout.LayoutParams params2 = (RelativeLayout.LayoutParams) join_pop_layout.getLayoutParams();
                params2.width = -1;
                join_pop_layout.setLayoutParams(params2);

                LinearLayout.LayoutParams params3 = (LinearLayout.LayoutParams) exit_title_relativelayout.getLayoutParams();
                params3.width = -1;
                exit_title_relativelayout.setLayoutParams(params3);

                break;
            case 1:

                RelativeLayout.LayoutParams params1 = (RelativeLayout.LayoutParams) exit_title.getLayoutParams();
                params1.addRule(RelativeLayout.CENTER_HORIZONTAL);
                exit_title.setLayoutParams(params1);

//                join_pop_layout.setBackground(getResources().getDrawable(R.drawable.round_white_bg));
                //join_pop_layout.setBackgroundResource(R.drawable.round_white_bg);

                break;
            default:
                break;
        }
    }

    // 1
    public void show(DelayConfigResponse.LogoutSetting logoutsetting) {
        this.logoutsetting = logoutsetting;
        if(isAdded()) {
            dismiss();
        } else {
            show(mFragmentManager, getDialogFragmentTag());
        }
    }

    /**
     * 2
     * fragment tag
     * @return
     */
    public String getDialogFragmentTag() {
        return mFragmentTag;
    }

    //3
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            mLayoutRes = savedInstanceState.getInt(KEY_LAYOUT_RES);
            mHeight = savedInstanceState.getInt(KEY_HEIGHT);
            mDimAmount = savedInstanceState.getFloat(KEY_DIM);
            mIsCancelOutside = savedInstanceState.getBoolean(KEY_CANCEL_OUTSIDE);
        }
        setStyle(DialogFragment.STYLE_NO_TITLE, mTheme);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt(KEY_LAYOUT_RES, mLayoutRes);
        outState.putInt(KEY_HEIGHT, mHeight);
        outState.putFloat(KEY_DIM, mDimAmount);
        outState.putBoolean(KEY_CANCEL_OUTSIDE, mIsCancelOutside);

        super.onSaveInstanceState(outState);
    }

    /**
     * 4
     * 重写onCreateView创建Dialog
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getDialog().setCanceledOnTouchOutside(getCancelOutside());

        View v = inflater.inflate(getLayoutRes(), container, false);

        home_activity_exit_content = v.findViewById(R.id.home_activity_exit_content);
        join_pop_layout = v.findViewById(R.id.join_pop_layout);

        exit_title_relativelayout = v.findViewById(R.id.exit_title_relativelayout);
        exit_title = v.findViewById(R.id.exit_title);
        home_activity_exit_content = v.findViewById(R.id.home_activity_exit_content);
        user_fragment_icon = v.findViewById(R.id.user_fragment_icon);
        user_fragment_title = v.findViewById(R.id.user_fragment_title);
        join_ok = v.findViewById(R.id.join_ok);
        join_cancel = v.findViewById(R.id.join_cancel);

        bindView(v);
        return v;
    }

    //5
    @Override
    public void onStart() {
        super.onStart();

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
        return mHeight;
    }

    public int getmWidth() {
        return mWidth;
    }

    public float getmAlpha() {
        return ALPHA;
    }

    public float getmDimAmount() {
        return DIM_AMOUNT;
    }

    public int getmGravity() {
        switch (logoutsetting.showStyle) {
            case 0:
                break;
            case 1:
                mGravity = Gravity.CENTER;
                break;
            default :
                break;
        }
        return mGravity;
    }

    /**
     * 点击框框外面是否可取消
     * @return
     */
    public boolean getCancelOutside() {
        return true;
    }
}
