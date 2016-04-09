package com.app.cyl.practice;

import android.app.Activity;
import android.content.Intent;

/**
 * Created by 永龙 on 2015/10/22.
 */
public class Javascriptinterface {
    Activity mActivity;
    public Javascriptinterface(WebviewActivity webviewActivity) {
        this.mActivity=webviewActivity;
        startActivity();
    }
    /** 与js交互时用到的方法，在js里直接调用的 */
    public void startActivity(){
        Intent intent= new Intent();
        intent.setClass(mActivity,Login.class);
        mActivity.startActivity(intent);
        mActivity.finish();

    }
}
