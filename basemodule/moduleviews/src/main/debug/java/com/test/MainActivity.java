package com.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;

import com.android.modulcommons.file.FileManager;
import com.android.moduleviews.R;
import com.android.moduleviews.dialog.DVBaseButtonDialog;
import com.android.moduleviews.dialog.DVButtonDialog;
import com.android.moduleviews.popwindow.SelectPicPopupWindow;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.show_dialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
                //shareDialog();

            }
        });
        findViewById(R.id.show_dialog1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SelectPicPopupWindow picPopupWindow = new SelectPicPopupWindow(MainActivity.this, null);
                picPopupWindow.showAtLocation(findViewById(R.id.show_dialog1), Gravity.BOTTOM, 100, 100);

            }
        });
        findViewById(R.id.show_dialog2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*new DVButtonDialog.Builder().
                        setmFragmentManager(getSupportFragmentManager())
                        .setmDimAmount(0.5f)
                        .setmAlpha(0.5f)
                        .setmIsCancelOutside(true)
                        .setmFragmentTag("DVButtonDialog")
                        .build()
                        .show();*/

                DelayConfigResponse.LogoutSetting logoutsetting = new DelayConfigResponse.LogoutSetting();
                HomeExitDialog homeExitDialog = new HomeExitDialog();
                homeExitDialog.setmFragmentManager(getSupportFragmentManager());
                logoutsetting.showStyle = 0;
                homeExitDialog.show(logoutsetting);

            }
        });

    }

    private void shareDialog() {
        //ShareButtonDialog dialog = new ShareButtonDialog();
        //dialog.show(getSupportFragmentManager());
        EditTextDialog dialog = new EditTextDialog();
        dialog.show();
    }

    private void showDialog() {

        /*new DVBaseButtonDialog.Builder().
                setmFragmentManager(getSupportFragmentManager())
                .setmLayoutRes(R.layout.dialog_layout)
                .setmViewListener(new DVBaseButtonDialog.ViewListener() {
                    @Override
                    public void bindView(View v) {
                        initView(v);
                    }
                })
                .setmDimAmount(0.5f)
                .setmAlpha(0.9f)
                .setmIsCancelOutside(true)
                .setmFragmentTag("DVBaseButtonDialog")
                .build()
                .show();*/


        DelayConfigResponse.LogoutSetting logoutsetting = new DelayConfigResponse.LogoutSetting();
        HomeExitDialog homeExitDialog = new HomeExitDialog();
        homeExitDialog.setmFragmentManager(getSupportFragmentManager());
        logoutsetting.showStyle = 1;
        homeExitDialog.show(logoutsetting);



    }

    private void initView(final View view) {
        //final EditText editText = (EditText) view.findViewById(R.id.edit_text);
        //editText.post(new Runnable() {
        //    @Override
        //    public void run() {
        //        InputMethodManager inputMethodManager =
        //                (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        //        inputMethodManager.showSoftInput(editText, InputMethodManager.SHOW_IMPLICIT);
        //    }
        //});
        //editText.setText("Hello world");
    }
}
