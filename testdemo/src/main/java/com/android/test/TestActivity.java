package com.android.test;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

import com.android.modulcommons.utils.DVLogUtils;
import com.android.testdagger.DVActivityLifecycleCallbacks;
import com.android.testdagger.R;

import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TestActivity extends Activity {


    @BindView(R.id.bottom0)
    Button button0;
    @BindView(R.id.bottom1)
    Button button1;
    @BindView(R.id.bottom2)
    Button button2;
    @BindView(R.id.bottom3)
    Button button3;
    @BindView(R.id.bottom4)
    Button button4;
    @BindView(R.id.bottom5)
    Button button5;
    @BindView(R.id.bottom6)
    Button button6;
    @BindView(R.id.bottom7)
    Button button7;
    @BindView(R.id.bottom8)
    Button button8;
    @BindView(R.id.bottom9)
    Button button9;
    @BindView(R.id.bottom10)
    Button button10;
    @BindView(R.id.bottom11)
    Button button11;
    @BindView(R.id.bottom12)
    Button button12;
    @BindView(R.id.bottom13)
    Button button13;
    @BindView(R.id.bottom14)
    Button button14;
    @BindView(R.id.bottom15)
    Button button15;

    ZhiKeStrategy zhiKeStrategy;

    /** 广告请求返回的数据 */
    protected List<ApiFeedAd> mAdData;
    ZhiKeResponseEntity zhiKeResponseEntity;

    ApiFeedAd apiFeedAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        ButterKnife.bind(this);
        initda();
    }

    @Override
    protected void onStart() {
        super.onStart();
        // 判断是否从后台恢复, 且时间间隔符合要求, 显示广告页面
        boolean isFromBackToFront = DVActivityLifecycleCallbacks.sAppState == DVActivityLifecycleCallbacks.STATE_BACK_TO_FRONT;
        if (isFromBackToFront) {
            DVLogUtils.e("");
        }
    }
    private void initda(){
        try {
            zhiKeResponseEntity = ZhiKeStrategy.gson.fromJson(s, ZhiKeResponseEntity.class);
            DVLogUtils.dt(zhiKeResponseEntity);
        } catch (Exception e) {

        }
    }

    @OnClick(R.id.bottom0)
    public void begin(){

        zhiKeStrategy = new ZhiKeStrategy(zhiKeResponseEntity);
        mAdData = zhiKeStrategy.getBestFitData();
        di();
        DVLogUtils.dt(mAdData);
    }

    public void di(){
        if(mAdData.size() > 0) {
            apiFeedAd = mAdData.get(0);
            ZhiKeStrategy.saveZhikeFeedAdInfo(apiFeedAd);
        }
    }
    @OnClick(R.id.bottom1)
    public void begin1(){

        mAdData = zhiKeStrategy.getBestFitData();
        di();
        DVLogUtils.dt(mAdData);
    }
    @OnClick(R.id.bottom2)
    public void begin2(){

        mAdData = zhiKeStrategy.getBestFitData();
        di();
        DVLogUtils.dt(mAdData);
    }
    @OnClick(R.id.bottom3)
    public void begin3(){

        Random random = new Random();
        int r = random.nextInt(4);
        int pos = Math.abs(random.nextInt() % 4);
        DVLogUtils.dt(r);
        DVLogUtils.dt(pos);
    }
    @OnClick(R.id.bottom4)
    public void begin4(){

    }
    @OnClick(R.id.bottom5)
    public void begin5(){

    }

    public String s = "{    \"data\": {        \"list\": [            {                \"adv_id\": \"1\",                \"interval_time\": \"1\",                \"show_frequency\": \"1\"            },            {                \"adv_id\": \"2\",                \"interval_time\": \"2\",                \"show_frequency\": \"2\"            },            {                \"adv_id\": \"3\",                \"interval_time\": \"3\",                \"show_frequency\": \"3\"            },            {                \"adv_id\": \"4\",                \"interval_time\": \"4\",                \"show_frequency\": \"4\"            }        ]    }}";

}
