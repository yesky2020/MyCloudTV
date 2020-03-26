package com.example.mycloudtv;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Toast;


import com.example.mycloudtv.js.JSInterface;

import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

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
        ButterKnife.bind(this, view);
        mContext = getContext();
        initData();
        return view;
    }

    private void initData() {
        webView.getSettings().setJavaScriptEnabled(true);
        webView.addJavascriptInterface(new JSInterface(getActivity()), "android");
        webView.loadUrl("file:///android_asset/schdual/schedual_report.html");

    }

    @Override
    public void onResume() {
        super.onResume();
        loadData();
    }

    private void loadData() {
        String url = "/plat/andtv/schedualReport?token=" + MyApplication.getInstance().getUserInfo().data.token;
//        String url1 = "/plat/andtv/machineTarget?schedule_name=11&current_time=2020-03-26&token=" + MyApplication.getInstance().getUserInfo().data.token;
        EasyHttp.get(url).baseUrl("https://m.danfoo.com")
                .readTimeOut(10 * 1000)//局部定义读超时
                .writeTimeOut(10 * 1000)
                .connectTimeout(10 * 1000)
                .timeStamp(true)
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                        Toast.makeText(getContext(), "加载失败", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onSuccess(String s) {

                        if (s.contains("OK")) {
                            questData(s);
                        }
                    }
                });
    }

    private void questData(String data) {
        webView.loadUrl("javascript:androidCallJs(" + data + ")");
    }
}
