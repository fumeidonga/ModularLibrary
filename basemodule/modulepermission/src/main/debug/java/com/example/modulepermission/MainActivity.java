package com.example.modulepermission;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.modulcommons.utils.DVLogUtils;
import com.example.modulepermission.rom.MiuiUtil;

public class MainActivity extends Activity implements View.OnClickListener {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.test);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (!DVFloatPerMissionUtil.getInstance().checkFloatWindowPermission(this)) {
            DVPermissionsManager.DialogType dialogType =  new DVPermissionsManager.DialogType(1, "", "去设置", false, false);

            DVPermissionsManager.showTipsDialog(this, dialogType, DVPermissionsManager.PERMISSION_OVERLAY, new DVPermissionsManager.PermissionSettingListener() {
                //从设置界面回来的回调
                @Override
                public void settingsBack(int type) {
                    DVLogUtils.dt();
                    if (!DVFloatPerMissionUtil.getInstance().checkFloatWindowPermission(MainActivity.this)) {

                    }
                }

                //取消按钮的回调
                @Override
                public void cancelBtnClick() {
                    DVLogUtils.dt();
                    //MiuiUtil.applyMiuiPermission(MainActivity.this);
                    DVFloatPerMissionUtil.getInstance().applyPermission(MainActivity.this);
                }
            });
        }
    }
}
