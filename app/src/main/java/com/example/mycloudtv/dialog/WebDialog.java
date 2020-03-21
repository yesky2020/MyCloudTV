package com.example.mycloudtv.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.webkit.WebView;

import com.example.mycloudtv.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class WebDialog extends Dialog {
    WebView webView;

    public WebDialog(@NonNull Context context) {
        super(context, R.style.MyDialog);
    }

    public WebDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_web);
        webView =findViewById(R.id.webView);
        webView.removeJavascriptInterface("searchBoxJavaBridge_");

        // 初始化界面数据
        initData();
    }

    private void initData() {
        if(null !=webView)
        webView.loadUrl("http://www.nipic.com/show/10854185.html");
    }
}
