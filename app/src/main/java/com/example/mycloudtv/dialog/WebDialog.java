package com.example.mycloudtv.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.webkit.WebView;

import com.example.mycloudtv.R;
import com.example.mycloudtv.js.JSInterface;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class WebDialog extends Dialog {
    WebView webView;
    Context mContex;

    public WebDialog(@NonNull Context context) {
        super(context, R.style.MyDialog);
        mContex = context;
    }

    public WebDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
        mContex = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_web);
        webView = findViewById(R.id.webView);
        webView.removeJavascriptInterface("searchBoxJavaBridge_");

        // 初始化界面数据
        initData();
    }

    private void initData() {
        if (null != webView)
            webView.loadUrl("file:///schdual/schedual_report.html");
//            webView.loadUrl("http://www.nipic.com/show/10854185.html");

        webView.addJavascriptInterface(new JSInterface((Activity) mContex), "android");
        webView.loadUrl("javascript:androidCallJs()");
        webView.loadUrl("file:///schdual/schedual_report.html");
    }
}
