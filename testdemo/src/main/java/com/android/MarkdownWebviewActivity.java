package com.android;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.webkit.WebView;

import com.android.modulcommons.utils.DVLogUtils;
import com.android.testdagger.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MarkdownWebviewActivity extends Activity {

    @BindView(R.id.md_webview)
    WebView webView;

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            try {
                String s = MarkdownUtils.getData(MarkdownWebviewActivity.this);
                webView.loadUrl("javascript:marked(\'"+ s +"\')");
            } catch (Exception e) {
                DVLogUtils.e(e, e.toString());
            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_markdown_webview);
        ButterKnife.bind(this);

        webView.getSettings().setDefaultTextEncodingName("UTF-8");
        webView.getSettings().setJavaScriptEnabled(true);

        webView.loadUrl("file:///android_asset/index.html");
        //显示MarkDown文本时，将MarkDown文本从文件中读入，变为字符串data，执行
        //WebView不显示任何内容,发生这个问题，有很大概率是进行了在WebView执行加载HTML文件后，
        // 马上执行解析步骤这种操作, 这两个步骤不要同时进行
        //webView.loadUrl("javascript:marked(\'"+MarkdownUtils.getData()+"\')");

    }

    @Override
    protected void onResume() {
        super.onResume();
        handler.sendEmptyMessageDelayed(0, 1000);
    }
}
