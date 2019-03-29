package com.android.testdesignmodel.builder;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.modulcommons.utils.DVLogUtils;
import com.android.testdagger.DVActivityLifecycleCallbacks;
import com.android.testdagger.R;
import com.android.testdesignmodel.module.Computer;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BuilderActivity extends Activity {

    @BindView(R.id.editText)
    EditText editText;
    @BindView(R.id.editText1)
    EditText editText1;
    @BindView(R.id.editText2)
    EditText editText2;

    @BindView(R.id.button2)
    Button button;
    @BindView(R.id.button3)
    Button button3;
    @BindView(R.id.textView3)
    TextView textView3;

    StringBuilder sb = new StringBuilder();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_builder);
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
    public int i ;
    @OnClick(R.id.button2)
    public void button2(){
        Customer customer = new Customer();
        Computer computer = customer.buyComputer(i, editText.getText().toString() + i, editText1.getText().toString() + i, editText2.getText().toString() + i);

        sb.append(computer.toString());
        sb.append("\r\n");

        textView3.setText(sb.toString());
        i++;
    }
    @OnClick(R.id.button3)
    public void button3(){
        Customer customer = new Customer();
        Computer computer = customer.buyComputer();

        sb.append(computer.toString());
        sb.append("\r\n");

        textView3.setText(sb.toString());
    }
}
