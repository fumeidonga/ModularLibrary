package com.android.testdesignmodel.factory;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.android.modulcommons.utils.DVLogUtils;
import com.android.testdagger.DVActivityLifecycleCallbacks;
import com.android.testdagger.R;
import com.android.testdesignmodel.factory.abstractfactory.AbsFactory;
import com.android.testdesignmodel.factory.factory.AFactory;
import com.android.testdesignmodel.factory.factory.AbstractFactory;
import com.android.testdesignmodel.factory.factory.BFactory;
import com.android.testdesignmodel.factory.simplefactory.SimpleFactory;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FactoryActivity extends Activity {

    @BindView(R.id.button4)
    Button button4;
    @BindView(R.id.button5)
    Button button5;
    @BindView(R.id.button6)
    Button button6;

    @BindView(R.id.textView4)
    TextView textView4;
    @BindView(R.id.textView5)
    TextView textView5;
    @BindView(R.id.textView6)
    TextView textView6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factory);
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

    @OnClick(R.id.button4)
    public void button4(){
        StringBuilder sb = new StringBuilder();

        sb.append("简单工厂\n");
        sb.append(SimpleFactory.getComputer(0).toString());
        sb.append("\n\n");
        sb.append(SimpleFactory.getComputer(1).toString());

        textView4.setText(sb.toString());

    }
    @OnClick(R.id.button5)
    public void button5(){

        AbstractFactory abstractFactory = new AFactory();
        AbstractFactory abstractFactory1 = new BFactory();

        StringBuilder sb = new StringBuilder();

        sb.append("工厂\n");
        sb.append(abstractFactory.buildComputer().toString());
        sb.append("\n\n");
        sb.append(abstractFactory1.buildComputer().toString());

        textView5.setText(sb.toString());
    }
    @OnClick(R.id.button6)
    public void button6(){

        AbsFactory abstractFactory = new com.android.testdesignmodel.factory.abstractfactory.AFactory();
        AbsFactory abstractFactory1 = new com.android.testdesignmodel.factory.abstractfactory.BFactory();


        StringBuilder sb = new StringBuilder();

        sb.append("抽象工厂\n");
        sb.append(abstractFactory.createKey().build().toString());
        sb.append("\n");
        sb.append(abstractFactory.createMouse().build().toString());
        sb.append("\n\n");
        sb.append(abstractFactory1.createKey().build().toString());
        sb.append("\n");
        sb.append(abstractFactory1.createMouse().build().toString());

        textView6.setText(sb.toString());
    }
}
