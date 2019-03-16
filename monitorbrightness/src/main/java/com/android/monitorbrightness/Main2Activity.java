package com.android.monitorbrightness;

import android.app.Activity;
import android.os.Bundle;

import com.android.modulcommons.utils.DVDevicesUtils;
import com.android.modulcommons.utils.DVLogUtils;

public class Main2Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DVLogUtils.dt();
        setContentView(R.layout.activity_main2);
        DVDevicesUtils.setScreenBrightness(this, 35);
    }
}
