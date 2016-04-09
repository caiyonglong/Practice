package com.app.cyl.practice;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;

/**
 * Created by 永龙 on 2015/10/22.
 */
public class WebviewActivity extends Activity {
    private WebView myWebview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview);

        myWebview = (WebView) findViewById(R.id.webview);
        myWebview.getSettings().setJavaScriptEnabled(true);

        // 与js交互，JavaScriptinterface 是个接口，与js交互时用到的，这个接口实现了从网页跳到app中的activity 的方法，特别重要

        myWebview.addJavascriptInterface(new Javascriptinterface(this),"android");
        myWebview.loadUrl("http://119.29.27.116/hcyl/index.html");




    }
}
