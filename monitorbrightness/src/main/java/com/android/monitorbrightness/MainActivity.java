package com.android.monitorbrightness;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.modulcommons.utils.DVLogUtils;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView textSpacerNoTitle;
    TextView textSpacerNoTitle1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DVLogUtils.dt();
        Intent i = new Intent(this, MyService.class);
        startService(i);
    }

    @Override
    protected void onResume() {
        super.onResume();
        textSpacerNoTitle = findViewById(R.id.textSpacerNoTitle);
        textSpacerNoTitle1 = findViewById(R.id.textSpacerNoTitle1);
        textSpacerNoTitle.setOnClickListener(this);
        textSpacerNoTitle1.setOnClickListener(this);
    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.textSpacerNoTitle:
                DVLogUtils.dt();

                Intent intent = new Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS,
                        Uri.parse("package:" + getPackageName()));
                ComponentName componentName = intent.resolveActivity(getPackageManager());
                if (componentName != null) {
                    startActivity(intent);
                }
                break;
            case R.id.textSpacerNoTitle1:

                Intent i = new Intent(getApplicationContext(), Main2Activity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getApplicationContext().startActivity(i);
                break;
        }
    }
}
