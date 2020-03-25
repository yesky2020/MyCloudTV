package com.example.mycloudtv.js;

import android.app.Activity;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

import java.lang.ref.WeakReference;

public class JSInterface {
    WeakReference<Activity> weakReference;

    public JSInterface(Activity context) {
        this.weakReference = new WeakReference<>(context);
    }

    @JavascriptInterface
    public void ShowToast(String msg) {
        Toast.makeText(weakReference.get(), msg, Toast.LENGTH_LONG).show();
    }
}
