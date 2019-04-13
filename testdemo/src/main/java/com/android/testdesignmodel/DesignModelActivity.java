package com.android.testdesignmodel;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.android.MarkdownUtils;
import com.android.modulcommons.utils.DVLogUtils;
import com.android.testdagger.DVActivityLifecycleCallbacks;
import com.android.testdagger.R;
import com.android.testdesignmodel.adapter.Adapter;
import com.android.testdesignmodel.adapter.AdapterActivity;
import com.android.testdesignmodel.adapter.ITarget;
import com.android.testdesignmodel.adapter.ThreeAdaptee;
import com.android.testdesignmodel.builder.BuilderActivity;
import com.android.testdesignmodel.facade.FacadeActivity;
import com.android.testdesignmodel.factory.FactoryActivity;
import com.android.testdesignmodel.lianshi.BaseHandlerResult;
import com.android.testdesignmodel.lianshi.LianShiA;
import com.android.testdesignmodel.lianshi.LianShiB;
import com.android.testdesignmodel.proxy.ProxyActivity;
import com.android.testdesignmodel.strategy.DVStrategyA;
import com.android.testdesignmodel.strategy.DVStrategyB;
import com.android.testdesignmodel.strategy.IDVStrategy;
import com.android.testdesignmodel.strategy.StragetyFactory;
import com.android.testdesignmodel.template.ABSKuaiDi;
import com.android.testdesignmodel.template.PostToA;
import com.android.testdesignmodel.template.PostToB;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class DesignModelActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_design_model);
        ButterKnife.bind(this);
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
    @OnClick(R.id.bottom)
    public void begin0(){
        MarkdownUtils.setData(this, "testdesignmodel/设计模式.MD");
    }
    @OnClick(R.id.fadedddd)
    public void fadedddd(){
        MarkdownUtils.setData(this, "testdesignmodel/结构设计模式区别.MD");
    }
    @OnClick(R.id.bottom0)
    public void begin(){
        startActivitys(BuilderActivity.class);
    }
    @OnClick(R.id.bottom1)
    public void begin1(){
        startActivitys(FactoryActivity.class);
    }
    @OnClick(R.id.bottom2)
    public void begin2(){
        MarkdownUtils.setData(this, "testdesignmodel/singleton/单例.md");
    }
    @OnClick(R.id.bottom3)
    public void begin3(){
        startActivitys(ProxyActivity.class);
    }
    @OnClick(R.id.bottom4)
    public void begin4(){

        startActivitys(FacadeActivity.class);
    }
    @OnClick(R.id.bottom5)
    public void begin5(){

        IDVStrategy idvStrategy = new DVStrategyA();
        IDVStrategy idvStrategyb = new DVStrategyB();
        idvStrategy.strategy();
        idvStrategyb.strategy();

//        DVLogUtils.d(StragetyFactory.getInstance().strategy(0));
        StragetyFactory.getInstance().strategy(0).strategy();
        MarkdownUtils.setData(this, "testdesignmodel/strategy/策略模式.md");

    }
    @OnClick(R.id.bottom7)
    public void begin7(){
        ITarget target = new Adapter();
        ((Adapter) target).setIAdaptee(new ThreeAdaptee());
        target.charge();

        startActivitys(AdapterActivity.class);

    }
    @OnClick(R.id.muban)
    public void muban(){
        DVLogUtils.d("----派送A----");
        ABSKuaiDi postA=new PostToA();
        postA.post();
        DVLogUtils.d("----派送B----");
        ABSKuaiDi postB=new PostToB();
        postB.post();
        MarkdownUtils.setData(this, "testdesignmodel/template/模板.MD");
    }

    @OnClick(R.id.bottom6)
    public void begin6(){

        MarkdownUtils.setData(this, "testdesignmodel/template/装饰.MD");
    }

    public boolean isClick ;
    @OnClick(R.id.bottom8)
    public void begin8(){

        String url;
        if(!isClick) {
            url = "";
            isClick = true;
        } else {
            url = "test";
            isClick = false;
        }

        BaseHandlerResult handlerResultA = new LianShiA();
        BaseHandlerResult handlerResultB = new LianShiB();
        handlerResultA.setmNextHandler(handlerResultB);

        handlerResultA.handleResult(url);




        MarkdownUtils.setData(this, "testdesignmodel/lianshi/链式.MD");
    }

    public <T> void startActivitys(Class<T> tClass){
        startActivity(new Intent(this, tClass));
    }
}
