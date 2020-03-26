package com.example.mycloudtv;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.example.mycloudtv.js.JSInterface;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 排班管理
 */
public class ShiftManageFragment extends Fragment {
    Context mContext;
    @BindView(R.id.webView)
    WebView webView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        ButterKnife.bind(this,view);
        mContext = getContext();
        initData();
        return view;
    }

    private void initData() {
        webView.getSettings().setJavaScriptEnabled(true);
        webView.addJavascriptInterface(new JSInterface(getActivity()), "android");
        webView.loadUrl("file:///android_asset/schdual/schedual_report.html");
        questData("你好");
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    private void questData(String data) {
        webView.loadUrl("javascript:androidCallJs("+data+")");
    }
}
